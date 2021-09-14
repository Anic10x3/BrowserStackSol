package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class utils {
	public static String getPropertyValues(String propertyName) throws IOException {
		
		File file = new File("D:\\Java Practice\\oneplus\\properties.properties");
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		String propertyValue = prop.getProperty(propertyName);
		return propertyValue;
	}
}
