package com.obsqura.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import com.obsqura.listeners.reportListners;
import com.obsqura.pages.*;
import com.obsqura.utilities.*;

@Listeners(reportListners.class)
public class LoginPageTest extends TestHelper {

	@DataProvider(name = "InvalidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "pass2" }, { "user3", "admin" }, { "user4", "pass4" } };

	}

	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider2() {
		return new Object[][] { { "admin", "admin" } };

	}

	@Test(dataProvider = "ValidLogin")
	public void TC_LT001_successfulLoginUsingLoginButton(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isHomePageLoaded());
	}

	@Test
	public void TC_LT002_successfulLoginUsingEnterKey() throws IOException {
		ExcelUtility e = new ExcelUtility("ValidLogin.xlsx");
		String username = e.readData(0, 0);
		String password = e.readData(0, 1);
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithEnterButton(username, password);
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.isHomePageLoaded());
	}

	@Test(dataProvider = "InvalidLogin")
	public void TC_LT003_unsuccessfulLogin(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.unsuccessfulLoginCheck(username, password);
		HomePage hp = new HomePage(driver);
		Assert.assertFalse(hp.isHomePageLoaded());
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_LT004_passwordMasked(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.ispasswordMask(username, password));
	}

}
