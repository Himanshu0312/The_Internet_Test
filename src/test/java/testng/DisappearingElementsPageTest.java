package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.DisappearingElementsPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class DisappearingElementsPageTest extends BaseTest{
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
	public void verifyFetchMenuElements() {
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
