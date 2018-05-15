package testng;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageobjects.DragNDropPage;
import pageobjects.HomePage;
import utilities.MyBrowserManager;

public class DragNDropPageTest extends BaseTest {
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
	public void verifyDragAtoB() {
		homePage = new HomePage(browser.getDriver());
		boolean result;
		homePage.getHomePage();
		homePage.click(homePage.getDragNDrop());
		setBrowser(homePage.fetchBrowser());
		dragNDropPage =  new DragNDropPage(browser.getDriver());
		result = dragNDropPage.dragAToB();
		screenshot(this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
		Assert.assertTrue(result);
	}

}
