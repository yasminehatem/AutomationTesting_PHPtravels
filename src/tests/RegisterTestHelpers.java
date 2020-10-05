package tests;

import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;

import data_generation.DataProviderRegister;
import pages.Account;
import pages.Register;

public class RegisterTestHelpers extends SetupTest {
	public static void validRegister(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword) {
      handleRegisterPos("validRegister",firstname,lastname,mobilephone,email,password,confirmpassword);
    }
	
	
	
	public static void firstNameEqualsLastName(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword) {

	      handleRegisterNeg("firstNameEqualsLastName",firstname,lastname,mobilephone,email,password,confirmpassword);

    }
	
	public static void nullFields(){
	      handleRegisterNeg("nullFields",null,null,null,null,null,null);

	
	}

	public static void emptyStringFields(){
		//RegisterTestHelpers.emptyStringFeilds();
	   // Assert.assertEquals(RegisterTestHelpers.registerPending("","","","","",""),"Register");
	      handleRegisterNeg("emptyStringFields","","","","","","");

	}
	 
	
    public static void firstNameDigit(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {
        handleRegisterNeg("firstNameDigit",firstname,lastname,mobilephone,email,password,confirmpassword);

    }


    public static void lastNameDigit(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {      handleRegisterNeg("lastNameDigit",firstname,lastname,mobilephone,email,password,confirmpassword);

    	
    }
    public static void firstNameFirstLetterSmall(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {      handleRegisterNeg("firstNameFirstLetterSmall",firstname,lastname,mobilephone,email,password,confirmpassword);

    }
    
    public static void lastNameFirstLetterSmall(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {      handleRegisterNeg("lastNameFirstLetterSmall",firstname,lastname,mobilephone,email,password,confirmpassword);

    }
    
	public static void phoneNumberChar(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("phoneNumberChar",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	public static void phoneNumber1Digit(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("phoneNumber1Digit",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	public static void invalidEmailFormat1(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{        handleRegisterNeg("invalEmailFormat1",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	public static void invalidEmailFormat2(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("invalEmailFormat2",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	public static void nonUniqueEmail(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	
	{      handleRegisterNeg("nonUniqueEmail",firstname,lastname,mobilephone,email,password,confirmpassword);
	}
    
	public static void passwordWithoutCapital(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("passwordWithoutCapital",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	public static void passwordWithoutSmall(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("passwordWithoutSmall",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	public static void passwordExceedLength(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("passwordExceedLength",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	public static void passwordLessThanMinLength(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("passwordLessThanMinLength",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	public static void passwordConfirmMissmatch(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{      handleRegisterNeg("passwordConfirmMissmatch",firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
	
	
	
	public static Register register(String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_)
	{    driver.get("http://www.phptravels.net/register");
		sleep();
		Register registerPage = new Register(driver);
		registerPage.insertData(firstname_, lastname_, mobilephone_, email_, password_, confirmpassword_);
        return registerPage;
		}
	public static Account registerPass(String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_){
	 
		Account accountPage = register(firstname_, lastname_, mobilephone_, email_, password_, confirmpassword_).clickOnSignupButtonPass();
		sleep();
		return accountPage;

	}
	public  static String registerFail(String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_){
		Register registerPage = register(firstname_, lastname_, mobilephone_, email_, password_, confirmpassword_);
		registerPage.clickOnSignupButtonFail();
		sleep();
		return registerPage.getErrorMessage();

	}
	
	public static String registerPending(String reportCaseName,String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_){
		Register registerPage = register(firstname_, lastname_, mobilephone_, email_, password_, confirmpassword_);
		sleep();
		registerPage.clickOnSignupButtonFail();
		sleep();
		return driver.getTitle();

	}
	
	public static void handleRegisterPos(String reportCaseName,String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_)
	{
		try {
			test = report.startTest(reportCaseName);
			Assert.assertEquals(registerPass(firstname_, lastname_, mobilephone_, email_, password_, confirmpassword_).getTitle(), "My Account");
			test.log(LogStatus.PASS, "Register "+reportCaseName+"Passed ");
			SetupTest.takeScreenshot(reportCaseName, test, "/RegisterResults/");
	        report.endTest(test);
			}
			catch(AssertionError e)
			{     test.log(LogStatus.FAIL, "Register "+reportCaseName+"failed ");
				  SetupTest.takeScreenshot(reportCaseName, test, "/RegisterResults/");
	              report.endTest(test);
	              throw new AssertionError(); //Notify TestNG that case failed
				  

			}
	}
	public static void handleRegisterNeg(String reportCaseName,String firstname_,String lastname_,String mobilephone_,String email_,String password_,String confirmpassword_)
	{
		try {
			test = report.startTest(reportCaseName);
			Assert.assertEquals(registerPass(firstname_, lastname_, mobilephone_, email_, password_, confirmpassword_).getTitle(), "Register");
			test.log(LogStatus.PASS, "Register "+reportCaseName+"Passed ");
			SetupTest.takeScreenshot(reportCaseName, test, "/RegisterResults/");
	        report.endTest(test);
			}
			catch(Error e)
			{     test.log(LogStatus.FAIL, "Register "+reportCaseName+"failed ");
				  SetupTest.takeScreenshot(reportCaseName, test, "/RegisterResults/");
	              report.endTest(test);
	              throw new AssertionError(); //Notify TestNG that case failed
				  

			}
	}
	
	
	
}
