package com.glory.learning.consumer.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用socket服务段
 *
 * @author Glory
 * @create 2020-03-22 23:49
 **/
class MultiplexSocketServer {

    private static Selector selector;
    private Charset charset = StandardCharsets.UTF_8;

    static {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MultiplexSocketServer() throws IOException {
        init();
    }

    public static void main(String[] args) throws IOException {
        MultiplexSocketServer server = new MultiplexSocketServer();
        server.select();
    }

    public void init() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().setSoTimeout(5000);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8383));
        //serverSocketChannel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void select() throws IOException {
        System.out.println("服务启动...");
        while (selector.select() > 0) {
            Set keys = selector.selectedKeys();
            Iterator it = keys.iterator();
            while (it.hasNext()) {

                SelectionKey key = (SelectionKey) it.next();
                it.remove();
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isWritable()) {
                    write(key);
                } else if (key.isReadable()) {
                    receive(key);
                }
            }
        }
    }

    private void accept(SelectionKey key) throws IOException {
        SocketChannel socketChannel;
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        InetSocketAddress local = (InetSocketAddress) channel.socket().getLocalSocketAddress();
        String host = local.getHostName();
        int port = local.getPort();
        System.out.println(String.format("socket_conn: host=%s, port=%s", host, port));
    }

    private void write(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        InetSocketAddress local = (InetSocketAddress) channel.socket().getRemoteSocketAddress();
        String host = local.getHostName();
        String msg = "收到数据，谢谢的反馈";
        System.out.println(String.format("socket_write: host=%s, %s", host, msg));
        channel.write(charset.encode(msg));
        key.interestOps(SelectionKey.OP_READ);
    }

    private void receive(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();
        String data = charset.decode(buffer).toString();
        if ("关闭链接".equals(data)) {
            key.cancel();
            channel.close();
            return;
        }

        System.out.println(String.format("socket_read: msg=%s", data));
    }
}