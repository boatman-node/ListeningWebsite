package com.pool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SaltedEncryption {

    public static String encryptWithSalt(String data, String salt) {
        try {
            // 将盐值与原始数据拼接
            String saltedData = data + salt;

            // 创建 MessageDigest 对象，指定加密算法为 SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // 计算摘要
            byte[] digest = messageDigest.digest(saltedData.getBytes());

            // 将摘要转换为十六进制字符串
            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
