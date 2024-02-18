package webDriver_Framework.Selenium_Framework;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import objectRepository.HomePage;
import objectRepository.Sign_In;
import objectRepository.Register_Info;

import utilities.CrossBrowser;
import utilities.ExcelData;
public class AppTest {
	WebDriver driver;
	String data [] = new String [5];
	ExtentReports report = new ExtentReports();
	ExtentSparkReporter sparkreport = new ExtentSparkReporter("C:\\selenium_Demo\\Framework_PageFactory_Registration_DP\\target\\report.html");
	ExtentTest test = report.createTest("Registration Application");
	
	@BeforeTest
	public void openBrowser() throws IOException {
		CrossBrowser br = new CrossBrowser();
		driver = br.browser_initiate();	
	}
	
	@Test(dataProvider="dp")
	public void valid_application(String fName, String lName, String e,
			
			String ph, String ad1, String ad2, String c, String st, String z, String cntry) throws IOException {
		report.attachReporter(sparkreport);
		
		HomePage h = new HomePage(driver);
		h.signin();
		test.log(Status.PASS, "Welcome to home page");
		report.flush();
		
		Sign_In s = new Sign_In(driver);
		s.registerLink();;
		test.log(Status.PASS, "SignIn page");	
		report.flush();
				
		ExcelData d = new ExcelData();
        data = d.readExcel();
        String userId = data[0];
        String n_pwd= data[1];
        String r_pwd = data[2];
        
        Register_Info ui = new Register_Info(driver);
        ui.user_Info(userId, n_pwd, r_pwd);
        Register_Info r = new Register_Info(driver);
		r.acct_Info(fName, lName, e, ph, ad1, ad2, c, st, z, cntry);
		
   		ui.profile();
   		
		ui.saveInfo();
		ui.verifyMsg();

	}
	
	@DataProvider(name="dp")
	public Object[][] acctt_Info(){
	 {
		Object[][] data= {{"John", "Adam", "Abc@gmail.com", "888-888-8888", "123 ave", "#1", "New york", "NY", "11373", "USA"}};
		return data;
		}
	}
	
	@AfterTest
	public void failReport() throws IOException {
		TakesScreenshot shot =(TakesScreenshot) driver;
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Selenium_ScreenShots\\shot.jpeg");
		FileUtils.copyFile(src,dest);
		test.log(Status.FAIL, "Registration Page");
		report.flush();
	}
	
}