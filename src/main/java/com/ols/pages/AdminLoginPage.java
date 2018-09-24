package com.ols.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ols.base.BrowserFactory;
import com.ols.help.TestUtil;

public class AdminLoginPage extends BrowserFactory {
	//Page Factory - OR:
		@FindBy(xpath="//input[@class='AnswerDateTime' and @type='text']")
		WebElement username1;

		@FindBy(xpath="//input[@class='AnswerDateTime' and @type='password']")
		WebElement password1;

		@FindBy(id="btnSubmit")
		WebElement loginBtn;


		//Initializing the Page Objects:
		public AdminLoginPage(){
			PageFactory.initElements(driver, this);

		}

		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		

		public HomePage login(String un, String pwd) throws InterruptedException{
			driver.switchTo().frame("mainFrame");
			TestUtil.explicitWaitTest(driver, 50, username1);
			TestUtil.explicitWaitTest(driver, 50, password1);
			username1.sendKeys(un);
			Thread.sleep(1000); 
			password1.sendKeys(pwd);
			Thread.sleep(1000); 
			TestUtil.explicitWaitTest(driver, 50, loginBtn);
			loginBtn.click();
			return new HomePage();
		}
}
