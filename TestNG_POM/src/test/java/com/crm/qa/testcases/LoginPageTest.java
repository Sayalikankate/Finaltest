package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		// TestBase class constructor should be called
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initization();
		loginPage= new LoginPage();
	}
	
	@Test
	public void loginPageTitleTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		
			homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}

}
