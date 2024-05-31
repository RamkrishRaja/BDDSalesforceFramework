package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

	private static Properties property;
	
	public static void loadConfig(){
		try{
			setProperty(new Properties());
			FileInputStream fileLocation = new FileInputStream("C:\\Users\\Ramak1501278\\eclipse-workspace\\Salesforce\\src\\test\\resources\\extent.properties");
			getProperties().load(fileLocation);
		}catch(FileNotFoundException e ){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		return property;
	}

	public static void setProperty(Properties property) {
		ConfigProperties.property = property;
	}

}
