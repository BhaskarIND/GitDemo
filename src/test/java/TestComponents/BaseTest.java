package TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import TestSel.saucedemo.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	WebDriver driver;
	public static  LandingPage lp;
	public WebDriver instalizeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\GobalData.properties");
		
		prop.load(fis);
		
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"));
		{
	WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
}
	@BeforeMethod
	public LandingPage launchApp() throws IOException
	{
		driver = instalizeDriver();
       lp = new LandingPage(driver);
		
		lp.goTO();
		
		return lp;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
