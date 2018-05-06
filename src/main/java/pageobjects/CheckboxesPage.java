package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage {
	private static final Logger log = Logger.getLogger(HomePage.class);
	WebDriver driver;

	@FindBy(xpath = "//*[@id='checkboxes']/input")
	List<WebElement> checkboxElements;

	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean uncheckAllCheckboxes() {
		boolean status = false;
		try {
			for (WebElement checkboxElement : checkboxElements) {
				if (checkboxElement.isSelected()) {
					checkboxElement.click();
				}
			}
			status = true;
		} catch (ElementNotVisibleException enve) {
			log.error("Element Not Visible." + enve.getMessage());
		} catch (TimeoutException te) {
			log.error("TimeoutException found." + te.getMessage());
		} catch (NullPointerException npe) {
			log.error("NullPointerException found." + npe.getMessage());
		} catch (Exception e) {
			log.error("Exception found." + e.getMessage());
		}
		return status;
	}

	public boolean checkAllCheckboxes() {
		boolean status = false;
		try {
			for (WebElement checkboxElement : checkboxElements) {
				if (!checkboxElement.isSelected()) {
					checkboxElement.click();
				}
			}
			status = true;
		} catch (ElementNotVisibleException enve) {
			log.error("Element Not Visible." + enve.getMessage());
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
