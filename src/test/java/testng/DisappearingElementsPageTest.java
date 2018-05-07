package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.DisappearingElementsPage;
import pageobjects.HomePage;

public class DisappearingElementsPageTest extends BaseTest{
	@BeforeMethod
	public void setup() {
		browser.initiate();
	}

	@AfterMethod
	public void kill() {
		browser.quit();
	}

	@Test
	public void verifyBasicAuthLogin() {
		int count;
		homePage = new HomePage(browser.getDriver());
		homePage.getHomePage();
		homePage.click(homePage.getDisappearingElements());
		setBrowser(homePage.fetchBrowser());
		disappearingElementsPage = new DisappearingElementsPage(browser.getDriver());
		count = disappearingElementsPage.fetchMenuElements();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertEquals(count, 5);
	}
}
