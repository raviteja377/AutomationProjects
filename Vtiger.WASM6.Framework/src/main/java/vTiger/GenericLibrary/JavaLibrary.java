package vTiger.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * this class will contains  allthe generic methods related to java
 * @author Raviteja
 *
 */
public class JavaLibrary {
	/**
	 * this method will generate random number for every execution 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int data = ran.nextInt(1000);
		return  data;
		
	}
	/**
	 * this method will return the current System date
	 */
	public String getSystemDate() {
		Date d=new Date();
		String date = d.toString();
		return date;
		
	}
	/**
	 * this method will return the current the System date in specific formate
	 * @return
	 */
	public String getSystemDateInFormate() {
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String mon = dArr[1];
		String date = dArr[2];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
			String dateInFormate = date+" "+mon+" "+year+""+" "+time;
			return dateInFormate;	
	}
 
}
