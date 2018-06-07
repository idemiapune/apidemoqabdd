package in.pune.amanora.idemia.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

/**
 * 
 * @author Pallavi Varne
 *
 */
public class TestProp {

	public static final String TEST_PROP_FILE = "testprop.properties";
	public static String baseUrl = "http://localhost:8089";

	public static void initTestProp() {
		File fileObj = new File(TEST_PROP_FILE);
		try {
			Files.deleteIfExists(fileObj.toPath());
			Files.createFile(fileObj.toPath());
			writeProp("api.localbaseurl", "http://localhost:8089");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getBaseUrl() {
		return TestProp.baseUrl;
	}
	
	public static void setBaseUrl() {
		TestProp.baseUrl = readProp("api.localbaseurl");
	}
	
	public static String getApiUrl() {
		return readProp("api.url");
	}

	public static void setApiUrl(String apiUrl) {
		writeProp("api.url", apiUrl);
	}

	public static String readProp(String prop) {
		File fileObj = new File(TEST_PROP_FILE);
		String val = null;
		try {
			FileReader reader = new FileReader(fileObj);
			Properties props = new Properties();
			props.load(reader);
			val = props.getProperty(prop);
			reader.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return val;
	}

	public static void writeProp(String prop, String val) {
		File fileObj = new File(TEST_PROP_FILE);
		try {
			FileReader reader = new FileReader(fileObj);
			Properties props = new Properties();
			props.load(reader);
			props.setProperty(prop, val);
			FileWriter writer = new FileWriter(fileObj);
			props.store(writer, "Test Properties");
			writer.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
