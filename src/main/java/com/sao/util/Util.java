package com.sao.util;

import java.security.MessageDigest;

/**
 * 
 * @author Stone
 *
 */
public class Util {
	
	public static String getMD5Str(String str) throws Exception {
			byte[] buf = str.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(buf);
			byte[] tmp = md5.digest();
			StringBuilder sb = new StringBuilder();
			for (byte x : tmp) {
				if ((x & 0xff) >> 4 == 0) {
					sb.append("0").append(Integer.toHexString(x & 0xff));
				} else {
					sb.append(Integer.toHexString(x & 0xff));
				}
			}
			return sb.toString();
		}
	

}

