package com.ols.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ols.base.BrowserFactory;
import com.ols.pages.IndividualMemberPage;
import com.ols.pages.RegisterPage;
import com.ols.testbase.TestBase;

public class RegisterPageTest extends TestBase {
	RegisterPage registerpage;
	IndividualMemberPage notmemberorg;
	
	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		

		BrowserFactory.initialization(prop.getProperty("browser"), prop.getProperty("URL"));	
		BrowserFactory.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/p[1]/a")).click();		
		registerpage = new RegisterPage();
				
	}
	@Test(priority=0)
	public void memberOfThisOrg() throws Exception{
		boolean flag = registerpage.validateRegPageTitle();
		if(flag==true)
		{
			

			String userRegistration = registerpage.verifyUserRegPage();
			if(userRegistration.equalsIgnoreCase("User Registration"))
			{
				registerMemberOfThisOrg();
		
			}
		}
		else
		{
			System.out.println("Register page text not matched");
		}
	}
	public void registerMemberOfThisOrg() throws Exception{
		String orgRegistration = registerpage.verifyRegOrgPage();
		String ActualorgReg = "I am not a member of this organisation";
		if(orgRegistration.equalsIgnoreCase(ActualorgReg))
		{
			BrowserFactory.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/p[3]/a")).click();
		}
	
}
	@Test(priority=1)
	public void individualmember() throws Exception{
		boolean flag = registerpage.validateRegPageTitle();
		if(flag==true)
		{
			

			String userRegistration = registerpage.verifyUserRegPage();
			if(userRegistration.equalsIgnoreCase("User Registration"))
			{
				registerIndMember();
		
			}
		}
		else
		{
			System.out.println("Register page text not matched");
		}
	}
	public void registerIndMember() throws Exception{
		String orgRegistration1 = registerpage.verifyRegIndMemberText();
		String ActualorgReg1 = "I am an individual member";
		if(orgRegistration1.equalsIgnoreCase(ActualorgReg1))
		{
			BrowserFactory.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/p[4]/a")).click();
			System.out.println(orgRegistration1);
		}
		else
		{
			System.out.println("Register page text not matched");
		}
	
}
	@Test(priority=2)
	public void corporateMember() throws Exception{
		boolean flag = registerpage.validateRegPageTitle();
		if(flag==true)
		{
			

			String userRegistration = registerpage.verifyUserRegPage();
			if(userRegistration.equalsIgnoreCase("User Registration"))
			{
				registerCorpMember();
		
			}
		}
		else
		{
			System.out.println("Register page text not matched");
		}
	}
	public void registerCorpMember() throws Exception{
		String orgRegistration1 = registerpage.verifyRegCorpMemberText();
		String ActualorgReg1 = "I am a corporate member";
		if(orgRegistration1.equalsIgnoreCase(ActualorgReg1))
		{
			BrowserFactory.driver.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/p[5]/a")).click();
			System.out.println(orgRegistration1);
		}
		else
		{
			System.out.println("Register page text not matched");
		}
	
}
}
