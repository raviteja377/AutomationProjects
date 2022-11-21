package vTiger.GenericLibrary;



import java.io.FileInputStream;

import java.util.Properties;


/**
 * This class contains generic methods related to property file
 * @author ADMIN
 *
 */
public class PropertyFileLibrary{
	
	public String readDataFromPropertyFile(String key) throws Exception {
		FileInputStream fis=new FileInputStream(IConstantLibrary.PropertyFilepath);
		Properties pobj=new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		return data;
		
		
	}
}
