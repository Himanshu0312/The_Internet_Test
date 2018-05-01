package testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class HomePageTest extends BaseTest {

	HomePage homePage;
	String homePageWelcomeText = "Welcome to the-internet";
	
	@BeforeTest
	public void setup() {
		browser = new MyBrowserManager(commonUtilReader.getBrowserValue());
		startMyBrowser(browser);
	}

	@AfterTest
	public void kill() {
		terminateBrowser();
	}

	@Test
	public void verifyHomePageAvailiablity() {
		homePage = new HomePage(browser.getDriver());
		Assert.assertEquals(fetchHomePageHeaderBase(homePage), homePageWelcomeText);
	}
}