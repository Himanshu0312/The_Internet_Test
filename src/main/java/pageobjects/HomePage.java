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
	MyBrowserManager newBrowser;

	String resultStr;

	String userName = "admin";
	String password = "admin";

	@FindBy(xpath = "//*[@id='content']/h1")
	WebElement headerName;

	@FindBy(linkText = "Basic Auth")
	WebElement basicAuthElemment;

	@FindBy(linkText = "Broken Images")
	WebElement brokenImagesLinkElement;
	
	
	public WebElement getBrokenImagesLinkElement() {
		return brokenImagesLinkElement;
	}

	public WebElement getChallengingDomLinkElement() {
		return challengingDomLinkElement;
	}
	
	@FindBy(linkText = "Checkboxes")
	WebElement checkboxesLinkElement;
	
	@FindBy(linkText = "Disappearing Elements")
	WebElement disappearingElements;
	
	
	public WebElement getDisappearingElements() {
		return disappearingElements;
	}

	public WebElement getCheckboxesLinkElement() {
		return checkboxesLinkElement;
	}

	@FindBy(linkText = "Challenging DOM")
	WebElement challengingDomLinkElement;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getHomePage() {
		try {
			driver.get(CommonUtilsReader.getInstance().getHomePageUrl());
			new WebDriverWait(driver, Wait.MED.interval()).until(ExpectedConditions.visibilityOf(headerName));
		} catch (ElementNotVisibleException enve) {
			log.error("Header Name not found." + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
	}

	public String fetchHomePageHeader() {
		newBrowser = new MyBrowserManager();
		newBrowser.setDriver(driver);
		return headerName.getText();
	}
	
	public MyBrowserManager fetchBrowser() {
		return newBrowser;
	}

	
	public void performBasicAuthLogin() {
		newBrowser = new MyBrowserManager();
		String newBasicAuthUrl = null;
		try {
			if (basicAuthElemment.isDisplayed()) {
				newBasicAuthUrl = (CommonUtilsReader.getInstance().getBasicAuthUrl().replace("USER", userName))
						.replace("PASS", password);
				driver.get(newBasicAuthUrl);
			}
			newBrowser.setDriver(driver);
		} catch (ElementNotVisibleException enve) {
			log.error("Basic Auth Elemment not found." + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
	}

	public void click(WebElement linkTextElementOnHomePage) {
		newBrowser = new MyBrowserManager();
		try {
			if (linkTextElementOnHomePage.isDisplayed()) {
				linkTextElementOnHomePage.click();
				newBrowser.setDriver(driver);
			}
		} catch (ElementNotVisibleException enve) {
			log.error("linkTextElementOnHomePage not found." + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		}catch (Exception e) {
			log.error("Exception found" + e.getMessage());
		}
	}
}
