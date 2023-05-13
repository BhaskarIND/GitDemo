package TestSel.saucedemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.Abstractcomponents.AbstractComponents;

public class Checkout extends AbstractComponents
{
	WebDriver driver;

	public Checkout(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css="[placeholder*='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectindia;
	
	@FindBy(css=".actions a")
	WebElement placeOrder;
	
	By waitt = By.cssSelector(".ta-results");
	
	/*
	 * public void Checkout() { checkout.click();
	 * 
	 * 
	 * 
	 * }
	 */


public void selectCountry(String countryName)

{
	
	Actions action = new Actions(driver);
	action.sendKeys(country, countryName).build().perform();
	waitUntill(waitt);
	
	selectindia.click();
	}

public ConfirmationPage placeOrder()
{
	placeOrder.click();
	
	ConfirmationPage cnfm = new ConfirmationPage(driver);
	return cnfm;
	
}

}
