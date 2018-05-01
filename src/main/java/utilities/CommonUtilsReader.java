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

	public CommonUtilsReader() {
		FileReader reader;
		try {
			reader = new FileReader(".\\src\\main\\resources\\propertyfiles\\commonutils.properties");
			Properties p = new Properties();
			p.load(reader);
			homePageUrl = p.getProperty("HOME_PAGE");
			basicAuthUrl = p.getProperty("BAISC_AUTH_URL");
			browserValue = Integer.parseInt(p.getProperty("BROWSER_VALUE"));
		} catch (FileNotFoundException fnf) {
			log.error("Can't find bundle" + fnf.getMessage());
		} catch (IOException io) {
			log.error("Can't find bundle" + io.getMessage());
		}
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