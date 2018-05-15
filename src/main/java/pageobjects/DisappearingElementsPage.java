package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisappearingElementsPage {

	private static final Logger log = Logger.getLogger(ChallengingDomPage.class);

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li")
	List<WebElement> menuElements;

	WebDriver driver;

	public DisappearingElementsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int fetchMenuElements() {
		try {
			for (WebElement webElement : menuElements) {
				log.info("Visible Menu : " + webElement.getText());
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
		return menuElements.size();
	}
}
