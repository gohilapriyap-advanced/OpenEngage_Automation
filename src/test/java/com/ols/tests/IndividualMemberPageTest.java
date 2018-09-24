package com.ols.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ols.base.BrowserFactory;
import com.ols.help.TestUtil;
import com.ols.pages.IndividualMemberPage;
import com.ols.pages.RegisterPage;
import com.ols.testbase.TestBase;

public class IndividualMemberPageTest extends TestBase {
	RegisterPage registerpage;
	IndividualMemberPage individualMemberPage;
	String sheetName= "Persons";

	public IndividualMemberPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		

		BrowserFactory.initialization(prop.getProperty("browser"), prop.getProperty("URL"));	
		BrowserFactory.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/p[1]/a")).click();	
		BrowserFactory.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/p[3]/a")).click();	
		registerpage = new RegisterPage();
		individualMemberPage= new IndividualMemberPage();
	
	}

	@DataProvider
	public Object[][] getPersonTestData(){
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1, dataProvider="getPersonTestData")
	public void createPersonData(String ExcelForename, String ExcelSurname, String ExcelEmail, String ExcelConfirmEmail) throws Exception
	{
		individualMemberPage.createNewPerson(ExcelForename, ExcelSurname, ExcelEmail, ExcelConfirmEmail);
		individualMemberPage.clickOnCreateNewPersonLink();	}
}
