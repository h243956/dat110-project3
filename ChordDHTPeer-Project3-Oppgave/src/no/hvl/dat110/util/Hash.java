package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	public static BigInteger hashOf(String entity) {	
		MessageDigest md;
		BigInteger ret = null;
		
		try {	
			byte[] bytesOfMessage = entity.getBytes();
			md = MessageDigest.getInstance("MD5");
			md.update(bytesOfMessage);
		    byte[] digest = md.digest();
		    ret = new BigInteger(1, digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		BigInteger bi = BigInteger.valueOf(2);
		bi = bi.pow(bitSize());
		return bi;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		try {
			digestlen = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
