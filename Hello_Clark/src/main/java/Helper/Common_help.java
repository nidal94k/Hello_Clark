package Helper;

import java.net.URLEncoder;
import java.util.Random;
/**
 * A class that contains all global methods that might be used as a helper for various reasons
 *
 */
public  class Common_help {
	@SuppressWarnings("deprecation")
	public static String encoderStringHTML(String str)
	{
		str=URLEncoder.encode(str);
		str=str.replaceAll("%AD", ""); //after encoding, &and is replaced to %AD	
		return str;
	}
	
	public static String translateMonth(int month_digit)
	{//Translate month from integer(1..12) to a subString
		switch (month_digit) {
		  case 1:
		    return "Jan";
		  case 2:
			  return "Feb";
		  case 3:
			  return "Mär";
		  case 4:
			  return "Apr";
		  case 5:
			  return "Mai";
		  case 6:
			  return "Jun";
		  case 7:
			  return "Jul";
		  case 8:
			  return "Aug";
		  case 9:
			  return "Sep";
		  case 10:
			  return "Okt";
		  case 11:
			  return "Nov";
		  case 12:
			  return "Dez";
		}
		return "";
	}
	
	public static String generateString(Random random, int length) {// generate string for email
		String characters ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++) {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }
	    return new String(text);
	}

}
