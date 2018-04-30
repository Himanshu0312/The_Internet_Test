package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ChromePropertyReader {

	String propertyName, driverLocation, chromeOptions;

	private static final Logger log = Logger.getLogger(ChromePropertyReader.class);

	public ChromePropertyReader() {
		FileReader reader;
		try {
			reader = new FileReader(".\\src\\main\\resources\\propertyfiles\\googlechrome.properties");
			Properties p = new Properties();
			p.load(reader);
			propertyName = p.getProperty("PROPERTY_NAME");
			driverLocation = p.getProperty("BROWSER_LOCATION");
			chromeOptions = p.getProperty("CHROME_OPTION1");
		} catch (FileNotFoundException fnf) {
			log.error("Can't find bundle" + fnf.getMessage());
		} catch (IOException io) {
			log.error("Can't find bundle" + io.getMessage());
		}
	}

	public String getChromeOptions() {
		return chromeOptions;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getDriverLocation() {
		return driverLocation;
	}

}
