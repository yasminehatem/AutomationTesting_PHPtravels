package data_generation;
import org.testng.annotations.DataProvider;
import data_generation.ExcelUtils;
public class DataProviderLogin {

	public  String sTestCaseName;
	public  int iTestCaseRow;
	
	
	@DataProvider(name = "validLogin")
	 public  Object[][] credentials() throws Exception {

    	return getData("validLogin");

}
	
	@DataProvider(name = "rememberMe")
	 public  Object[][] rememberMe() throws Exception {

    	return getData("rememberMe");

}

	@DataProvider(name = "invalidPasswordLogin")
	  public  Object[][] invalidPasswordLogin() throws Exception {
	   
		    	return getData("invalidPasswordLogin");
	  }
	 
	@DataProvider(name = "invalidEmailLogin")
	  public  Object[][] invalidEmailLogin() throws Exception {
	   
		    	return getData("invalidEmailLogin");
	  }
	
	@DataProvider(name = "emptyEmail")
	  public  Object[][] emptyEmail() throws Exception {
	   
		    	return getData("emptyEmail");
	  }
	public Object[][]  getData(String testCaseName) throws Exception
	{
		ExcelUtils.setExcelFile("src//resources//login_data.xlsx","Sheet1");
	 	iTestCaseRow = ExcelUtils.getRowContains(testCaseName,0);
	    Object[][] testObjArray = ExcelUtils.getTableArray("src//resources//login_data.xlsx","Sheet1",iTestCaseRow,2);
	
	    return (testObjArray);
	}
}
