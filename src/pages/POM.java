package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class POM {
	
	protected WebDriver driver;
	
	public POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
