package com.obsqura.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.utilities.*;

public class LoginPage extends PageUtility {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='login-form']/div/div/div[1]/input")
	WebElement user;
	@FindBy(xpath = "//*[@id='login-form']/div/div/div[2]/input")
	WebElement pass;
	@FindBy(xpath = "//*[@id='login-form']/div/div/div[3]/div[2]/button")
	WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void successfulLoginCheckWithLoginButton(String username, String password) {
		enterusername(username);
		enterpassword(password);
		clickloginbutton();
	}

	public void successfulLoginCheckWithEnterButton(String username, String password) {
		enterusername(username);
		enterpassword(password);
		pressenter();
	}

	public void unsuccessfulLoginCheck(String username, String password) {
		enterusername(username);
		enterpassword(password);
		clickloginbutton();
	}

	public boolean ispasswordMask(String username, String password) {
		enterusername(username);
		enterpassword(password);
		return (isMasked(pass));
	}

	public void validationMessageCheck() {
		clickloginbutton();
	}

	public void enterusername(String username) {
		user.sendKeys(username);
	}

	public void enterpassword(String password) {
		pass.sendKeys(password);
	}

	public void clickloginbutton() {
		login.click();
	}

	public void pressenter() {
		pass.sendKeys(Keys.ENTER);
	}
}
