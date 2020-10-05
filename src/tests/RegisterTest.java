package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeTest;  

import pages.Account;
import pages.Register;
import data_generation.DataProviderRegister;
public class RegisterTest extends SetupTest{
	
	
 
	@BeforeSuite
	public void loadReport()
	{		
		try{report = new ExtentReports(System.getProperty("user.dir") + "/src/OutputResults/RegisterResults/TestRegisterResults.html");
		}
	catch (Exception e) {
		test.log(LogStatus.ERROR, e);
	}
	}
	   @Test(dataProvider="validRegister",dataProviderClass=DataProviderRegister.class)
		public void validRegister(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword) {
		      RegisterTestHelpers.validRegister(firstname,lastname,mobilephone,email,password,confirmpassword);
		    }
	@Test(dataProvider="firstNameEqualsLastName",dataProviderClass=DataProviderRegister.class)
	public void firstNameEqualsLastName(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword) {
		      RegisterTestHelpers.firstNameEqualsLastName(firstname,lastname,mobilephone,email,password,confirmpassword);

    }		
	@Test
	public void nullFields(){
		try {RegisterTestHelpers.nullFields();}
		  catch(IllegalArgumentException e)
	   {
	    System.out.println(e);
	   }	 
	}
	@Test
	public void emptyStringFields(){
		RegisterTestHelpers.emptyStringFields();

	}
	
    @Test(dataProvider="nonUniqueEmail",dataProviderClass=DataProviderRegister.class)
	public void nonUniqueEmail(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword){
		RegisterTestHelpers.nonUniqueEmail(firstname,lastname,mobilephone,email,password,confirmpassword);

	}   


	 
	
    @Test(dataProvider="firstNameDigit",dataProviderClass=DataProviderRegister.class)
    public void firstNameDigit(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {
    	RegisterTestHelpers.firstNameDigit(firstname,lastname,mobilephone,email,password,confirmpassword);
    	
    }

    @Test(dataProvider="lastNameDigit",dataProviderClass=DataProviderRegister.class)
    public void lastNameDigit(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    { 
    	RegisterTestHelpers.lastNameDigit(firstname,lastname,mobilephone,email,password,confirmpassword);
    	 
    }
    @Test(dataProvider="firstNameFirstLetterSmall",dataProviderClass=DataProviderRegister.class) 
    public void firstNameFirstLetterSmall(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {
    	RegisterTestHelpers.firstNameFirstLetterSmall(firstname,lastname,mobilephone,email,password,confirmpassword);
    	
    }
    
    @Test(dataProvider="lastNameFirstLetterSmall",dataProviderClass=DataProviderRegister.class) 
    public void lastNameFirstLetterSmall(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
    {
    	RegisterTestHelpers.lastNameFirstLetterSmall(firstname,lastname,mobilephone,email,password,confirmpassword);
    }
    
    @Test(dataProvider="phoneNumberChar",dataProviderClass=DataProviderRegister.class) 
	public void phoneNumberChar(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.phoneNumberChar(firstname,lastname,mobilephone,email,password,confirmpassword);
	}
	
    @Test(dataProvider="phoneNumber1Digit",dataProviderClass=DataProviderRegister.class)  
	public void phoneNumber1Digit(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.phoneNumber1Digit(firstname,lastname,mobilephone,email,password,confirmpassword);
	}
	
    @Test(dataProvider="invalidEmailFormat1",dataProviderClass=DataProviderRegister.class)  
	public void invalidEmailFormat1(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{   RegisterTestHelpers.invalidEmailFormat1(firstname,lastname,mobilephone,email,password,confirmpassword);
	}
	
    @Test(dataProvider="invalidEmailFormat2",dataProviderClass=DataProviderRegister.class)  
	public void invalidEmailFormat2(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.invalidEmailFormat2(firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	

    
    @Test(dataProvider="passwordWithoutCapital",dataProviderClass=DataProviderRegister.class)  
	public void passwordWithoutCapital(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.passwordWithoutCapital(firstname,lastname,mobilephone,email,password,confirmpassword);

	}
    @Test(dataProvider="passwordWithoutSmall",dataProviderClass=DataProviderRegister.class)  
	public void passwordWithoutSmall(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.passwordWithoutSmall(firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
    @Test(dataProvider="passwordExceedLength",dataProviderClass=DataProviderRegister.class)  
	public void passwordExceedLength(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.passwordExceedLength(firstname,lastname,mobilephone,email,password,confirmpassword);

	}
	
    @Test(dataProvider="passwordLessThanMinLength",dataProviderClass=DataProviderRegister.class)  
	public void passwordLessThanMinLength(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{    	RegisterTestHelpers.passwordLessThanMinLength(firstname,lastname,mobilephone,email,password,confirmpassword);

    	
	}
		
    @Test(dataProvider="passwordConfirmMissmatch",dataProviderClass=DataProviderRegister.class)  
	public void passwordConfirmMissmatch(String firstname,String lastname,String mobilephone,String email,String password,String confirmpassword)
	{
    	RegisterTestHelpers.passwordConfirmMissmatch(firstname,lastname,mobilephone,email,password,confirmpassword);

	}
    

//@Test(dataProvider="validRegister",dataProviderClass=DataProviderRegister.class,groups={"RegisterTest.validRegister"})

	
	
}
