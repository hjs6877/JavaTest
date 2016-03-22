package com.soom.security;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ideapad on 2016-03-21.
 */
public class AESTest {
    @Test
    public void encryptAESTest() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128);

        Key key = generator.generateKey();


        byte[] keyBytes = key.getEncoded();
        String base64EncodedKey = Base64.encodeBase64URLSafeString(keyBytes);
        System.out.println(String.format("Key : %s Length : %d", base64EncodedKey, keyBytes.length));

    }

    @Test
    public void encryptAES128Test() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
//        byte[] keyBytes= "XoRm+YugkBnl2CvB".getBytes();
        byte[] keyBytes= "1111111111111111".getBytes();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        Key secureKey = new SecretKeySpec(keyBytes, "AES");

        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, ivSpec);

        byte[] encryptedData = cipher.doFinal("1234".getBytes("UTF-8"));
        String base64EncodedData = Base64.encodeBase64URLSafeString(encryptedData);
        System.out.println(base64EncodedData);

    }

    @Test
    public void encryptAES128Test2() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] keyBytes= new byte[16];
        byte[] b= "1111111111111111".getBytes("UTF-8");
        int len= b.length;
        if (len > keyBytes.length) len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

        byte[] results = cipher.doFinal("1234".getBytes("UTF-8"));
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(results));
    }

    @Test
    public void encryptAES128Test3() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] keyBytes= new byte[16];
        byte[] b= "XoRm+YugkBnl2CvB".getBytes("UTF-8");
        int len= b.length;
        if (len > keyBytes.length) len = keyBytes.length;
        System.arraycopy(b, 0, keyBytes, 0, len);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

        byte[] results = cipher.doFinal("penta7728!".getBytes("UTF-8"));
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println(encoder.encode(results));
    }

    @Test // TODO 얘를 우선 사용하자.
    public void encryptAES128Test4() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException, UnsupportedEncodingException {
        byte[] keyBytes= "XoRm+YugkBnl2CvB".getBytes();
//        byte[] keyBytes= "1111111111111111".getBytes();
//        byte[] keyBytes = hexStringToByteArray("31313131313131313131313131313131");
        System.out.println("key:" + bytArrayToHex(keyBytes));
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        Key secureKey = new SecretKeySpec(keyBytes, "AES");

        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.ENCRYPT_MODE, secureKey, ivSpec);


        byte[] encryptedData = cipher.doFinal("penta7728!".getBytes("UTF-8"));
        String base64EncodedData = Base64.encodeBase64URLSafeString(encryptedData);
        System.out.println(base64EncodedData);

    }


    @Test
    public void aesEncrypt() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//        byte[] keyBytes = Arrays.copyOf("1111111111111111".getBytes("ASCII"), 16);
        byte[] keyBytes = hexStringToByteArray("31313131313131313131313131313131");
        System.out.println("key:" + bytArrayToHex(keyBytes));

        String plainText = "1234";
        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] cleartext = plainText.getBytes("UTF-8");
        byte[] ciphertextBytes = cipher.doFinal(cleartext);
        String base64EncodedData = Base64.encodeBase64URLSafeString(ciphertextBytes);

//        final char[] encodeHex = Hex.encodeHex(ciphertextBytes);
//
//        String encodeHexStr = new String(encodeHex);

        System.out.println(base64EncodedData);

    }


    String bytArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder();
        for(final byte b: a)
            sb.append(String.format("%02x", b&0xff));
        return sb.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
