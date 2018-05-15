package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class HomePageTest extends BaseTest {

	@BeforeMethod
	@Parameters("browserValue")
	public void setup(String browserValue) {
		browser= new MyBrowserManager(Integer.parseInt(browserValue));
		browser.initiate();
	}

	@AfterMethod
	public void kill() {
		browser.quit();
	}

	@Test
	public void verifyHomePageAvailiablity() {
		homePage = new HomePage(browser.getDriver());
		String actualText;
		String homePageWelcomeText = "Welcome to the-internet";
		homePage.getHomePage();
		actualText = homePage.fetchHomePageHeader();
		setBrowser(homePage.fetchBrowser());
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertEquals(actualText, homePageWelcomeText);
	}
}