package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.OutputType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.TakesScreenshot;
public class SetupTest {
	public static ExtentReports report;

	public static ExtentTest test;
	
    public static WebDriver driver;
	
    public void SetupTest()
    {
    	launchDriver(); 
    }
	
	public void launchDriver()  {
        //FirefoxOptions options = new FirefoxOptions();
     
		System.setProperty("webdriver.gecko.driver","src\\resources\\geckodriver.exe");
		
		this.driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}


@BeforeMethod
    
    public void preCondition() {
    	if (driver == null) {
    		launchDriver();
    	}
       driver.manage().window().maximize();
   
    }

    @AfterMethod
    public void postCondition() {
    	 if (driver == null) {
    	        return;
    	    }
    	 
    	 driver.quit();
    	 driver = null;
    }
	@AfterSuite
	public static void TearDown() {
		try {
			report.flush();
		} catch (Exception e) {
			test.log(LogStatus.ERROR, e);
		}
	}
    public static void sleep()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	public static void takeScreenshot(String fileName, ExtentTest extenttest,String foldername) {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(System.getProperty("user.dir") + "\\src\\OutputResults\\"+ foldername+ fileName + ".png");
			FileUtils.copyFile(SrcFile, DestFile);
			extenttest.log(LogStatus.INFO, "Output Snapshot" + extenttest
					.addScreenCapture(System.getProperty("user.dir") + "\\src\\OutputResults\\"+foldername + fileName + ".png"));
		} catch (Exception e) {
			test.log(LogStatus.ERROR, e);;
		}
	}
    

}
