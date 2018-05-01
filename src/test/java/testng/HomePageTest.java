package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class HomePageTest extends BaseTest {

	HomePage homePage;
	String homePageWelcomeText = "Welcome to the-internet";
	
	@BeforeMethod
	public void setup() {
		browser = new MyBrowserManager(commonUtilReader.getBrowserValue());
		startMyBrowser(browser);
	}

	@AfterMethod
	public void kill() {
		terminateBrowser();
	}

	@Test
	public void verifyHomePageAvailiablity() {
		homePage = new HomePage(browser.getDriver());
		Assert.assertEquals(fetchHomePageHeaderBase(homePage), homePageWelcomeText);
	}
}