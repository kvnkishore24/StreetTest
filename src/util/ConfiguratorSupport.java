package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfiguratorSupport {

	static Properties props = new Properties();
	String strFileName;
	String strValue;

	public String getProperty(String strKey) {
		try {
			File f = new File("config.properties");
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strValue = props.getProperty(strKey);
				in.close();
			} else
				System.out.println("File not found!");
		} catch (Exception e) {

		}
		return strValue;
	}

}
