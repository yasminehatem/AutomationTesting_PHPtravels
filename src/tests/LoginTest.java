/*
    Auther : Yasmine Elbakry 
 */

package tests;

import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.Account;
import pages.Login;
import data_generation.DataProviderLogin;
public class LoginTest extends SetupTest {
	@BeforeSuite
	public void loadReport()
	{		
		try{report = new ExtentReports(System.getProperty("user.dir") + "/src/OutputResults/LoginResults/TestLoginResults.html");
		}
	catch (Exception e) {
		test.log(LogStatus.ERROR, e);
	}
	}
	@Test(dataProvider="rememberMe",dataProviderClass=DataProviderLogin.class)
	public void RememberMe(String email,String password) throws InterruptedException {
	    
		LoginTestHelpers.rememberMe(email,password);
    } 
	@Test(dataProviderClass=DataProviderLogin.class,dataProvider="invalidPasswordLogin")
	public void invalidPasswordLogin(String email,String password){
		LoginTestHelpers.invalidPasswordLogin(email,password);

	}

	//@Test(dataProvider="validLogin",dataProviderClass=DataProviderLogin.class,dependsOnGroups={"RegisterTest.validRegister"})


	
	@Test(dataProviderClass=DataProviderLogin.class,dataProvider="invalidEmailLogin")
	public void invalidEmailLogin(String email,String password){
            
	LoginTestHelpers.invalidEmailLogin(email,password);

		}
	
	@Test
	public void emptyStringFields(){
      LoginTestHelpers.emptyStringFields();
}
	

	@Test
	public void nullFields(){
		LoginTestHelpers.nullFields();
	  

	}
	
	
	@Test(dataProvider="validLogin",dataProviderClass=DataProviderLogin.class)
	public void validLogin(String email,String password) throws InterruptedException {
	    
		LoginTestHelpers.validLogin(email,password);
    } 
	


	

	
	
}

