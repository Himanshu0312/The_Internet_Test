package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.BrokenImagesPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class BrokenImagesTest extends BaseTest {

	@BeforeMethod
	public void beforeTest() {
		browser = new MyBrowserManager(1);
		browser.initiate();
	}

	@AfterMethod
	public void kill() {
		browser.quit();
	}

	@Test
	public void verifyBrokenImagaes() {
		homePage = new HomePage(browser.getDriver());
		homePage.getHomePage();
		int acutalCount;
		homePage.clickOnBrokenImagesLink();
		setBrowser(homePage.fetchBrowser());
		brokenImagesPage = new BrokenImagesPage(browser.getDriver());
		acutalCount = brokenImagesPage.numberOfBrokenImages();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertEquals(acutalCount, 2, "Found broken images");
	}
}
