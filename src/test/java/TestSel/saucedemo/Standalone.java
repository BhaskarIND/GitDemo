package TestSel.saucedemo;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone extends BaseTest{

	@Test
	public void submitOrders() throws IOException, InterruptedException
	{
		
		
		String productName="ZARA COAT 3";
		//LandingPage lp =launchApp();
		Productcatilog pc  = lp.loginApplication("BB@gmail.com", "Bhaskar@2");
	
		List<WebElement> products = pc.getProductList();
		pc.addProductToCart(productName);
		
		
		 
		CartPage cart = pc.goToCart();
		Boolean match = cart.VerifyproductsinKart(productName);
		Assert.assertTrue(match);
		
		
		Checkout co = cart.Checkout();
		
		co.selectCountry("india");
		co.placeOrder();
        		
       ConfirmationPage cnfm = co.placeOrder();
       String text = cnfm.verifyConfirmationMsg();
       Assert.assertTrue(text.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        		
				
		
        		
        
	}
	
	@Test(dependsOnMethods= {"submitOrders"})
	public void orderHistory()
	{
		
	}

}
