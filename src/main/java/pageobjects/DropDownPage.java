package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

	private static final Logger log = Logger.getLogger(DropDownPage.class);
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"content\"]/div/h3")
	WebElement dropdownpageHeaderElement;

	@FindBy(id = "dropdown")
	WebElement dropdownElement;

	public DropDownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String dropDownPageAvailiablity() {
		String actualString = null;
		try {
			if (dropdownpageHeaderElement.isDisplayed()) {
				actualString = dropdownpageHeaderElement.getText();
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
		return actualString;
	}

	public boolean getDropDownOptions() {
		boolean status = false;
		Select selectDropDown = new Select(dropdownElement);
		List<WebElement> dropDownOptionElements = selectDropDown.getOptions();
		if (dropDownOptionElements.size() != 0) {
			for (WebElement dropDownOptionElement : dropDownOptionElements) {
				log.info("DropDown Option : " + dropDownOptionElement.getText());
			}
			status = true;
		}
		dropdownElement.click();
		return status;
	}
}