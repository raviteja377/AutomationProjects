package vTiger.GenericLibrary;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this  class will contain all the genaric  methods related to excel  sheet
 * @author ADMIN
 *
 */
public class ExcelFileLibrary{
	/**
	 * this method will read the data from excel for user specified sheet,row and column 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 */
	public String redaDataFromExcel(String sheetName,int rowNo,int cellNo) throws Exception {
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		String value = c.getStringCellValue();
		wb.close();
		return value;
	}

	/**
	 * This method will provide the last row number utilized in a given sheet
	 * @param sheetName
	 * @return
	 * @throws Exception
	 * 
	 */
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream(IConstantLibrary.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
/**
 * This method will write the data into excel sheet for user specified sheet, row no and cell no 
 * @param sheetName
 * @param rowNo
 * @param celNo
 * @param value
 * @throws FileNotFoundException 
 * @throws IOException 
 * @throws  
 * @throws Exception
 */
	 
	public void writeDataIntoExcel(String sheetName, int rowNo, int celNo, String data) throws FileNotFoundException, IOException {
	
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row rw = sh.getRow(rowNo);
		Cell cw = rw.createCell(celNo);
		cw .setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IConstantLibrary.excelFilepath);
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");
	}
	public  Object[][] readMultipleData(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilepath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh=wb.getSheet(sheet);
		int lastrow = sh.getLastRowNum ();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		
		Object[][] data=new Object[lastrow][lastCell];
	for(int i=0;i<lastrow;i++) {
		for(int j=0;j<lastCell;j++) {
				 data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		
		
	}
	}
