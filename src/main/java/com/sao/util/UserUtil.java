package com.sao.util;

public class UserUtil {
	public static boolean matchPassword(String inputPassword, String md5Password) throws Exception{
		return md5Password.equals(Util.getMD5Str(inputPassword));
	}
}
