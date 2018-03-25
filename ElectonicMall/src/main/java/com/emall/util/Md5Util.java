package com.emall.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class Md5Util {
    private static final BASE64Encoder ENCODER = new BASE64Encoder();
    private static final Log log = LogFactory.getLog(Md5Util.class);

    /**
     * 获取十六进制字符串形式的MD5摘要
     * @param src
     *      需要加密的字符串
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes("utf-8"));
            return ENCODER.encode(bs);
        } catch (Exception e) {
            return null;
        }
    }
}
