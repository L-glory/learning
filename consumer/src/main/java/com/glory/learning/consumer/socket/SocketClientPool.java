package com.glory.learning.consumer.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Glory
 * @create 2020-03-23 20:38
 **/
public class SocketClientPool {

    private Charset charset = StandardCharsets.UTF_8;

    class WriteThread implements Runnable {
        private SelectionKey key;

        public WriteThread(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            Socket socket = socketChannel.socket();
            try {
                socketChannel.finishConnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InetSocketAddress remote = (InetSocketAddress) socket.getRemoteSocketAddress();
            String host = remote.getHostName();
            int port = remote.getPort();
            System.out.println(String.format("socket_conn: host=%s, port=%d", host, port));
        }
    }

    class ReadThread implements Runnable {
        private SelectionKey key;

        public ReadThread(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            try {
                socketChannel.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.flip();
            String receiveData = null;
            try {
                receiveData = new String(buffer.array(), charset);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if ("".equals(receiveData)) {
                key.cancel();
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }

            System.out.println(receiveData);
        }
    }

    class ConnectThread implements Runnable {
        private SelectionKey key;

        public ConnectThread(SelectionKey key) {
            this.key = key;
        }

        @Override
        public void run() {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer byteBuffer = charset.encode("hello world");
            try {
                socketChannel.write(byteBuffer);
                System.out.println("hello world");
            } catch (IOException e) {
                e.printStackTrace();
            }
            key.interestOps(SelectionKey.OP_READ);
        }
    }

    public void startClient() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            SocketChannel socketChannel = SocketChannel.open();
            Selector selector = Selector.open();
            socketChannel.configureBlocking(false);
            InetSocketAddress address = new InetSocketAddress(1234);
            socketChannel.connect(address);
            socketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            while (selector.select() > 0) {
                Iterator keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = (SelectionKey) keys.next();
                    if (key.isConnectable()) {
                        executorService.submit(new ConnectThread(key));
                    } else if (key.isReadable()) {
                        executorService.submit(new ReadThread(key));
                    } else {
                        executorService.submit(new WriteThread(key));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketClientPool client = new SocketClientPool();
        client.startClient();
    }
}
