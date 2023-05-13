package TestSel.saucedemo;

import java.time.Duration;
import java.util.List;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.Abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents
{
	WebDriver driver;

	public CartPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		@FindBy(css=".cartSection h3")
		List<WebElement> cartProducts;
		
		@FindBy(css=".totalRow button")
		WebElement checkout;
		
		@FindBy(css=".totalRow button")
		WebElement second;
		
		@FindBy(css=".actions a")
		WebElement placeOrder;
		
		@FindBy(css="[routerlink*='cart']")
		WebElement cart;
		
		@FindBy(css=".hero-primary")
		WebElement SuccessText;
		
		By waitforC = By.cssSelector(".ta-results");
		By waitcart = By.cssSelector("[routerlink*='cart']");


public Boolean VerifyproductsinKart(String productName)
{
	Boolean match =cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().
			  equalsIgnoreCase(productName));
	  return match;
}

public Checkout Checkout()
{
	checkout.click();
	//waitUntill(waitforC);
	//second.click();
	Checkout ck = new Checkout(driver);
	return ck;

	}

public void placeOrder()
{
	placeOrder.click();
	
}

public void verifysuccessmsg()
{
	
	String t = SuccessText.getText();
	System.out.println(t);
	}

public void Cart()
{
	waitUntill(waitcart);
	cart.click();
	Checkout co = new Checkout(driver);
}



}



