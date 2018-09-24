package com.ols.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ols.base.BrowserFactory;
import com.ols.help.TestUtil;
import com.ols.pages.HomePage;
import com.ols.pages.LoginPage;
import com.ols.testbase.TestBase;


public class HomePageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	//@FindBy(xpath = "//*[@id='button2']")
	//WebElement skipButton;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		BrowserFactory.initialization(prop.getProperty("browser"), prop.getProperty("URL"));
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=0)
	public void headerTitleTest() throws Exception{
		String headerPageTitle = homePage.verifyHeaderTitle();
		if(headerPageTitle.equalsIgnoreCase("Please update Your profile."))
		{
			JavascriptExecutor js = ((JavascriptExecutor) BrowserFactory.driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		skipAction();
		}
		else
		{
			System.out.println("Home Page title is not matching");
		}
	}
	public void skipAction() throws InterruptedException {
		System.out.println("Ols login Successfull");
		Thread.sleep(1000);
		BrowserFactory.driver.findElement(By.id("button2")).click();	
		verifyPageTextTest();
	}
	public void verifyPageTextTest() {
		
		String title = homePage.verifyPageText();
		Assert.assertEquals(title, "Details");	
	}

}
