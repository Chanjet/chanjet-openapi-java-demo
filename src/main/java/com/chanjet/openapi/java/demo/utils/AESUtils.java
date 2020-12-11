package com.chanjet.openapi.java.demo.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * AES加解密工具类
 */
public class AESUtils {

    /**
     * aes加密
     *
     * @param str 需要加密的字符串
     * @param key 加密的秘钥
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String aesEncrypt(String str, String key) throws Exception {
        if (str == null || key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
        return Base64.encodeBase64String(bytes);
    }

    /**
     * aes解密
     *
     * @param str 需要解密的字符串
     * @param key 解密的秘钥
     * @return 解密后的字符串
     * @throws Exception
     */
    public static String aesDecrypt(String str, String key) throws Exception {
        if (str == null || key == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES"));
        byte[] bytes = Base64.decodeBase64(str);
        bytes = cipher.doFinal(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }


    public static void main(String[] args) {
        String content = "{\"id\":\"75e9456ac5ee43ebb0a0a26a3a7d7da5\",\"appKey\":\"ptPrU0YV\",\"msgType\":\"REFUND\",\"time\":\"1605167299197\",\"bizContent\":{\"payOrderId\":\"isvtesta00s1hor8dsqerkkk\",\"refundOrderId\":\"isvtesta00s1hor8dsqerkkk666\",\"refundAmount\":\"1\",\"totalAmount\":\"1\",\"operator\":\"21q\",\"thirdOrderId\":\"202011123001723253\",\"merchanId\":\"E2020052200035\",\"bookId\":\"1221659663138816\"}}";
        System.out.println("加密前：" + content);
        String key = "9876543210987654";
        System.out.println("加密密钥和解密密钥：" + key);
        try {
            String encrypt = aesEncrypt(content, key);
            System.out.println("加密后：" + encrypt);
//            String str = " Ww/5c2K+8uJS8F9Z2Gsi3fDvHEhsUNktFRyJZdjSqjeGV8SzbnCiv2oSwRoTft2T6NsHviUS3zHqYwvKVsgOfNR6QVOzerfB+9LekYqf4iGp+D7kKA+v2MxPl84gWB7yJAa10JjEkzZkcb3SL9kLE5ngmJ6furfOXMbls4jg07CN2TaokUDrQudvpX6yAKoEvAHmV2KJBrk/1g/AjxVtSt8rp0Dn/rQn/c1gUVA6cgs9PKhOEXS/M50xxIatrc17Uv+OCdLpmpmJNeL87DtkBftwDnQhIq2EWc7pIWvi1SUxBwMpAIiIieWiHCHxFMvU";
//            String decrypt = aesDecrypt(str, "testchaotestchao");
            String decrypt = aesDecrypt(encrypt, key);
            System.out.println("解密后：" + decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}