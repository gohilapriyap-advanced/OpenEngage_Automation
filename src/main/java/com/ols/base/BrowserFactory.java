package com.ols.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ols.help.TestUtil;

public class BrowserFactory {
	public static String Chromepath=("./Drivers/chromedriver.exe");
	public static WebDriver driver;
	public static Properties prop;
	public static Properties prop1;
	//public static String browserName = prop.getProperty("browser");
	public BrowserFactory()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./Properties/ols.properties");
			prop.load(ip);
			prop1 = new Properties();
			FileInputStream ip1 = new FileInputStream("./Properties/ols.properties");
			prop1.load(ip1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(String browserName, String URL){
			
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", Chromepath);	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equalsIgnoreCase("chrome1")){
			System.setProperty("webdriver.chrome.driver", Chromepath);	
			driver = new ChromeDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(URL);
}
}
