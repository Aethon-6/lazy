package com.lazy.common.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author : yangwx
 * @description :
 * @createDate : 2024/12/5
 */
public class CryptoKit {
    /**
     * MD5加密
     */
    public static class Md5 {

        /**
         * 使用MD5算法对字符串进行加密
         *
         * @param dataStr 待加密的字符串
         * @return 加密后的MD5散列值，以十六进制字符串形式返回
         * <p>
         * 此方法说明了MD5加密的过程，包括创建MD5加密实例、执行加密操作、
         * 将散列值转换为十六进制以及返回最终的加密结果如果无法创建MD5实例，
         * 将抛出RuntimeException异常
         */
        public static String encrypt(String dataStr) {
            try {
                // 创建MD5加密实例
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                // 执行加密操作
                byte[] messageDigest = md5.digest(dataStr.getBytes());

                // 将得到的散列值转换为十六进制
                StringBuilder sb = new StringBuilder();
                for (byte b : messageDigest) {
                    sb.append(String.format("%02x", b));
                }

                // 返回MD5散列值
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
