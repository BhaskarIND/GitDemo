package TestSel.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Abstractcomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents
{
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement cnfm;
	
	public String verifyConfirmationMsg()
	{
		return cnfm.getText();
		 //System.out.println(t);
	}
}

//String t = driver.findElement(By.cssSelector(".hero-primary")).getText();
// System.out.println(t);