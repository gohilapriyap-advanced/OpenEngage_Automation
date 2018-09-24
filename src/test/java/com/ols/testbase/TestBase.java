package com.ols.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.mail.EmailException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ols.excelutility.DeleteExcelFile;
import com.ols.excelutility.ExcelWriteUtility;
import com.ols.help.TestUtil;

public class TestBase {
	public static Properties prop;
	public static Properties prop1;

	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./Properties/ols.properties");
			prop.load(ip);
			prop1 = new Properties();
			FileInputStream ip1 = new FileInputStream("./Properties/ols.adminproperties");
			prop1.load(ip1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public static void initiateSute() throws Exception
	{
		ExcelWriteUtility.writeDataToExcel();
		Thread.sleep(3000);
	}
	@AfterSuite
	public static void sendReportEmail() throws Exception
		{
		//TestUtil.sendEmail();
		Thread.sleep(2000);
		//DeleteExcelFile.deleteExcel();
		Thread.sleep(2000);
		}
	}
	