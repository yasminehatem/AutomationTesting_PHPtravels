package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;

public class Account extends POM {
	@FindBy(css = "\".col-md-8 > h3\"")
    public WebElement greeting;
	
	@FindBy(xpath="//a[@id='dropdownCurrency' ]//i[@class='bx bx-user']") 
  public WebElement dropDown;
	
	@FindBy(xpath="//a[@class='dropdown-item tr' and contains(text(),'Logout')]")
    public WebElement logoutButton;
	
	public Account(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	 public String getGreetingMsg() {
	        return greeting.getText();
	    }
	 
	   public Login clickOnLogoutButton() throws InterruptedException {
	      Actions action = new Actions(driver);
            
	        action.moveToElement(dropDown).click().perform();
		    Thread.sleep(2000);
	        action.moveToElement(logoutButton).click().perform();
		    Thread.sleep(2000);

	        return new Login(driver);
	       
	    }
}
