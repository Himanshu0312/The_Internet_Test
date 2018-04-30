package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Wait;

public class BasicAuthPage {

	private static final Logger log = Logger.getLogger(BasicAuthPage.class);
	WebDriver driver;
	String userName, password;

	@FindBy(xpath = "//*[@id=\'content\']/div/p")
	WebElement successTextElement;

	public BasicAuthPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getSuccessText() {
		String resultStr= null;
		try {
			if(driver != null) {
				new WebDriverWait(driver, Wait.MED.interval()).until(ExpectedConditions.visibilityOf(successTextElement));
				resultStr = successTextElement.getText();
			}
		}catch (ElementNotVisibleException enve) {
			log.error("successTextElement not found." + enve.getMessage());
		}catch(Exception e) {
			log.error("Exception found "+e.getMessage());
		} 
		return resultStr;
	}
}
