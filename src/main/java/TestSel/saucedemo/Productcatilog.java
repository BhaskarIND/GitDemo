package TestSel.saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Abstractcomponents.AbstractComponents;

public class Productcatilog extends AbstractComponents {
	
	WebDriver driver;

	public Productcatilog(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
		@FindBy(css=".col-sm-10")
		List<WebElement> product;
		
		@FindBy(css="[routerlink*='cart']")
		WebElement clikonKart;
		
		By productBy=By.cssSelector(".mb-3");
		By addtoCart = By.cssSelector(".card-body button:last-of-type");
		By toastWait = By.cssSelector("#toast-container");
		By dissapp  = By.cssSelector(".ng-animating");
		//By clikonKart=By.cssSelector("[routerlink*='cart']");
		
		public List<WebElement> getProductList()
		{
			waitUntill(productBy);
			return product;
		}
		
		
		public WebElement getProductByname(String productName)
		{
			WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return prod;
	       // prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		}
		
		public  String addProductToCart(String productName)
		{
			WebElement prod = getProductByname(productName);
			 prod.findElement(addtoCart).click();
			waitUntill(toastWait);
			 waitUntilUnvisible(dissapp);
			return productName;
			 
		}

		public void clickOnKart()
		{
			clikonKart.click();
		}

		


		
		
		

	

}
