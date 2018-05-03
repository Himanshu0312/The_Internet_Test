package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BasicAuthPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class BasicAuthTest extends BaseTest {

	@BeforeMethod
	public void setup() {
		browser = new MyBrowserManager(1);
		browser.initiate();
	}

	@AfterMethod
	public void kill() {
		browser.quit();
	}

	@Test
	public void verifyBasicAuthLogin() {
		homePage = new HomePage(browser.getDriver());
		String actualText;
		String successAuthText = "Congratulations! You must have the proper credentials.";
		homePage = new HomePage(browser.getDriver());
		homePage.getHomePage();
		homePage.performBasicAuthLogin();
		setBrowser(homePage.fetchBrowser());
		basicAuthPage = new BasicAuthPage(browser.getDriver());
		actualText = basicAuthPage.getSuccessText();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertEquals(actualText, successAuthText);
	}
}