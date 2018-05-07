package testng;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.CheckboxesPage;
import pageobjects.HomePage;


public class CheckboxesPageTest extends BaseTest{
	@BeforeTest
	public void setup() {
		browser.initiate();
	}

	@AfterTest
	public void kill() {
		browser.quit();
	}
	
	@Test
	public void verifyCheckAllCheckboxes() {
		boolean result;
		homePage = new HomePage(browser.getDriver());
		homePage.getHomePage();
		homePage.click(homePage.getCheckboxesLinkElement());
		setBrowser(homePage.fetchBrowser());
		checkboxesPage = new CheckboxesPage(browser.getDriver());
		result = checkboxesPage.checkAllCheckboxes();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyUncheckAllCheckboxes() {
		boolean result;
		result = checkboxesPage.uncheckAllCheckboxes();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(result);
	}
}