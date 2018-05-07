package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class BrowserPropertyReader {

	String edgePropertyName, edgeDriverLocation;
	String iePropertyName, ieDriverLocation;
	String geckoPropertyName, geckoDriverLocation;
	String chromePropertyName, chromeDriverLocation, chromeOptions;

	Properties broswerProperty;

	private static final Logger log = Logger.getLogger(BrowserPropertyReader.class);

	private static BrowserPropertyReader browserPropertyReader = null;

	private BrowserPropertyReader() {
		FileReader fileReader;
		try {
			fileReader = new FileReader(".\\src\\main\\resources\\propertyfiles\\WebBrowser.properties");
			broswerProperty = new Properties();
			broswerProperty.load(fileReader);
			chromePropertyName = broswerProperty.getProperty("CHROME_PROPERTY_NAME");
			chromeDriverLocation = broswerProperty.getProperty("CHROME_BROWSER_LOCATION");
			chromeOptions = broswerProperty.getProperty("CHROME_OPTIONS_1");
			edgePropertyName = broswerProperty.getProperty("EDGE_PROPERTY_NAME");
			edgeDriverLocation = broswerProperty.getProperty("EDGE_BROWSER_LOCATION");
			iePropertyName = broswerProperty.getProperty("IE_PROPERTY_NAME");
			ieDriverLocation = broswerProperty.getProperty("IE_BROWSER_LOCATION");
			geckoPropertyName = broswerProperty.getProperty("GECKO_PROPERTY_NAME");
			geckoDriverLocation = broswerProperty.getProperty("GECKO_BROWSER_LOCATION");
		} catch (FileNotFoundException fnf) {
			log.error("Can't find bundle" + fnf.getMessage());
		} catch (IOException io) {
			log.error("Can't find bundle" + io.getMessage());
		}
	}

	public static BrowserPropertyReader getInstance() {
		if (browserPropertyReader == null) {
			browserPropertyReader = new BrowserPropertyReader();
		}
		return browserPropertyReader;
	}

	public String getEdgePropertyName() {
		return edgePropertyName;
	}

	public String getEdgeDriverLocation() {
		return edgeDriverLocation;
	}

	public String getChromePropertyName() {
		return chromePropertyName;
	}

	public String getChromeDriverLocation() {
		return chromeDriverLocation;
	}

	public String getChromeOptions() {
		return chromeOptions;
	}

	public String getIePropertyName() {
		return iePropertyName;
	}

	public String getIeDriverLocation() {
		return ieDriverLocation;
	}

	public String getGeckoPropertyName() {
		return geckoPropertyName;
	}

	public String getGeckoDriverLocation() {
		return geckoDriverLocation;
	}

}
