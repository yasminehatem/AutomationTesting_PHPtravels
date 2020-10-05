package data_generation;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data_generation.ExcelUtils;
import tests.RegisterTestHelpers;
public class DataProviderRegister {

	
	public  String sTestCaseName;
	public  int iTestCaseRow;
	
	
	@DataProvider(name = "validRegister")
	 public  Object[][] validRegister() throws Exception
	{
    	return getData("validRegister");
    }
 
	@DataProvider(name = "firstNameDigit")
    public Object[][] firstNameDigit()throws Exception
    {return getData("firstNameDigit");
    	
    }
	
	@DataProvider(name = "firstNameEqualsLastName")
    public Object[][] firstNameEqualsLastName()throws Exception
    {return getData("firstNameEqualsLastName");
    	
    }
	
	@DataProvider(name = "lastNameDigit")
    public Object[][] lastNameDigit()throws Exception
    {
    	return getData("lastNameDigit");
    }
	
	
	@DataProvider(name = "firstNameFirstLetterSmall")
    public Object[][] firstNameFirstLetterSmall()throws Exception
    {return getData("firstNameFirstLetterSmall");
    }
    
	
	@DataProvider(name = "lastNameFirstLetterSmall")
    public Object[][] lastNameFirstLetterSmall()throws Exception
    {return getData("lastNameFirstLetterSmall");
    }
    
	
	@DataProvider(name = "phoneNumberChar")
	public Object[][] phoneNumberChar()throws Exception
	{return getData("phoneNumberChar");
	}
	
	
	@DataProvider(name = "phoneNumber1Digit")
	public Object[][] phoneNumber1Digit()throws Exception
	{return getData("phoneNumber1Digit");
	}
	
	
	@DataProvider(name = "invalidEmailFormat1")
	public Object[][] invalidEmailFormat1()throws Exception
	{return getData("invalidEmailFormat1");
	}
	
	
	@DataProvider(name = "invalidEmailFormat2")
	public Object[][] invalidEmailFormat2()throws Exception
	{return getData("invalidEmailFormat2");
	}
	
	
	@DataProvider(name = "nonUniqueEmail") 
	public Object[][] nonUniqueEmail()throws Exception
	
	{return getData("nonUniqueEmail");
	}
	
	
	@DataProvider(name = "passwordWithoutCapital") 
	public Object[][] passwordWithoutCapital()throws Exception
	{return getData("passwordWithoutCapital");
	}
	
	
	@DataProvider(name = "passwordWithoutSmall")
	public Object[][] passwordWithoutSmall()throws Exception
	{return getData("passwordWithoutSmall");
	}
	
	@DataProvider(name = "passwordExceedLength")
	public Object[][] passwordExceedLength()throws Exception
	{return getData("passwordExceedLength");
	}
	
	
	@DataProvider(name = "passwordLessThanMinLength")
	public Object[][] passwordLessThanMinLength()throws Exception
	{return getData("passwordLessThanMinLength");
	}
	 
	
	@DataProvider(name = "passwordConfirmMissmatch")
	public Object[][] passwordConfirmMissmatch()throws Exception
	{return getData("passwordConfirmMissmatch");
	}

	
	public Object[][]  getData(String testCaseName) throws Exception{

		ExcelUtils.setExcelFile("src//resources//register_data.xlsx","Sheet1");

	 	iTestCaseRow = ExcelUtils.getRowContains(testCaseName,0);
	    

	    Object[][] testObjArray = ExcelUtils.getTableArray("src//resources//register_data.xlsx","Sheet1",iTestCaseRow,6);
		  

	    return (testObjArray);
	}
}
