package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtilsReader;
import utilities.MyBrowserManager;
import utilities.Wait;

public class HomePage {

	private static final Logger log = Logger.getLogger(HomePage.class);
	WebDriver driver;
	CommonUtilsReader commonUtilsReader;

	String userName = "admin";
	String password = "admin";

	@FindBy(xpath = "//*[@id='content']/h1")
	WebElement headerName;

	@FindBy(linkText = "Basic Auth")
	WebElement basicAuthElemment;

	@FindBy(linkText = "Broken Images")
	WebElement brokenImagesLinkElement;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtilsReader = new CommonUtilsReader();
	}

	public String fetchHomePageHeader() {
		String resultStr = null;
		try {
			driver.get(commonUtilsReader.getHomePageUrl());
			new WebDriverWait(driver, Wait.MED.interval()).until(ExpectedConditions.visibilityOf(headerName));
			resultStr = headerName.getText();
		} catch (ElementNotVisibleException enve) {
			log.error("Header Name not found." + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		}
		return resultStr;
	}

	public MyBrowserManager basicAuthLogin() {
		String newBasicAuthUrl = null;
		MyBrowserManager newBrowser = new MyBrowserManager();
		try {
			if (basicAuthElemment.isDisplayed()) {
				newBasicAuthUrl = (commonUtilsReader.getBasicAuthUrl().replace("USER", userName)).replace("PASS",
						password);
				if (newBasicAuthUrl != null) {
					driver.get(newBasicAuthUrl);
				}
			}
			newBrowser.setDriver(driver);
		} catch (ElementNotVisibleException enve) {
			log.error("Basic Auth Elemment not found." + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
		return newBrowser;
	}

	public MyBrowserManager clickOnBrokenImagesLink() {
		MyBrowserManager newBrowser = new MyBrowserManager();
		try {
			brokenImagesLinkElement.click();
			newBrowser.setDriver(driver);
		} catch (ElementNotVisibleException enve) {
			log.error("brokenImagesLinkElement not found." + enve.getMessage());
		} catch (Exception e) {
			log.error("Exception found" + e.getMessage());
		}
		return newBrowser;
	}
}
