package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.AdminUsersPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;

@Listeners(reportListners.class)
public class AdminUsersPageTest extends TestHelper {
	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_AU001_DeactivateUser(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.adminUsers_deactivate("Joan");
		AdminUsersPage au = new AdminUsersPage(driver);
		Assert.assertTrue(au.isDeactivated("Joan"));
	}
}
