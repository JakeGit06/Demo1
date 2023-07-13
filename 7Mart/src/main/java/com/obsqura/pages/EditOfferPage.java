package com.obsqura.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.utilities.*;

public class EditOfferPage extends WaitUtility {
	@FindBy(xpath = "//*[@id='form']/div/div[6]/div/p/img")
	WebElement image;
	@FindBy(xpath = "//*[@id='form']/div/div[6]/div/p/a")
	WebElement deleteimage;
	@FindBy(xpath = "//*[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement update;
	WebDriver driver;

	public EditOfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void imageEdit(String imgPath) {
		if (deleteimage.isDisplayed()) {
			deleteImage();
		}
		chooseNewImage(imgPath);
		clickUpdate();
		
	}

	public void deleteImage() {

		deleteimage.sendKeys(Keys.ENTER);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void chooseNewImage(String imgPath) {
		chooseFile.sendKeys(imgPath);
	}

	public void clickUpdate() {
		update.sendKeys(Keys.ENTER);
	}

}
