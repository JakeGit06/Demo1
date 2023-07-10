package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ListCategoryPage extends PageUtility {
	WebDriver driver;
	@FindBy(xpath = "//section/div[1]/a[2]")
	WebElement search1;
	@FindBy(xpath = "//*[@id='srdiv']/div/div/div/div[2]/form/div/div[1]/input")
	WebElement Category;
	@FindBy(xpath = "//*[@id='srdiv']/div/div/div/div[2]/form/div/div[2]/button")
	WebElement search2;
	@FindBy(xpath = "//*[@id='srdiv']/div/div/div/div[1]/h4")
	WebElement searchCategory;
	@FindBy(xpath = "//section/div[1]/a[3]")
	WebElement reset;

	public ListCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void category_search(String category) {
		clickSearch1Button();
		enterCategory(category);
		clickSearch2Button();
	}

	public void clickReset() {
		reset.click();
	}

	public boolean isSearchResultCorrect(String category) {
		return (isColumnSearchCorrect("Title", category, driver));
	}

	public boolean isCategorySearchAvailable() {
		if (searchCategory.isDisplayed()) {
			return true;
		}
		return false;
	}

	public void clickSearch1Button() {
		search1.click();
	}

	public void enterCategory(String category) {
		Category.sendKeys(category);
	}

	public void clickSearch2Button() {
		search2.click();
	}
}
