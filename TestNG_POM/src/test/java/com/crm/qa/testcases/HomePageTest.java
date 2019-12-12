package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactsPage;

	public HomePageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initization();
		loginpage = new LoginPage();
		contactsPage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyhomepageTitleTest() {
		String title = homepage.verifyhomepageTitleTest();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title, "Home Page title not matched");

	}

	@Test(priority = 2)
	public void verifyUnameLabel() {
		Assert.assertTrue(homepage.verifyUsernameLabel());
	}
	
	@Test(priority=3)
	public void verifycontactsLinkTest() {
		contactsPage= homepage.clickContacts();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
