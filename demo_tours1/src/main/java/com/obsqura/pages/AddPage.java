package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='title']")
	WebElement Title;
	@FindBy(xpath = "//*[@id='page']")
	WebElement page_Name;
	@FindBy(xpath = "//*[@id='form']/div/div[5]/button")
	WebElement save;
	@FindBy(xpath = "//*[@id='form']/div/div[5]/a")
	WebElement cancel;

	public AddPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addPage(String title, String pageName) {
		enterTitle(title);
		enterPageName(pageName);
		clickSave();
	}

	public void enterTitle(String title) {
		Title.sendKeys(title);
	}

	public void enterPageName(String pageName) {
		page_Name.sendKeys(pageName);
	}

	public void clickSave() {
		save.click();
	}

	public void clickCancel() {
		cancel.click();
	}
}
