package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GenericLibrary.ExcelFileLibrary;

public class DataProviderPractice {
	@Test(dataProvider ="phones")
public void addToCartTest(String name,String model,int price,int qty) {
	System.out.println("mobile name: "+name+"model : "+model+"price :"+price+"quantity : "+qty);
}
@DataProvider(name="phones")
public Object[][] getData(){
	Object[][]  data=new Object[2][4];
	data[0][0]="Samsong";
	data[0][1]="g1";
	data[0][2]=20000;
	data[0][3]=8;
	
	data[1][0]="Vivo";
	data[1][1]="y1";
	data[1][2]=21000;
	data[1][3]=4;
	return data;
}


}
