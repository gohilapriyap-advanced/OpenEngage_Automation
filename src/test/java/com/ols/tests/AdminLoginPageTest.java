package com.ols.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ols.base.BrowserFactory;
import com.ols.pages.AdminLoginPage;
import com.ols.pages.HomePage;
import com.ols.testbase.TestBase;

public class AdminLoginPageTest extends TestBase{
	AdminLoginPage adminLoginPage;
	HomePage homePage;
	
	public AdminLoginPageTest(){
		super();
	}
  @BeforeMethod
  public void beforeMethod() {
	  BrowserFactory.initialization(prop1.getProperty("browser1"), prop1.getProperty("URL1"));
	  adminLoginPage = new AdminLoginPage();	
	  
  }
  
//  @Test(priority=1)
//	public void loginPageTitleTest(){
//		String title = adminLoginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "On Line Services - Administrator");
//	}
//	
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		
	adminLoginPage.login(prop1.getProperty("username1"), prop1.getProperty("password1"));
	System.out.println("Admin page login Successfull");

	}
  
//  @AfterMethod
//  public void afterMethod() {
//	  BrowserFactory.driver.quit();
//}
}
