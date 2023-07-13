package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='title']")
	WebElement Title;
	@FindBy(xpath = "//*[@id='page']")
	WebElement page_Name;
	@FindBy(xpath = "//*[@id='form']/div/div[5]/button")
	WebElement update;
	@FindBy(xpath = "//*[@id='form']/div/div[5]/a")
	WebElement cancel;

	public EditPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void editPage(String newpageName) {
		enterPageName(newpageName);
		clickUpdate();
	}

	public void enterPageName(String newpageName) {
		page_Name.clear();
		page_Name.sendKeys(newpageName);
	}

	public void clickUpdate() {
		update.click();
	}

	public void clickCancel() {
		cancel.click();
	}
}
