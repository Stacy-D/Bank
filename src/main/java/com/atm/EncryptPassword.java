package com.atm;

import org.apache.commons.codec.digest.DigestUtils;

public class EncryptPassword {
	
	/**
	 * Returns encrypted password for database
	 * @param password
	 * @return
	 */
	public static String encrypt(String password)
	{
		 String md5Hex = DigestUtils.md5Hex(password);
		 return md5Hex;
	}

}
