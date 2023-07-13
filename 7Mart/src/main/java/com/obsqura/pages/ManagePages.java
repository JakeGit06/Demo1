package com.obsqura.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ManagePages extends PageUtility {
	WebDriver driver;
	@FindBy(xpath = "//section/div[1]/a[1]")
	WebElement newPage;

	public ManagePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addPages(String title, String pageName) {
		clickNewPages();
		AddPage ap = new AddPage(driver);
		ap.addPage(title, pageName);
	}

	public void clickNewPages() {
		newPage.click();
	}

	public boolean isPagePresent(String title, String pageName) {
		WebElement page_name = get_WebElementOfTable("Title", title, "Page", driver);
		if (page_name.getText().equalsIgnoreCase(pageName)) {
			return true;
		}
		return false;
	}

	public void deletePage(String title) {
		WebElement delete_page = getDeletePageXpath(title, driver);
		delete_page.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public boolean isDeletedPage(String title) {
		if (isElementPresentInColumn("Title", title, driver)) {
			return false;
		}
		return true;
	}

	public void editPage(String oldPageName, String newPageName) {
		WebElement edit_page = getEditPageXpath(oldPageName, newPageName, driver);
		edit_page.click();
		EditPage ep = new EditPage(driver);
		ep.editPage(newPageName);
	}

}
