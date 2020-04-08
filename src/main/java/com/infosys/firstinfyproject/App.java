package com.infosys.firstinfyproject;

import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		// Base 64 encoding decoding example below:
		byte[] encodeBase64 = Base64.encodeBase64("Sujay".getBytes());
		System.out.println("Encoded String: " + new String(encodeBase64));
		byte[] decodeBase64 = Base64.decodeBase64(encodeBase64);
		System.out.println("Decoded String: " + new String(decodeBase64));
		// start app as boot application...
		SpringApplication.run(App.class, args);
	}
}
