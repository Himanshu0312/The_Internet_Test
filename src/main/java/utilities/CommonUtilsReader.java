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
	String screenshotLocation;

	private static CommonUtilsReader commonUtilsReader = null;
	
	
	private CommonUtilsReader() {
		FileReader reader;
		try {
			reader = new FileReader(".\\src\\main\\resources\\propertyfiles\\commonutils.properties");
			Properties p = new Properties();
			p.load(reader);
			homePageUrl = p.getProperty("HOME_PAGE");
			basicAuthUrl = p.getProperty("BASIC_AUTH_URL");
			browserValue = Integer.parseInt(p.getProperty("BROWSER_VALUE"));
			screenshotLocation = p.getProperty("SCREENSHOT_SOURCE");
		} catch (FileNotFoundException fnf) {
			log.error("Can't find bundle" + fnf.getMessage());
		} catch (IOException io) {
			log.error("Can't find bundle" + io.getMessage());
		}
	}
	
	public static CommonUtilsReader getInstance(){
        if(commonUtilsReader == null){
        	commonUtilsReader = new CommonUtilsReader();
        }
        return commonUtilsReader;
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
}