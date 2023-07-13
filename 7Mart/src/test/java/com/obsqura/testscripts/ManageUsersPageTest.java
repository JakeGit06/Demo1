package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageUsersPage;

@Listeners(reportListners.class)
public class ManageUsersPageTest extends TestHelper {

	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };

	}

	@Test(dataProvider = "ValidLogin")
	public void TC_MU001_UserPasswordView(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.user_PasswordView("Parvathy Mohan");
		ManageUsersPage mu = new ManageUsersPage(driver);
		Assert.assertTrue(mu.isPasswordDisplayed("Parvathy Mohan"));
	}

}
