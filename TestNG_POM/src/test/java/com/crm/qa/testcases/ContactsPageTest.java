package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	ContactsPage contactspage;
	HomePage homepage;
	String sheetName="Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initization();
		loginPage= new LoginPage();
		contactspage= new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
		homepage.clickContacts();
	}
	
	@Test(priority = 1)
	public void verifycontactsLabel() {
		Assert.assertTrue(contactspage.verifycontactslabel(), "Contacts label missing on Page");
	}
	
	@Test(priority = 2, dataProvider = "getCRMdata")
	public void validateCreateContact(String firstname, String lastname, String category) throws InterruptedException {
		contactspage.clickOnnewContact();
		contactspage.createNewContact(firstname, lastname, category);
	}
	
	@DataProvider
	public Object[][] getCRMdata() {
		 Object data[][]= TestUtil.getTestData(sheetName);
		 return data;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
