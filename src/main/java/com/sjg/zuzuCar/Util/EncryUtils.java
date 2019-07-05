package com.sjg.zuzuCar.Util;

/*
 * Copyright (c) 2014, Nick Xu, All rights reserved.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.*;


/**
 * 功能简述: 加密解密工具类，对MD5/BASE64/DES/RSA等算法提供了包装.
 * @author Nick Xu
 * @version 1.0
 */
public class EncryUtils {
    private static Log logger = LogFactory.getLog(EncryUtils.class);

    private static final int KEY_SIZE = 1025;
    private static final String  MD5_ALGORITHM= "md5";
    private static final String  DES_ALGORITHM= "des";
    private static final String  RSA_ALGORITHM= "rsa";
    private static final String  SIGNATURE_ALGORITHM= "MD5withRSA";

    private static MessageDigest md5;
    private static SecureRandom random;
    private static KeyPair keyPair;

    private EncryUtils() {
    }

    static {
        try {
            md5 = MessageDigest.getInstance(MD5_ALGORITHM);

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA_ALGORITHM);
            keyPairGenerator.initialize(KEY_SIZE);
            keyPair = keyPairGenerator.generateKeyPair();
        }
        catch (NoSuchAlgorithmException e) {
            // Exception handler
            logger.error(e);
        }

        random = new SecureRandom();
    }

    /**
     *  功能简述: 使用md5进行单向加密.
     *  单向加密算法，只能加密、无法解密。
     *  已经被成功破译
     *  在安全性要求不高的场景下，仍然具有应用价值
     */
    public static String encryptMD5(String plainText) {
        byte[] cipherData = md5.digest(plainText.getBytes());
        StringBuilder builder = new StringBuilder();
        for(byte cipher : cipherData) {
            String toHexStr = Integer.toHexString(cipher & 0xff);
            builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);
        }
        return builder.toString();
    }


    /**
     *  功能简述: 使用DES算法进行加密.
     *  数据加密标准算法
     *  要求密钥是一个长度至少大于8位的字符串
     *  需要确保工作密钥的安全性
     *  @param plainData 明文数据
     *  @param key   加密密钥
     *  @return
     */
    public static byte[] encryptDES(byte[] plainData, String key) {
        return processCipher(plainData, createSecretKey(key), Cipher.ENCRYPT_MODE, DES_ALGORITHM);
    }

    /**
     * 功能简述: 使用DES算法进行解密.
     * @param cipherData    密文数据
     * @param key   解密密钥
     * @return
     */
    public static byte[] decryptDES(byte[] cipherData, String key) {
        return processCipher(cipherData, createSecretKey(key), Cipher.DECRYPT_MODE, DES_ALGORITHM);
    }

    /**
     * 功能简述: 根据key创建密钥SecretKey.
     * @param key
     * @return
     */
    private static SecretKey createSecretKey(String key) {
        SecretKey secretKey = null;
        try {
            DESKeySpec keySpec = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
            secretKey = keyFactory.generateSecret(keySpec);
        }
        catch (Exception e) {
            // Exception handler
            logger.error(e);
        }
        return secretKey;
    }

    /**
     * 功能简述: 加密/解密处理流程.
     * @param processData   待处理的数据
     * @param key   提供的密钥
     * @param opsMode   工作模式
     * @param algorithm   使用的算法
     * @return
     */
    private static byte[]   processCipher(byte[] processData, Key key, int opsMode, String algorithm) {
        try{
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(opsMode, key, random);
            return cipher.doFinal(processData);
        }
        catch (Exception e) {
            // Exception handler
            logger.error(e);
        }
        return null;
    }

    /**
     * 功能简述: 创建私钥，用于RSA非对称加密.
     * @return
     */
    public static PrivateKey createPrivateKey() {
        return keyPair.getPrivate();
    }

    /**
     * 功能简述: 创建公钥，用于RSA非对称加密.
     * @return
     */
    public static PublicKey createPublicKey() {
        return keyPair.getPublic();
    }

    /**
     * 功能简述: 使用RSA算法加密.
     * RSA算法是非对称加密算法的典型代表
     * 既能加密、又能解密
     * 公钥加密只能私钥解密；私钥加密只能公钥解密(这里只使用私钥加密)
     * 只要密钥足够长(一般要求1024bit)，加密的信息是不能被破解的
     * @param plainData 明文数据
     * @param key   密钥
     * @return
     */
    public static byte[] encryptRSA(byte[] plainData, Key key) {
        return processCipher(plainData, key, Cipher.ENCRYPT_MODE, RSA_ALGORITHM);
    }

    /**
     * 功能简述: 使用RSA算法解密.
     * @param cipherData    密文数据
     * @param key   密钥
     * @return
     */
    public static byte[] decryptRSA(byte[] cipherData, Key key) {
        return processCipher(cipherData, key, Cipher.DECRYPT_MODE, RSA_ALGORITHM);
    }

    /**
     * 功能简述: 使用私钥对加密数据创建数字签名.
     * @param cipherData     已经加密过的数据
     * @param privateKey    私钥
     * @return
     */
    public static byte[] createSignature(byte[] cipherData, PrivateKey privateKey) {
        try {
            Signature signature  = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateKey);
            signature.update(cipherData);
            return signature.sign();
        }
        catch (Exception e) {
            // Exception handler
            logger.error(e);
        }
        return null;
    }

    /**
     * 功能简述: 使用公钥对数字签名进行验证.
     * @param signData  数字签名
     * @param publicKey 公钥
     * @return
     */
    public static boolean verifySignature(byte[] cipherData, byte[] signData, PublicKey publicKey) {
        try {
            Signature signature  = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(publicKey);
            signature.update(cipherData);
            return signature.verify(signData);
        }
        catch (Exception e) {
            // Exception handler
            logger.error(e);
        }
        return false;
    }
}