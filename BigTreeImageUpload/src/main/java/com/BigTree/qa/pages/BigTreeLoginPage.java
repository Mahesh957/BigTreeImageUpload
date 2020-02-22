package com.BigTree.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BigTree.qa.base.TestBase;
import com.BigTree.utilites.commonUtilites;

import junit.framework.Assert;

public class BigTreeLoginPage extends TestBase {
	@FindBy(id = "user")
	private WebElement UserName;

	@FindBy(id = "password")
	private WebElement Password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement LoginButton;

	@FindBy(xpath = "//span[@class='files']")
	WebElement FilesIcon;

	@FindBy(xpath = "//span[@class='icon_small icon_small_picture']")
	WebElement AddImages;

	@FindBy(xpath = "//form[@id='file_manager_dropzone']")
	WebElement DragAndDrop;

	public void ClickFileIcon() {
		System.out.println("Clickfileicon");
		commonUtilites.highLighterMethod(driver, FilesIcon);
		FilesIcon.click();
	}

	public void ClickAddImages() {
		commonUtilites.highLighterMethod(driver, AddImages);
		AddImages.click();
	}

	public void ClickOnDragAndDrop() {
		commonUtilites.highLighterMethod(driver, DragAndDrop);
		DragAndDrop.click();
	}

	public BigTreeLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String username, String password) {
		commonUtilites.highLighterMethod(driver, UserName);
		UserName.sendKeys(username);
		commonUtilites.highLighterMethod(driver, Password);
		Password.sendKeys(password);
		commonUtilites.highLighterMethod(driver, LoginButton);
		LoginButton.click();
	}

	public void upload(String path) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void verifyUploadedImg(String image1) {

		driver.findElement(By.xpath("//div[@class='dz-image']//child::img"));
	}

}
