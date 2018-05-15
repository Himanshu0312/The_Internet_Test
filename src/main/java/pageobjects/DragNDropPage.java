package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragNDropPage {

	private static final Logger log = Logger.getLogger(DragNDropPage.class);
	WebDriver driver;

	@FindBy(id = "column-a")
	WebElement firstElement;

	@FindBy(xpath = "//*[@id=\"column-a\"]/header")
	WebElement firstElementHeader;

	@FindBy(id = "column-b")
	WebElement secondElement;

	@FindBy(xpath = "//*[@id=\"column-b\"]/header")
	WebElement secondElementHeader;

	public DragNDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean dragAToB() {
		boolean result = false;
		try {
			String firstElementHeaderText = firstElementHeader.getText();

			(new Actions(driver)).dragAndDrop(firstElement, secondElement).build().perform();
			/*
			 * new Actions(driver).clickAndHold(firstElement).moveToElement(secondElement).
			 * release(firstElement).build() .perform();
			 */
			if (firstElementHeaderText.equals(secondElementHeader.getText())) {
				result = true;
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
		return result;
	}

	public boolean dragBToA() {
		boolean result = false;

		return result;
	}
}
