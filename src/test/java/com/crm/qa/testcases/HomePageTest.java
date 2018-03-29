package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactspage=new  ContactsPage();
		
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepagetitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO", "Homepage title not matched");
	}

	@Test(priority = 2)
	public void verifyUsernameTest() {
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUsername());
	}

	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testutil.switchToFrame();
		contactspage=homepage.clickOncontactsLink();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}