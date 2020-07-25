package com.glory.learning.commons.api;

import com.glory.learning.commons.rpc.RespDTO;

/**
 * Jvm云服务
 *
 * @author Glory
 * @create 2020-04-07 23:07
 **/
public interface JvmCloudService {

    /**
     * 根据全限定名获取java文件
     * @param fullQualifiedName
     * @return
     */
    RespDTO<String> getJavaFile(String fullQualifiedName);

    /**
     * 根据全限定名获取class文件
     * @param fullQualifiedName
     * @param version    jdk版本，eg：jdk1.6=6、jdk1.7=7、jdk8=8 ... jdk11=11
     * @return
     */
    RespDTO<String> getClassFile(String fullQualifiedName, int version);
}
