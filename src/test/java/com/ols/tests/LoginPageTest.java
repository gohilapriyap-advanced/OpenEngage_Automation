package com.ols.tests;

import org.testng.annotations.Test;

import com.ols.base.BrowserFactory;
import com.ols.pages.HomePage;
import com.ols.pages.LoginPage;
import com.ols.testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
  @BeforeMethod
  public void beforeMethod() {
	  BrowserFactory.initialization(prop.getProperty("browser"), prop.getProperty("URL"));
		loginPage = new LoginPage();	
		
  }
  
//  @Test(priority=0)
//	public void loginPageTitleTest(){
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals(title, "On-Line Services");
//	}
//	
//	@Test(priority=1)
//	public void validatePageText(){
//		boolean flag = loginPage.validatePageText();
//		Assert.assertTrue(flag);
//	}
//	
	@Test(priority=2)
	public void loginTest() throws InterruptedException{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
  
  @AfterMethod
  public void afterMethod() {
	  BrowserFactory.driver.quit();
}
}
