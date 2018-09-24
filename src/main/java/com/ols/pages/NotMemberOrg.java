package com.ols.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ols.base.BrowserFactory;

public class NotMemberOrg extends BrowserFactory
{
	@FindBy(xpath="//*[@id='Title']")
	WebElement username;
	public NotMemberOrg(){
		PageFactory.initElements(driver, this);
	}
	public HomePage register(){
		username.sendKeys("Mr.");
		/*password.sendKeys(pwd);
		loginBtn.click();*/
		return new HomePage();
	}
}
