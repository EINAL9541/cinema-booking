package module;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Checker {
	public static String digestMsg(String str) {
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte arr[] = md.digest();
			return new String(arr);
		} catch (NoSuchAlgorithmException e) {
			return "unsucced";
		}
	}
	
//	public static void main(String args[])
//	{
//		System.out.println(digestMsg("admin123"));
//	}
}
