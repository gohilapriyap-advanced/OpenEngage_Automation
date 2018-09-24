package com.ols.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ols.base.BrowserFactory;
import com.ols.tests.IndividualMemberPageTest;

public class IndividualMemberPage extends BrowserFactory {
@FindBy(xpath ="//*[@id='form1']/table/tbody/tr[1]/td/table/tbody/tr[2]/td[3]/select")
WebElement titleTest;
@FindBy(xpath = "//*[@id='Forename']")
public WebElement forenameTest;
@FindBy(xpath = "//*[@id='Surname']")
public WebElement surnameTest;
@FindBy(xpath = "//*[@id='Email']")
public WebElement emailTest;
@FindBy(xpath = "//*[@id='ConfirmEmail']")
public WebElement confirmEmailTest;
@FindBy (xpath = "//*[@id='Gender']")
WebElement gender;
@FindBy (xpath = "//*[@id='JobTitle']")
WebElement jobTitle;
@FindBy (xpath = "//*[@id='PafButton']")
WebElement address;
@FindBy (xpath = "//*[@id='submit1']") 
WebElement next;
//@FindBy (name = "txtSearch")
//WebElement search;  
//@FindBy (xpath = "//*[@id='Add1']")
//WebElement address1;
//@FindBy (xpath = "//*[@id='Add1']")
//WebElement address2;
//@FindBy (xpath = "/html/body/form/table/tbody/tr[7]/td[3]/input")
//WebElement country; 
//@FindBy (xpath = "//*[@id='submit1']")
//WebElement addSubmit;
@FindBy(xpath = "//*[@id='submit1']") 
public WebElement register;
@FindBy(xpath = "//*[@id='coForm']/table/tbody/tr[1]/td[1]/a/img")
WebElement addressSelect;
@FindBy(xpath = "//*[@id='pass']")
WebElement password;
@FindBy(xpath = "//*[@id='confirm']")
WebElement confPassword;
 
	public IndividualMemberPage() {
		PageFactory.initElements(driver, this);	
	}


	public IndividualMemberPage clickOnCreateNewPersonLink() {
		register.click();
		register.click();
		addressSelect.click();
		jobTitle.sendKeys("CEO");
		register.click();
		password.sendKeys("Mike123");
		confPassword.sendKeys("Mike123");
		return new IndividualMemberPage();
	}	
	
	public IndividualMemberPageTest createNewPerson(String Forename, String Surname, String Email, String ConfirmEmail) throws Exception {

        Select oSelect = new Select(titleTest);
        oSelect.selectByVisibleText("Ms");
		//titleTest.sendKeys(Title);
		forenameTest.sendKeys(Forename);
		surnameTest.sendKeys(Surname);
		emailTest.sendKeys(Email);
		confirmEmailTest.sendKeys(ConfirmEmail);
		gender.click();
		address.click();
		Thread.sleep(20000); 
	    //next.click();	
		//search.sendKeys("new");
	//	address1.sendKeys("210 Eureka Park");
		//address2.sendKeys("Upper Pemberton");
		//country.sendKeys("UK");
		//next.click();
		//driver.navigate().back();
		return new IndividualMemberPageTest();
	}
	
}
