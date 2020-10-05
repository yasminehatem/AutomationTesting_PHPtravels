/*
    Auther : Yasmine Elbakry
 */ 
package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register extends POM {
		
	@FindBy(name = "firstname")
    private WebElement firstName;
	
	@FindBy(name = "lastname")
    private WebElement lastName;
    
	@FindBy(name = "phone")
    private WebElement phone;
	
	@FindBy(name = "password")
    private WebElement password;

	@FindBy(name = "email")
    private WebElement email;
	
	@FindBy(name = "confirmpassword")
    private WebElement confirmPassword;
	
	@FindBy(className="signupbtn")
	private WebElement signupButton;
	
	@FindBy(xpath = "//*[@id=\"headersignupform\"]/div[2]/div")
	private WebElement warningError; 
	
	
	public Register(WebDriver driver) {	
		super(driver);
	}
	

	public void insertFirstName(String firstname) {
		this.firstName.clear();
        this.firstName.sendKeys(firstname);
       
	}
  

    public void insertLastName(String lastname) {
    	this.lastName.clear();
        this.lastName.sendKeys(lastname);
       
    }
    
    public void insertPhone(String phone) {
    	this.phone.clear();
        this.phone.sendKeys(phone);
       
    }

    
    public void insertEmail(String email) {
    	this.email.clear();
        this.email.sendKeys(email);
       
    }
    public void insertPassword(String password) {
    	this.password.clear();
        this.password.sendKeys(password);       
    }

    public void confirmPassword(String confirmpassword) {
 
    	this.confirmPassword.clear();
    	this.confirmPassword.sendKeys(confirmpassword);
       
    }

    public String getTitle() {
		return driver.getTitle();
	}
    public Account clickOnSignupButtonPass() {
        signupButton.click();
        return new Account(driver);
       
    }
    public void clickOnSignupButtonFail() {
        signupButton.click();
       
    }
    
    public boolean isErrorVisible() {
		return warningError.isDisplayed();
	}
	
	public String getErrorMessage() {
		return warningError.getText();
	}

	   public void insertData(String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_)
	   {	this.insertFirstName(firstname_);
		this.insertLastName(lastname_);
		this.insertPhone(mobilephone_);
		this.insertEmail(email_);
		this.insertPassword(password_);
		this.confirmPassword(confirmpassword_);
	   	}



    
    
}


