package testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.ChallengingDomPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class ChallengingDomPageTest extends BaseTest {
	@BeforeTest
	public void setup() {
		browser = new MyBrowserManager(1);
		browser.initiate();
	}

	@AfterTest
	public void kill() {
		browser.quit();
	}

	@Test
	public void verifyButtonsAvailiablity() {
		boolean result;
		homePage = new HomePage(browser.getDriver());
		homePage.getHomePage();
		homePage.click(homePage.getChallengingDomLinkElement());
		setBrowser(homePage.fetchBrowser());
		challengingDomPage = new ChallengingDomPage(browser.getDriver());
		result = challengingDomPage.getButtons();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyCanvasAvailiablity() {
		boolean result;
		result = challengingDomPage.isCanvasDisplayed();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(result);
	}
}
