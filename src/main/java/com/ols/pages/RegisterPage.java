package com.ols.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ols.base.BrowserFactory;

public class RegisterPage extends BrowserFactory{
	@FindBy(xpath = "/html/body/p[1]")
	WebElement regPageText;
	
	@FindBy(xpath = "//p[text()='User Registration']")
	WebElement regUserPageText;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[2]/p[3]/a")
	WebElement regOrgPageText;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[2]/p[4]/a")
	WebElement regIndMemberText;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[2]/p[5]/a")
	WebElement regCorpMemberText;
	public RegisterPage()
	{
		PageFactory.initElements(BrowserFactory.driver, this);

	}
	public boolean validateRegPageTitle(){
		return regPageText.isDisplayed();
	}
	public String verifyUserRegPage()
	{
		System.out.println(regUserPageText.getText());
		return regUserPageText.getText();
		
	}
	public String verifyRegOrgPage()
	{
		return regOrgPageText.getText();
	
	}
	public String verifyRegIndMemberText()
	{
		
		return regIndMemberText.getText();
	}
	public String verifyRegCorpMemberText()
	{
		
		return regCorpMemberText.getText();
	}
	
}