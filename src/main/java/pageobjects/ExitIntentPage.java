package pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.ThrowableRendererSupport;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExitIntentPage {

	private static final Logger log = Logger.getLogger(ExitIntentPage.class);
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/h3")
	WebElement exitIntentPageHeaderTextElement;
	
	
	
	public ExitIntentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getExitIntentPageHeader() {
		String actualText = null;
		try {
			if(exitIntentPageHeaderTextElement.isDisplayed()) {
				if(exitIntentPageHeaderTextElement.getText() != null) {
					actualText = exitIntentPageHeaderTextElement.getText();
				}else {
					throw new NullPointerException("Exit Intent page header is found to be null");
				}
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
		return actualText;
	}
	
	
}
