package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Register_Info {
	WebDriver driver;
	
	
		@FindBy(name="username")
		WebElement userId;
    
		@FindBy(name="password")
		WebElement newPassword;
    
		@FindBy(name="repeatedPassword")
		WebElement repeatPassord;
	
		@FindBy(name="account.firstName")
		WebElement firstName;
		
		@FindBy(name="account.lastName")
		WebElement lastName;
		
		@FindBy(name="account.email")
		WebElement email;
		
		@FindBy(name="account.phone")
		WebElement phone;
		
		@FindBy(name="account.address1")
		WebElement add1;
		
		@FindBy(name="account.address2")
		WebElement add2;
		
		@FindBy(name="account.city")
		WebElement city;
		
		@FindBy(name="account.state")
		WebElement state;
		
		@FindBy(name="account.zip")
		WebElement zip;
		
		@FindBy(name="account.country")
		WebElement country;
		@FindBy(name="account.languagePreference")
		WebElement langPref;
		
		@FindBy(name="account.favouriteCategoryId")
		WebElement favCat;
	
		@FindBy(name="account.listOption")
		WebElement eList;
		
		@FindBy(xpath="//input[@name=\"account.bannerOption\"]")
		WebElement eBanner;
		
		@FindBy(name="newAccount")
		WebElement sInfo;
		
		@FindBy(xpath="/html/body/h1") 
		WebElement errMsg;
		

		public Register_Info (WebDriver driver){
			this.driver=driver; 
			PageFactory.initElements(driver, this); 
		}
		
		public void user_Info(String u1, String p1, String p2) {
            userId.sendKeys(u1);
            newPassword.sendKeys(p1);
            repeatPassord.sendKeys(p2);
		}
		
		public void acct_Info(String fName, String lName, String e, String ph, String ad1, String ad2, String c, String st, String z, String cntry) {
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			email.sendKeys(e);
			phone.sendKeys(ph);
			add1.sendKeys(ad1);
			add2.sendKeys(ad2);
			city.sendKeys(c);
			state.sendKeys(st);
			zip.sendKeys(z);
			country.sendKeys(cntry);
		}
		
		public void profile() {
				Select s = new Select(langPref);
				s.selectByIndex(1);
							
				Select s2 = new Select(favCat);
				s2.selectByVisibleText("CATS");
				
				eList.click();
				eBanner.click();
			}
			
		public void saveInfo() {
				sInfo.click();
			}
		
		public void verifyMsg() {
			String actMsg = errMsg.getText();
			System.out.println("Actual Message: "+ actMsg);
			String expMsg = "Successfully registered";
			Assert.assertEquals(actMsg, expMsg);
			
		}	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		

	


		
		

