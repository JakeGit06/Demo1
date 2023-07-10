package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class AdminUsersPage extends PageUtility {
	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void deactivateUser(String user) {
		WebElement statusButton = getDeactivateStatusButtonXpath(user, driver);
		if (statusButton.getText().equalsIgnoreCase("active")) {
			statusButton.click();
		}
	}

	public boolean isDeactivated(String user) {
		WebElement statusButton = getDeactivateStatusButtonXpath(user, driver);
		if (statusButton.getText().equalsIgnoreCase("Inactive")) {
			return true;
		}
		return false;
	}
}
