package com.BigTree.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
protected static WebDriver driver;
protected static Properties prop;

	public TestBase() {
		try {
			FileReader reader = new FileReader("resource\\config.properties");
			prop = new Properties();
			//FileInputStream ip = new FileInputStream(System.getProperty("config.properties"));
			prop.load(reader);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}


public void initilization()
{
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium_Setup\\New\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	else
	{
		System.out.println("Please use chrome browser only");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
}

}