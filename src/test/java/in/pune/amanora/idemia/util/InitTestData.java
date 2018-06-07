package in.pune.amanora.idemia.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class InitTestData {
	static Properties props;
	
	public static Properties initData(String propFile){
		
		File fileObj = new File(propFile);
		try {
			FileReader reader = new FileReader(fileObj);
			props = new Properties();
			props.load(reader);
			reader.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return props;
		
	}
}
