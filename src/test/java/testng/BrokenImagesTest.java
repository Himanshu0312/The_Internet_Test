package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BrokenImagesPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class BrokenImagesTest extends BaseTest {

	HomePage homePage;
	BrokenImagesPage brokenImagesPage;

	@BeforeMethod
	public void beforeTest() {
		browser = new MyBrowserManager(commonUtilReader.getBrowserValue());
		startMyBrowser(browser);
	}

	@AfterMethod
	public void kill() {
		terminateBrowser();
	}

	@Test
	public void verifyBrokenImagaes() {
		homePage = new HomePage(browser.getDriver());
		fetchHomePageHeaderBase(homePage);
		browser = homePage.clickOnBrokenImagesLink();
		brokenImagesPage = new BrokenImagesPage(browser.getDriver());
		Assert.assertEquals(brokenImagesPage.numberOfBrokenImages(), 2, "Found broken images");
	}
}
