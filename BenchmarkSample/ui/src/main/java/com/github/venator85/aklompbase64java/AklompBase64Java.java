package com.github.venator85.aklompbase64java;

import java.nio.charset.StandardCharsets;

public class AklompBase64Java {
	static {
		System.loadLibrary("akb64_java");
	}

	private static final char fillChar = '=';

	public static byte[] decode(String s) {
		int sLen = s.length();
		if (sLen == 0) {
			return new byte[0];
		}
		final int eIx = sLen - 1;
		// get the padding count (=) (0, 1 or 2)
		int pad = s.charAt(eIx) == fillChar ? (s.charAt(eIx - 1) == fillChar ? 2 : 1) : 0;  // Count '=' at end.
		int len = (sLen * 6 >> 3) - pad; // The number of decoded bytes
		byte[] dArr = new byte[len];
		decode(s.getBytes(StandardCharsets.US_ASCII), dArr);
		return dArr;
	}

	private static native void decode(byte[] encoded, byte[] output);

}
