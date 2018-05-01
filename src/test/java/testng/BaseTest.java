package testng;

import pageobjects.BasicAuthPage;
import pageobjects.HomePage;
import utilities.CommonUtilsReader;
import utilities.MyBrowserManager;

public class BaseTest {

	MyBrowserManager browser;
	CommonUtilsReader commonUtilReader = new CommonUtilsReader();

	public MyBrowserManager getBrowser() {
		return browser;
	}

	public void setBrowser(MyBrowserManager browser) {
		this.browser = browser;
	}

	public void startMyBrowser(MyBrowserManager browser) {
		this.browser = browser;
		this.browser.initiate();
	}

	public String fetchHomePageHeaderBase(HomePage homePage) {
		return homePage.fetchHomePageHeader();
	}

	public void terminateBrowser() {
		browser.quit();
	}

	public String performBasicAuthLogin(BasicAuthPage basicAuthPage) {
		return basicAuthPage.getSuccessText();
	}
}
