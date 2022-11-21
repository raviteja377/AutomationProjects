package vTiger.Practice;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;

public class GenericLibraryPractice {
	public static void main(String[] args) throws Exception {
		JavaLibrary jlib= new JavaLibrary();
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		ExcelFileLibrary eLib=new ExcelFileLibrary();

         //for javalibrary
		String date = jlib.getSystemDate();;
		System.out.println(date);
		String dateformate = jlib.getSystemDateInFormate();
		System.out.println(dateformate);
		int num = jlib.getRandomNumber();
		System.out.println(num);
		//propertyfilelibrary
		String browser = pLib.readDataFromPropertyFile("browser");
		System.out.println (browser);

       //for excel file library
String vendorName=eLib.redaDataFromExcel("Products", 4, 3);
System.out.println(vendorName);
String pn = eLib.redaDataFromExcel("Products", 4, 2);
System.out.println(pn);
eLib.writeDataIntoExcel("Organization", 7, 11, "prt");




	}}
