package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManagePages;

@Listeners(reportListners.class)
public class ManagePagesTest extends TestHelper {
	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };

	}

	@Test(dataProvider = "ValidLogin")
	public void TC_MP001_ManagePagesAddPage(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.managePages_AddPages("Java", "Hello Java");
		driver.navigate().back();
		driver.navigate().back();
		ManagePages mp = new ManagePages(driver);
		Assert.assertTrue(mp.isPagePresent("Java", "Hello Java"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_MP002_ManagePagesEditPage(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.managePages_EditPage("Hello Java", "Welcome Java");
		driver.navigate().back();
		driver.navigate().back();
		ManagePages mp = new ManagePages(driver);
		Assert.assertTrue(mp.isPagePresent("Java", "Welcome Java"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_MP003_ManagePagesDeletePage(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.managePages_DeletePage("Java");
		ManagePages mp = new ManagePages(driver);
		Assert.assertTrue(mp.isDeletedPage("Java"));
	}

}
