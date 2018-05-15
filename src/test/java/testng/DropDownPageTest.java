package testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.DropDownPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class DropDownPageTest extends BaseTest {

	String finalDropdownpageHeaderText = "Dropdown List";

	@BeforeTest
	@Parameters("browserValue")
	public void setup(String browserValue) {
		browser = new MyBrowserManager(Integer.parseInt(browserValue));
		browser.initiate();
	}

	@AfterTest
	public void kill() {
		browser.quit();
	}

	@Test
	public void verifyDropDownPageAvailiablity() {
		String result;
		homePage = new HomePage(browser.getDriver());
		homePage.getHomePage();
		homePage.click(homePage.getDropdownLinkElement());
		browser = homePage.fetchBrowser();
		dropDownPage = new DropDownPage(browser.getDriver());
		result = dropDownPage.dropDownPageAvailiablity();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertEquals(result, finalDropdownpageHeaderText);
	}
	
	@Test
	public void verifyGetDropDownOptions() {
		boolean result;
		result = dropDownPage.getDropDownOptions();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(result);
	}

}
