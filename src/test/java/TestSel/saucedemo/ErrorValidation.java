package TestSel.saucedemo;

import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test
	public void errormsg()
	{
		lp.loginApplication("BB@gmail.com", "Bha45skar@2");

	}

}
