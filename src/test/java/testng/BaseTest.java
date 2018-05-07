package testng;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import pageobjects.BasicAuthPage;
import pageobjects.BrokenImagesPage;
import pageobjects.ChallengingDomPage;
import pageobjects.CheckboxesPage;
import pageobjects.DisappearingElementsPage;
import pageobjects.HomePage;
import utilities.CommonUtilsReader;
import utilities.MyBrowserManager;

public class BaseTest {

	private static final Logger log = Logger.getLogger(BrokenImagesPage.class);
	
	HomePage homePage;
	BasicAuthPage basicAuthPage;
	BrokenImagesPage brokenImagesPage;
	ChallengingDomPage challengingDomPage;
	CheckboxesPage checkboxesPage;
	DisappearingElementsPage disappearingElementsPage;
	
	MyBrowserManager browser= new MyBrowserManager(1);

	public MyBrowserManager getBrowser() {
		return browser;
	}

	public void setBrowser(MyBrowserManager browser) {
		this.browser = browser;
	}

	public void screenshot(String currentRunningTestClassName, String currentRunningFunctionName) {
		try {
			String sourcePath = CommonUtilsReader.getInstance().getScreenshotLocation();
			sourcePath = sourcePath.replace("CLASS", currentRunningTestClassName);
			sourcePath = sourcePath.replace("METHOD", currentRunningFunctionName);
			sourcePath = sourcePath.replace("NAME",
					new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date()).toString());
			TakesScreenshot screenShot = ((TakesScreenshot) browser.getDriver());
			File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(sourcePath);
			FileUtils.copyFile(sourceFile, destinationFile);
			log.info("Your File is at : "+sourcePath);
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
	}	
}
