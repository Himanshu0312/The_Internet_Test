package pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisappearingElementsPage {

	private static final Logger log = Logger.getLogger(ChallengingDomPage.class);
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li")
	List<WebElement>  menuElements;
	
	WebDriver driver;
	
	public DisappearingElementsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public int fetchMenuElements() {
		for (WebElement webElement : menuElements) {
			log.info("Visible Menu : "+webElement.getText());
		}
		return menuElements.size();
	}
}
