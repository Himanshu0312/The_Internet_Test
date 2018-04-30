package pageobjects;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenImagesPage {

	private static final Logger log = Logger.getLogger(BrokenImagesPage.class);
	WebDriver driver;

	@FindBy(tagName = "img")
	List<WebElement> imageElements;

	public BrokenImagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int numberOfBrokenImages() {
		int count=0;
		try {
			for (WebElement imageElement : imageElements) {
				HttpResponse response = new DefaultHttpClient().execute(new HttpGet(imageElement.getAttribute("src")));
				if (response.getStatusLine().getStatusCode() != 200) {
					log.info((imageElement.getAttribute("src").toString()) + "broken");
					count+=1;
				}else {
					log.info((imageElement.getAttribute("src").toString()) + "not");
				}		
			}
		}catch (Exception e) {
			log.error("Exception found" + e.getMessage());
		}
		return count;
	}
}
