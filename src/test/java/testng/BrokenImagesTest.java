package testng;

import org.testng.annotations.Test;

import pageobjects.BrokenImagesPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class BrokenImagesTest extends BaseTest {

	HomePage homePage;
	BrokenImagesPage brokenImagesPage;

	@BeforeTest
	public void beforeTest() {
		browser = new MyBrowserManager("Google Chrome");
		startMyBrowser(browser);
	}

	@AfterTest
	public void kill() {
		terminateBrowser();
	}

	@Test
	public void verifyBrokenImagaes() {
		homePage = new HomePage(browser.getDriver());
		fetchHomePageHeaderBase(homePage);
		browser = homePage.clickOnBrokenImagesLink();
		brokenImagesPage = new BrokenImagesPage(browser.getDriver());
		Assert.assertEquals(brokenImagesPage.numberOfBrokenImages(), 0, "Found broken images");
	}
}
