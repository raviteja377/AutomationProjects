package vTiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.ExcelFileLibrary;

public class GenaricUtilityPractice {
	//@Test(dataProvider = "mulorg")
//	public void mulorgTest(String org,String indtype) {
	//	System.out.println(org+" "+indtype);
	//}
//	@DataProvider(name="mulorg")
	public static void main(String args[]) throws EncryptedDocumentException, IOException{
		ExcelFileLibrary elib=new ExcelFileLibrary();
		Object[][] data = elib.readMultipleData("MultipleOrg");
		System.out.println(data);

	}//public static int add(int a,int b) {
	//	int c=a+b;
	//	System.out.println(c);
	//	return c;
	//}

}
