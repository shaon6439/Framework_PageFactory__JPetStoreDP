package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
	WebDriver driver;
	String filepath = "C:\\selenium_Demo\\Framework_PageFactory_Registration_DP\\config.properties";

	public WebDriver browser_initiate() throws IOException {
		FileInputStream fis = new FileInputStream (filepath);
		Properties p = new Properties();
		p.load(fis);
		String browsername = p.getProperty("browser");
		switch(browsername){
		case "chrome":
			driver = new ChromeDriver();
			driver.get(p.getProperty("url"));
			break;
		case "edge":
			driver = new EdgeDriver();
			driver.get(p.getProperty("url"));
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.get(p.getProperty("url"));
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		}
}
