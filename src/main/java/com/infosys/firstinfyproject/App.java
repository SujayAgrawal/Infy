package com.infosys.firstinfyproject;

import org.apache.commons.codec.binary.Base64;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		byte[] encodeBase64 = Base64.encodeBase64("Sujay".getBytes());
		System.out.println("Encoded String: " + new String(encodeBase64));
		byte[] decodeBase64 = Base64.decodeBase64(encodeBase64);
		System.out.println("Decoded String: " + new String(decodeBase64));
	}
}
