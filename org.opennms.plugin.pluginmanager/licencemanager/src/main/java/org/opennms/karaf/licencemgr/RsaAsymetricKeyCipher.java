/*
 * Copyright 2014 OpenNMS Group Inc., Entimoss ltd.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opennms.karaf.licencemgr;


import javax.xml.bind.DatatypeConverter; 

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.opennms.karaf.licencemgr.StringCrc32Checksum;

/**
 * @author cgallen
 * See http://www.javamex.com/tutorials/cryptography/asymmetric.shtml 
 * This example based on tutorial
 *
 */
public class RsaAsymetricKeyCipher {
	
	private static final int KEY_SIZE = 2048; // key size

	private String publicKeyStr=null;
	private String privateKeyStr=null;


	/**
	 * @return the publicKeyStr
	 */
	public String getPublicKeyStr() {
		return publicKeyStr;
	}

	/**
	 * @param publicKeyStr the publicKeyStr to set
	 */
	public void setPublicKeyStr(String publicKeyStr) {
		this.publicKeyStr = publicKeyStr;
	}

	/**
	 * @return the privateKeyStr
	 */
	public String getPrivateKeyStr() {
		return privateKeyStr;
	}

	/**
	 * @param privateKeyStr the privateKeyStr to set
	 */
	public void setPrivateKeyStr(String privateKeyStr) {
		this.privateKeyStr = privateKeyStr;
	}

	/**
	 * Generates new asymetric RSA based public and private key strings.
	 * These strings can be accessed by getPrivateKeyStr() and PublicKeyStr()
	 * after they are generated. generateKeys() overwites any previous values for publicKeyStr and privateKeyStr
	 */
	public void generateKeys() {

		KeyPairGenerator kpg;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(KEY_SIZE);
			KeyPair kp = kpg.genKeyPair();
			Key publicKey = kp.getPublic();
			Key privateKey = kp.getPrivate();
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec rsaPublicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			RSAPrivateKeySpec rsaPrivateKeySpec = keyFactory.getKeySpec(privateKey,  RSAPrivateKeySpec.class);

			BigInteger pubKeyMod=rsaPublicKeySpec.getModulus();
			BigInteger pubKeyExp=rsaPublicKeySpec.getPublicExponent();
			publicKeyStr=pubKeyMod.toString(16)+"-"+pubKeyExp.toString(16); // converts to hex and concatenates with -

			BigInteger privateKeyMod=rsaPrivateKeySpec.getModulus();
			BigInteger privateKeyExp=rsaPrivateKeySpec.getPrivateExponent();
			privateKeyStr=privateKeyMod.toString(16)+"-"+privateKeyExp.toString(16); // converts to hex and concatenates with -

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("problem generating keys",e);
		} catch (InvalidKeySpecException e) {
			throw new RuntimeException("problem generating keys",e);
		}

	}

	/**
	 * reads private key from correctly formatted privateKeyStr generated by generateKeys()
	 * @param privateKeyStr
	 * @return PrivateKey
	 */
	private PrivateKey readPrivateKeyFromString(String privateKeyStr) {
		try {
			String[] parts = privateKeyStr.split("-");
			if (parts.length!=2) throw new RuntimeException("incorrectly formatted keystring");
			String privateKeyModStr=parts[0];
			String privateKeyExpStr=parts[1];
			BigInteger modulus = new BigInteger(privateKeyModStr ,16);
			BigInteger exponent = new BigInteger(privateKeyExpStr ,16);
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(modulus, exponent);
			KeyFactory rsaKeyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = rsaKeyFactory.generatePrivate(keySpec);
			return privateKey;
		} catch (Exception e) {
			throw new RuntimeException("Spurious serialisation error", e);
		} 
	}

	
	/**
	 * creates PublicKey from correctly formatted publicKeyStr generated by generateKeys()
	 * @param publicKeyStr
	 * @return PublicKey
	 */
	private PublicKey readPublicKeyFromString(String publicKeyStr) {
		try {
			String[] parts = publicKeyStr.split("-");
			if (parts.length!=2) throw new RuntimeException("incorrectly formatted keystring");
			String publicKeyModStr=parts[0];
			String publicKeyExpStr=parts[1];
			BigInteger modulus = new BigInteger(publicKeyModStr ,16);
			BigInteger exponent = new BigInteger(publicKeyExpStr ,16);
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(modulus, exponent);
			KeyFactory fact = KeyFactory.getInstance("RSA");
			PublicKey pubKey = fact.generatePublic(keySpec);
			return pubKey;
		} catch (Exception e) {
			throw new RuntimeException("Spurious serialisation error", e);
		} 
	}
	
	/**
	 * Encrypts source string using rsaEncryptString and adds checksum to result
	 * @param sourceStr
	 * @return encrypted string plus checksum
	 */
	public String rsaEncryptStringAddChecksum(String sourceStr){
		String encryptedStr =rsaEncryptString(sourceStr);
		StringCrc32Checksum stringCrc32Checksum = new StringCrc32Checksum();
		return stringCrc32Checksum.addCRC(encryptedStr);
	}

	/**
	 * returns a string containing a lexical representation of xsd:hexBinary 
	 * of RSA encoded source string
	 * @param sourceStr string to encode
	 * @return xsd:hexBinary string of RSA encoded source
	 */
	public String rsaEncryptString(String sourceStr){
		byte[] src;
		try {
			src = sourceStr.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 encoding is not supported");
		}
		byte[] encrypted= rsaEncrypt(src);
		return DatatypeConverter.printHexBinary(encrypted);
	}
	


	/**
	 * Returns an rsa encrypted Byte[] array of  src byte[] array
	 * @param src
	 * @return RSA encoded byte array
	 */
	public byte[] rsaEncrypt(byte[] src) {
		PublicKey pubKey;
		byte[] cipherData=null;
		try {
			pubKey = readPublicKeyFromString(publicKeyStr);

			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			cipherData = cipher.doFinal(src);

		}  catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("problem encrypting data",e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException("problem encrypting data",e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException("problem encrypting data",e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException("problem encrypting data",e);
		} catch (BadPaddingException e) {
			throw new RuntimeException("problem encrypting data",e);
		}
		return cipherData;

	}

	/**
	 * checks source string CRC and then decrypts string using rsaDecryptString
	 * @param encryptedStrAndCRC in form <encrypted string>-<CRC>
	 * @return decrypted string or null if checksum incorrect
	 */
	public String rsaDecryptStringRemoveChecksum(String encryptedStrAndCRC){
		
		StringCrc32Checksum stringCrc32Checksum = new StringCrc32Checksum();
		String encryptedStr = stringCrc32Checksum.removeCRC(encryptedStrAndCRC);
		if (encryptedStr==null) return null;
		return rsaDecryptString(encryptedStr);
	}
	
	/**
	 * expects a string containing a lexical representation of xsd:hexBinary 
	 * of RSA encoded source string.
	 * @param encryptedStr string to decode
	 * @return decryptedString decrypted string
	 */
	public String rsaDecryptString(String encryptedStr){
		String decriptedStr=null;
		try {
			//byte[] encrypted = DatatypeConverter.parseBase64Binary(encryptedStr);
			byte[] encrypted = DatatypeConverter.parseHexBinary(encryptedStr);
			byte[] decrypt = rsaDecrypt(encrypted);
			decriptedStr = new String(decrypt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 encoding is not supported", e);
		}
		return decriptedStr;
	}

	/**
	 * Returns a decrypted Byte[] array of n rsa encrypted src byte[] array
	 * @param cipherData
	 * @return decoded byte array
	 */
	public byte[] rsaDecrypt(byte[] cipherData) {
		byte[] deCipherData=null;
		try {
			PrivateKey privateKey = readPrivateKeyFromString(privateKeyStr);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			deCipherData = cipher.doFinal(cipherData);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("problem decrypting data",e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException("problem decrypting data",e);
		} catch (InvalidKeyException e) {
			throw new RuntimeException("problem decrypting data",e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException("problem decrypting data",e);
		} catch (BadPaddingException e) {
			throw new RuntimeException("problem decrypting data",e);
		}
		return deCipherData;
	}



}