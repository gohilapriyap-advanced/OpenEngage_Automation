package com.ols.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ols.base.BrowserFactory;
import com.ols.help.TestUtil;;

public class LoginPage extends BrowserFactory{

	//Page Factory - OR:
	@FindBy(id="reg")
	WebElement username;

	@FindBy(id="pass")
	WebElement password;

	@FindBy(id="submit1")
	WebElement loginBtn;

	@FindBy(xpath="/html/body/p[1]")
	WebElement logintext;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validatePageText(){
		return logintext.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException{
		username.sendKeys(un);
		Thread.sleep(1000);
		password.sendKeys(pwd);
		Thread.sleep(1000);
        loginBtn.click();
		return new HomePage();
	}
}
