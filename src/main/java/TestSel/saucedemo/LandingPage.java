package TestSel.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		@FindBy(id="userEmail")
		WebElement userName;
		
		@FindBy(id="userPassword")
		WebElement password;
		
		@FindBy(id="login")
		WebElement submit;
		
		public Productcatilog loginApplication(String email ,String passwor)
		{
			userName.sendKeys(email);
			password.sendKeys(passwor);
			submit.click();
			
			Productcatilog pc = new Productcatilog(driver);
			return pc;
			
		}
		
		public void goTO()
		{
			driver.get("https://rahulshettyacademy.com/client/");
			driver.manage().window().maximize();
		}
		
		
		

	

}
