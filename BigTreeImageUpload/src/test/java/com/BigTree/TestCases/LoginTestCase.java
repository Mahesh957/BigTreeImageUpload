package com.BigTree.TestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BigTree.qa.base.TestBase;
import com.BigTree.qa.pages.BigTreeLoginPage;

public class LoginTestCase extends TestBase {
	BigTreeLoginPage LoginPage;

	public LoginTestCase() {
	}

	@BeforeTest
	public void setup() {
		initilization();
		LoginPage = new BigTreeLoginPage();
	}

	@Test
	public void Login() {
		LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void UploadImage() throws AWTException, InterruptedException, IOException {
		LoginPage.ClickFileIcon();
		LoginPage.ClickAddImages();
		LoginPage.ClickOnDragAndDrop();
		LoginPage.upload("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
