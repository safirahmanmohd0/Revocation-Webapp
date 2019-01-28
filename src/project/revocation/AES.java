package project.revocation;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * Aes encryption
 */
public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    private static String decryptedString;
    private static byte[] encryptedString;

    public static void setKey(String myKey) {

        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");

            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            //System.out.println("Key length : " + key.length);
            //out.println(new String(key, "UTF-8"));
            secretKey = new SecretKeySpec(key, "AES");
            //System.out.println("secretKey 1  : " + secretKey);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String getDecryptedString() {
        return decryptedString;
    }

    public static void setDecryptedString(String decryptedString) {
        AES.decryptedString = decryptedString;
    }

    public static byte[] getEncryptedString() {
        return encryptedString;
    }

    public static void setEncryptedString(byte[] bs) {
        AES.encryptedString = bs;
    }

    public static String encrypt(String strToEncrypt) {
        try {
            //System.out.println("secretKey ency  : " + secretKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            setEncryptedString(Base64.encodeBase64(cipher.doFinal(strToEncrypt
                    .getBytes("UTF-8"))));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(byte[] strToDecrypt) {
        try {

           // System.out.println("secretKey decy  : " + secretKey);

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            Base64.decodeBase64(strToDecrypt);
            setDecryptedString(new String(cipher.doFinal(Base64
                    .decodeBase64(strToDecrypt))));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String args[]) {
        final String strToEncrypt = "1";
        final String strPssword = "encryptor key";
        AES.setKey(strPssword);
        AES.encrypt(strToEncrypt.trim());
		//System.out.println("String to Encrypt: " + strToEncrypt);
        //System.out.println("Encrypted: " + AES.getEncryptedString());
        final byte[] strToDecrypt = AES.getEncryptedString();
        AES.decrypt(strToDecrypt);
		//System.out.println("String To Decrypt : " + strToDecrypt);
        //System.out.println("Decrypted : " + AES.getDecryptedString());
    }

}
