package tests;
import pages.Account;
import pages.Login;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
public class LoginTestHelpers extends SetupTest {

	public static void validLogin(String email,String password) throws InterruptedException{
        handleLoginPos("Valid  Login Test",email,password);
		
}
	public static void rememberMe(String email,String password) throws InterruptedException{
		rememberMeCheck(email,password);
		
}
	public static void invalidEmailLogin(String email,String password){
        handleLoginNeg("invalidEmailLogin",email,password);
		
}
	public static void invalidPasswordLogin(String email,String password){
        handleLoginNeg("Invalid Password Login Test",email,password);
		
}

	public static void emptyStringFields(){
		  handleLoginNeg("Empty Strings Login Test","","");


	}
	public static void nullFields(){
		  handleLoginNeg("Null Strings Login Test",null,null);


	}

public static Login login(String email_,String password_)
{   driver.get("http://www.phptravels.net/login");
	Login loginPage = new Login(driver);
    loginPage.insertData(email_,password_);
	return loginPage;
	}
public static Account loginPass(String email_,String password_) throws InterruptedException{
    
	Account accountPage = login(email_,password_).clickOnLoginButtonPass();
	return accountPage;

}

public static String loginFail(String email_,String password_){
    Login loginPage=login(email_,password_);
    loginPage.clickOnLoginButtonFail();
	sleep();
	return loginPage. getErrorMessage();

}
public static void handleLoginNeg(String reportCaseName,String email,String password)
{
	try {
		test = report.startTest(reportCaseName);
		Assert.assertEquals(loginFail(email,password), "Invalid Email or Password");
		test.log(LogStatus.PASS, "Login"+reportCaseName+" Passed ");
		SetupTest.takeScreenshot(reportCaseName, test, "/LoginResults/");
        report.endTest(test);
		}
		catch(AssertionError e)
		{     test.log(LogStatus.FAIL, "Login "+reportCaseName+"failed ");
			  SetupTest.takeScreenshot(reportCaseName, test, "/LoginResults/");
              report.endTest(test);
              throw new AssertionError(); //Notify TestNG that case failed
			  

		}
}
public static void handleLoginPos(String reportCaseName,String email,String password) throws InterruptedException
{
	try {
		test = report.startTest(reportCaseName);
		Assert.assertEquals(loginPass(email,password).getTitle(), "My Account");
		test.log(LogStatus.PASS, "Login "+reportCaseName+"Passed ");
		SetupTest.takeScreenshot(reportCaseName, test, "/LoginResults/");
        report.endTest(test);
		}
		catch(AssertionError e)
		{     test.log(LogStatus.FAIL, "Login "+reportCaseName+"failed ");
			  SetupTest.takeScreenshot(reportCaseName, test, "/LoginResults/");
              report.endTest(test);
              throw new AssertionError(); //Notify TestNG that case failed
			  

		}
}
public static void rememberMeCheck(String email_,String password_) throws InterruptedException
{   Login loginPage=login(email_,password_);
    loginPage.checkRememberMe();
    
    Account accountPage = loginPage.clickOnLoginButtonPass();
    sleep();
	Login loginRedirect=accountPage.clickOnLogoutButton();
	Account accountPageRememberMe =loginRedirect.clickOnLoginButtonPass();
	try {
		test = report.startTest("Remember Me");
		Assert.assertEquals(accountPageRememberMe.getTitle(), "My Account");
		test.log(LogStatus.PASS, "Remember Me Redirected Without Re-inserting Credentiels ");
		SetupTest.takeScreenshot("Remember Me", test, "/LoginResults/");
        report.endTest(test);
		}
		catch(AssertionError e)
		{     test.log(LogStatus.FAIL, "Login with Remember Me failed");
			  SetupTest.takeScreenshot("Remember Me", test, "/LoginResults/");
              report.endTest(test);
              throw new AssertionError(); //Notify TestNG that case failed
			  

		}
	}
}
