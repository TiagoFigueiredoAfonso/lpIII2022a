package lpIIIjavaweb.utils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GeraMD5 {
	public static String md5(String s) {
        MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
		    m.update(s.getBytes(),0,s.length());
		    return new BigInteger(1,m.digest()).toString(16);	
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
