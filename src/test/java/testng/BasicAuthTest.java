package testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.BasicAuthPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class BasicAuthTest extends BaseTest {

	HomePage homePage;
	BasicAuthPage basicAuthPage;

	String successAuthText = "Congratulations! You must have the proper credentials.";

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
	public void verifyBasicAuthLogin() {
		homePage = new HomePage(browser.getDriver());
		fetchHomePageHeaderBase(homePage);
		browser = homePage.basicAuthLogin();
		basicAuthPage = new BasicAuthPage(browser.getDriver());
		Assert.assertEquals(performBasicAuthLogin(basicAuthPage), successAuthText);
	}
}