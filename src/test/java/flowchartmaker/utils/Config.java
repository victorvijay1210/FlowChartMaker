package flowchartmaker.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

import flowchartmaker.common.BaseClass;


public class Config extends BaseClass{
	
	Properties pro;
	
	
	
	public synchronized Properties init_properties() {
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\propertyfiles\\log4j.properties");
		pro = new Properties();
		
		try {
			File fis = new File("src\\test\\resources\\propertyfiles\\config.properties");
			FileInputStream FI = new FileInputStream(fis);
			
			 pro = new Properties();
			 
			 pro.load(FI);
			 Log.info("Config properties file loaded properly");
			
		} catch (IOException e) {
			
			Log.info("Not able to load config properties file" + e.getMessage());
		}
		
		return pro;
	}
	



}
