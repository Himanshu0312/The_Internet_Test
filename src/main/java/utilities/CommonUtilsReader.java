package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CommonUtilsReader {

	private static final Logger log = Logger.getLogger(CommonUtilsReader.class);
	String homePageUrl;
	String basicAuthUrl;
	int browserValue;
	String screenshotLocation, checkboxesLocationOnCheckBoxesPage;
	Properties commonProperty;

	private static CommonUtilsReader commonUtilsReader = null;

	private CommonUtilsReader() {
		FileReader readerForCommonProperty;
		try {
			readerForCommonProperty = new FileReader(".\\src\\main\\resources\\propertyfiles\\commonutils.properties");
			commonProperty = new Properties();
			commonProperty.load(readerForCommonProperty);
			homePageUrl = commonProperty.getProperty("HOME_PAGE");
			basicAuthUrl = commonProperty.getProperty("BASIC_AUTH_URL");
			browserValue = Integer.parseInt(commonProperty.getProperty("BROWSER_VALUE"));
			screenshotLocation = commonProperty.getProperty("SCREENSHOT_SOURCE");
		} catch (FileNotFoundException fnf) {
			log.error("Can't find bundle" + fnf.getMessage());
		} catch (IOException io) {
			log.error("Can't find bundle" + io.getMessage());
		}catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
	}

	public static CommonUtilsReader getInstance() {
		if (commonUtilsReader == null) {
			commonUtilsReader = new CommonUtilsReader();
		}
		return commonUtilsReader;
	}

	public String getCheckboxesLocationOnCheckBoxesPage() {
		return checkboxesLocationOnCheckBoxesPage;
	}

	public String getScreenshotLocation() {
		return screenshotLocation;
	}

	public int getBrowserValue() {
		return browserValue;
	}

	public String getHomePageUrl() {
		return homePageUrl;
	}

	public String getBasicAuthUrl() {
		return basicAuthUrl;
	}
	
	public static void main(String[] args) {
	System.out.println(CommonUtilsReader.getInstance().getCheckboxesLocationOnCheckBoxesPage());
	}
}