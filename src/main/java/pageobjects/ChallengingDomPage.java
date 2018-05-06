package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChallengingDomPage {

	private static final Logger log = Logger.getLogger(ChallengingDomPage.class);
	WebDriver driver;

	@FindBy(className = "button")
	WebElement buttonElement;

	@FindBy(xpath = "//*[contains(@class,'alert')]")
	WebElement buttonStartElement;

	@FindBy(xpath = "//*[contains(@class,'success')]")
	WebElement buttonSuccessElement;
	
	@FindBy(id = "canvas")
	WebElement canvasElement;

	public ChallengingDomPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getButtons() {
		boolean status = false;
		log.info("Searching all buttons..");
		try {
			if (buttonElement.isDisplayed() && buttonStartElement.isDisplayed() && buttonSuccessElement.isDisplayed()) {
				status = true;
				log.info("Found all Buttons.");
			}
		} catch (ElementNotVisibleException enve) {
			log.error("Element Not Visible" + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
		return status;
	}

	public boolean isCanvasDisplayed() {
		boolean status = false;
		log.info("Searching canvas element..");
		try {
			if(canvasElement.isDisplayed()) {
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", canvasElement);
				status = true;
				log.info("Found canvas element.");
			}
		} catch (ElementNotVisibleException enve) {
			log.error("Element Not Visible" + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}	
		return status;
	}
}
