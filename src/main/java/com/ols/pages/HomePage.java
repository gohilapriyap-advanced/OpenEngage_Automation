package com.ols.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ols.base.BrowserFactory;

public class HomePage {
	@FindBy(xpath = "/html/body/table/tbody/tr/td[2]/p")
	WebElement headerTitleTest;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[2]/p[2]")
	WebElement homePageLabel;	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/p[1]")
	WebElement adminHomePageLabel;	
	public HomePage()
	{
		PageFactory.initElements(BrowserFactory.driver, this);
	}
	public String verifyHeaderTitle() {
		
		return headerTitleTest.getText();

	}
	
	public String verifyPageText() {
		return homePageLabel.getText();
	}
	
	public String verifyAdminPageText() {
		return adminHomePageLabel.getText();
	}

}

