package com.yunpian.sdk.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;

/**
 * Created by bingone on 16/3/10.
 */

/**
 * DES加密方法 reference : http://blog.csdn.net/jjwwmlp456/article/details/20933021
 */
@Deprecated
public class DesUtil {
	// 算法名称
	public static final String KEY_ALGORITHM = "DES";
	// 算法名称/加密模式/填充方式
	public static final String CIPHER_ALGORITHM_ECB = "DES/ECB/PKCS5Padding";
	public static final String CIPHER_ALGORITHM_CBC = "DES/CBC/PKCS5Padding";

	public static void main(String[] args) throws Exception {
		/*
		 * 使用 ECB mode 密钥生成器 生成密钥 ECB mode cannot use IV
		 */
		// byte[] key = generateKey();
		byte[] key = "12345678".getBytes();
		// byte[] encrypt = encrypt("12345678".getBytes(), key);
		// System.out.println(Base64.encodeBase64String(encrypt));
		// System.out.println(new String(decrypt(encrypt, key)));
		// String tmp = encryptForYunpian("Yunpian",
		// "12345678123456781234567812345678");
		// System.out.println(tmp);
		// System.out.println(decryptForYunpian(tmp,
		// "12345678123456781234567812345678"));
		System.out.println(decryptForYunpian("RLlJ+bgSQnRRguZMMPqQWPu7QmWwrxdSbgEIRSxtZD4X7RBRmdIllQ==", "12345678"));
		/*
		 * 使用CBC mode 使用密钥工厂生成密钥，加密 解密 iv: DES in CBC mode and RSA ciphers with
		 * OAEP encoding operation.
		 */
		DESKeySpec dks = new DESKeySpec(key);
		SecretKeyFactory factory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey secretKey = factory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(getIV()));
		byte[] enc = cipher.doFinal("https://mail.google.com/mail/u/0/#inbox/a1ed0e2f6f28e06b4361".getBytes()); // 加密
		System.out.println(new String(enc));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(getIV()));
		byte[] dec = cipher.doFinal(enc); // 解密
		System.out.println(new String(dec));
	}

	static byte[] getIV() {
		String iv = "asdfivh7"; // IV length: must be 8 bytes long
		return iv.getBytes();
	}

	/**
	 * 生成密钥
	 *
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static byte[] generateKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
		keyGenerator.init(56); // des 必须是56, 此初始方法不必须调用
		SecretKey secretKey = keyGenerator.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * 还原密钥
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(byte[] key) throws Exception {
		DESKeySpec des = new DESKeySpec(key);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
		SecretKey secretKey = keyFactory.generateSecret(des);
		return secretKey;
	}

	public static String encryptForYunpian(String data, String key) throws Exception {
		return Base64.encodeBase64String(encrypt(data.getBytes(), key.getBytes()));
	}

	public static String decryptForYunpian(String data, String key) throws Exception {
		key = key + key + key + key;
		return new String(decrypt(Base64.decodeBase64(data), key.getBytes()), "utf8");
	}

	/**
	 * 加密
	 *
	 * @param data
	 *            原文
	 * @param key
	 * @return 密文
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		cipher.init(Cipher.ENCRYPT_MODE, k);
		return cipher.doFinal(data);
	}

	/**
	 * 解密
	 *
	 * @param data
	 *            密文
	 * @param key
	 * @return 明文、原文
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
		cipher.init(Cipher.DECRYPT_MODE, k);
		return cipher.doFinal(data);
	}
}
