package gytlv;

import org.apache.commons.codec.binary.Base64;

import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Security {
	
	private static final String KEY="1234567890123456";
    private static final String USER_FOEM="sograndwap";
	
	
	
	public static String encrypt(String input, String key) {
		byte[] crypted = null;

		try {
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.ENCRYPT_MODE, skey);

			crypted = cipher.doFinal(input.getBytes());
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return (new String(Base64.encodeBase64(crypted)));
	}

	public static String decrypt(String input, String key) {
		byte[] output = null;

		try {
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

			cipher.init(Cipher.DECRYPT_MODE, skey);

			output = cipher.doFinal(Base64.decodeBase64(input));
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return (new String(output));
	}
	/**
	 * test
	 * @param customerId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String cryptUrl(Long customerId){
		String data=customerId.toString().concat(Security.USER_FOEM);
		String token=Security.encrypt(data, Security.KEY);
		return URLEncoder.encode(token);
	};
	public static void main(String[] args) {
		System.out.println(Security.cryptUrl(1500l));
	}
}
