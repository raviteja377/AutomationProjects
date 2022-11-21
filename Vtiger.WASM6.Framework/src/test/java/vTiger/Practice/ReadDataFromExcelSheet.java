package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vTiger.GenericLibrary.ExcelFileLibrary;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws  Exception {
		//Step1:Read the file and load into fileinputStream
		FileInputStream fis=new FileInputStream("G:\\eclipse mavanprojects\\Vtiger.WASM6.Framework\\src\\test\\resources\\TextData.xlsx");
		//Step2:create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		//Step3:navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
  //step4:navigate to required row and cell and read the data
		String lastname=sh.getRow(1).getCell(2).getStringCellValue();
		System.out.println(lastname);
	}

}
