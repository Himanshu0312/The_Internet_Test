package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class MyBrowserManager {

	private static final Logger log = Logger.getLogger(MyBrowserManager.class);

	int browserValue;
	WebDriver driver;
	WebElement element;

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public MyBrowserManager() {
	}

	public MyBrowserManager(int browserValue) {
		this.browserValue = browserValue;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void initiate() {
		log.info("Browser Setup initiated..");
		try {
			switch (browserValue) {
			case 1:
				System.setProperty(ChromePropertyReader.getInstance().propertyName,
						ChromePropertyReader.getInstance().driverLocation);
				log.info("Settings " + browserValue + " propety..");
				log.info("Initiating " + browserValue + "...");
				driver = new ChromeDriver(
						new ChromeOptions().addArguments(ChromePropertyReader.getInstance().getChromeOptions()));
				driver.manage().window().maximize();
				log.info("Maximize done.");
				driver.manage().timeouts().implicitlyWait(Wait.LOW.interval(), TimeUnit.SECONDS);
				break;

			case 2:
				System.setProperty(EdgePropertyReader.getInstance().propertyName,
						EdgePropertyReader.getInstance().driverLocation);
				log.info("Settings " + browserValue + " propety..");
				log.info("Initiating " + browserValue + "...");
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				log.info("Maximize done.");
				driver.manage().timeouts().implicitlyWait(Wait.LOW.interval(), TimeUnit.SECONDS);
				break;

			default:
				log.error("Invalid browser entry found.");
			}
		} catch (SessionNotCreatedException snce) {
			log.error("SessionNotCreatedException Found." + snce.getMessage());
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		} catch (WebDriverException we) {
			log.error("WebDriverException found." + we.getMessage());
		} catch (Exception e) {
			log.error("Unknown error found." + e.getMessage());
		}
	}

	public void goTo(String url) {
		try {
			driver.get(url);
			log.info("Loading... " + url);
		} catch (NullPointerException npe) {
			log.error("NullPointerException found.");
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
	}

	public void quit() {
		try {
			driver.quit();
			log.info("Browser Quit completed.");
		} catch (NullPointerException npe) {
			log.error("NullPointerException found.");
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
	}
}
