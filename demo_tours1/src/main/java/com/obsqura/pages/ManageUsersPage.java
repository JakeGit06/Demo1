package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ManageUsersPage extends PageUtility {
	WebDriver driver;

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void user_passwordView(String user) {
		WebElement passwordButton = getPasswordButtonXpath(user, driver);
		passwordButton.click();
	}

	public boolean isPasswordDisplayed(String user) {
		WebElement userPassword = getUserPasswordXpath(user, driver);
		if (userPassword.isDisplayed()) {
			return true;
		}
		return false;
	}
}
