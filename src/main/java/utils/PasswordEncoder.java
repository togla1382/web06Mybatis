package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
	
	public static String encode(String inputPass) {
		String encodedPass=null;
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			//md.update(inputPass.getBytes());
			byte[] result=md.digest(inputPass.getBytes());
			StringBuffer sb=new StringBuffer();
			for(byte b:result) {
				sb.append(Integer.toString(b & 0xff , 16));
			}
			encodedPass=sb.toString();
		} catch (NoSuchAlgorithmException  e) {
			e.printStackTrace();
		}
		
		
		return encodedPass;
	}

}
