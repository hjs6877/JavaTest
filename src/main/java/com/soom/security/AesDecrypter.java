package com.soom.security;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by kjs on 2016-03-24.
 */
public class AesDecrypter {
    public static void main(String[] args){
        if(!AesDecrypter.isRightANumberOfParameter(args)){
            System.out.println("A number of parameter must by 2.");
            System.out.println("ex) java -jar decrypter.jar [text for decryption] [secret key]");
            System.exit(-1);
        }

        String encryptedText = args[0].trim();
        String secretKey = args[1].trim();

        System.out.println(AesDecrypter.decrypt(encryptedText, secretKey));
    }

    private static boolean isRightANumberOfParameter(String[] args) {
        return args.length == 2;
    }

    public static String decrypt(String encryptedText, String secretKey) {
        String decryptedText = "";

        byte[] keyData = secretKey.getBytes();
        String IV = secretKey.substring(0, 16);
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = null;
        try {
            c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));
            byte[] byteStr = Base64.getDecoder().decode(encryptedText);
            decryptedText = new String(c.doFinal(byteStr),"UTF-8");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException happened.");
            System.exit(-1);
        } catch (NoSuchPaddingException e) {
            System.out.println("NoSuchPaddingException happened.");
            System.exit(-1);
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("InvalidAlgorithmParameterException happened.");
            System.exit(-1);
        } catch (InvalidKeyException e) {
            System.out.println("InvalidKeyException happened.");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException happened.");
            System.exit(-1);
        } catch (BadPaddingException e) {
            System.out.println("BadPaddingException happened.");
            System.exit(-1);
        } catch (IllegalBlockSizeException e) {
            System.out.println("IllegalBlockSizeException happened.");
            System.exit(-1);
        }

        return decryptedText;
    }
}
