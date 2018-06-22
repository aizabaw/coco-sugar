package banana.db.utils;

import javax.crypto.Cipher;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class EncryptUtils {
	
	private static Cipher cipher;
	
	public static String passwordEncrypt(String pw) {
		return DigestUtils.sha256(pw).toString();
	}
	
//	public static String decrypt(String encryptedString) {
//        String decryptedText=null;
//        try {
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] encryptedText = Base64.decodeBase64(encryptedString);
//            byte[] plainText = cipher.doFinal(encryptedText);
//            decryptedText= new String(plainText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return decryptedText;
//    }

}
