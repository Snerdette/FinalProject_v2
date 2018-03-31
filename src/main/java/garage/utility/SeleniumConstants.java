package garage.utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumConstants {

	/**
	 * Constant made to use throughout the app.
	 */
	public static final String URL = "http://localhost:8080";

	public String getUrl() {
		return URL;
	}
	
	/**
	 * Generates a random string to use for testing.
	 * @return randomString.
	 */
	public static String generateString()
	{
		Random rng = new Random();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = 8;
		char[] text = new char[length];
		for(int i=0; i < length; i++)
		{
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		
		return new String(text);
	}

}
