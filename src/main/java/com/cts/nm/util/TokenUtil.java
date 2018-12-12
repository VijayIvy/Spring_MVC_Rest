package com.cts.nm.util;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class TokenUtil {

	public String getToken() {
		SecureRandom secureRandom = new SecureRandom();
		byte[] token = new byte[60];
		secureRandom.nextBytes(token);
		return new BigInteger(1, token).toString(16);
	}
}
