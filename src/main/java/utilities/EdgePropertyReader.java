package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class EdgePropertyReader {

	private static final Logger log = Logger.getLogger(EdgePropertyReader.class);
	String propertyName, driverLocation;
	Properties p;

	public EdgePropertyReader() {
		FileReader reader;
		try {
			reader = new FileReader(".\\src\\main\\resources\\propertyfiles\\edge.properties");
			Properties p = new Properties();
			p.load(reader);
			propertyName = p.getProperty("PROPERTY_NAME");
			driverLocation = p.getProperty("BROWSER_LOCATION");
		} catch (FileNotFoundException fnf) {
			log.error("Can't find bundle" + fnf.getMessage());
		} catch (IOException io) {
			log.error("Can't find bundle" + io.getMessage());
		}
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getDriverLocation() {
		return driverLocation;
	}
}
