/*
    Auther : Yasmine Elbakry
 */

package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Login extends POM{
	
	@FindBy(name = "username")
    private WebElement email;
    
	@FindBy(name = "password")
    private WebElement password;
	
	@FindBy(xpath = "//button[contains(.,'Login')]")
    private WebElement loginButton;
		
	
	@FindBy(xpath="//*[@id=\"remember-me\"]")
	private WebElement rememberMe;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement warningError; 
	
	public Login(WebDriver driver) {	
		super(driver);
	}
	

    public void insertUsername(String username) {
    	email.clear();
        email.sendKeys(username);
       
    }


    public void insertPassword(String password) {
    	this.password.clear();
        this.password.sendKeys(password);
        
    }

 
    public Account clickOnLoginButtonPass() throws InterruptedException {
        loginButton.click();
        Thread.sleep(4000);        
        return new Account(driver);
       
    }
    public void clickOnLoginButtonFail() {
        loginButton.click();
       
    }

   public void insertData(String email_,String password_)
{	this.insertUsername(email_);
    this.insertPassword(password_);
	}
    
   public void checkRememberMe() throws InterruptedException
   {
	   if(!rememberMe.isSelected())
		{   Actions action = new Actions(driver);

		   action.moveToElement(rememberMe).click().perform();		}	
	   Thread.sleep(1000);
	    
   }
	public boolean isErrorVisible() {
		return warningError.isDisplayed();
	}
	
	public String getErrorMessage() {
		return warningError.getText();
	}
}
