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

public class ContactsPageTest extends TestBase {
	ContactsPage contactspage;
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	String sheetName = "contacts";

	ContactsPageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage = homepage.clickOncontactsLink();

	}

	/*
	 * @Test(priority = 1 ) public void verifyContactsPageLable() {
	 * Assert.assertTrue(contactspage.verifyContactsLable(),
	 * "Contact lable is missing on the page"); }
	 */

	/*
	 * @Test(priority = 2) public void selectContactsTest() { try {
	 * Thread.sleep(2000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * contactspage.selectContactsByName("Sudeeksha ganib");
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 3) public void selectMultipleContactsTest() { 
	 * contactspage.selectContactsByName("Akshara ganib");
	 * contactspage.selectContactsByName("Nag G"); }
	 */
	@DataProvider
	public Object[][] getCRMTestdata() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestdata")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
		try {
			Thread.sleep(2000);
			homepage.clickOnNewContactLink();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		contactspage.createNewContact(title, firstname, lastname, company);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}