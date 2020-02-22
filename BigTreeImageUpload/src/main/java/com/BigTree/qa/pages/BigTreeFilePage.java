package com.BigTree.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BigTree.qa.base.TestBase;
import com.BigTree.utilites.commonUtilites;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BigTreeFilePage extends TestBase{
	
	private WebDriverWait wait;
	//private WebDriver driver;
	@FindBy(xpath="//span[@class='files']")
	WebElement FilesIcon;
	
	@FindBy(xpath="//span[@class='icon_small icon_small_picture']")
	WebElement AddImages;
	
	@FindBy(xpath="//form[@id='file_manager_dropzone']")
	WebElement DragAndDrop;
	
	public BigTreeFilePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickFileIcon()
	{
		System.out.println("Clickfileicon");
		//wait.until(ExpectedConditions.visibilityOf(FilesIcon));
		commonUtilites.highLighterMethod(driver, FilesIcon);
		FilesIcon.click();
	}
	
	public void ClickAddImages()
	{
		//wait.until(ExpectedConditions.visibilityOf(AddImages));
		commonUtilites.highLighterMethod(driver, AddImages);
		AddImages.click();
	}
	public void ClickOnDragAndDrop()
	{
		//wait.until(ExpectedConditions.visibilityOf(DragAndDrop));
		commonUtilites.highLighterMethod(driver, DragAndDrop);
		DragAndDrop.click();
	}

}
