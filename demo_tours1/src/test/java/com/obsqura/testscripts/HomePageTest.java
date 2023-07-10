package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.*;

@Listeners(reportListners.class)
public class HomePageTest extends TestHelper {

	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };

	}

	@Test(dataProvider = "ValidLogin")
	public void TC_HT001_ManageOrdersStatusEditing(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		SoftAssert softAssert = new SoftAssert();
		hp.manageOrders_editStatus("Order id", "704", "Status", "Assign delivery boy", "jack");
		ManageOrdersPage mop = new ManageOrdersPage(driver);
		driver.navigate().back();
		String current_boy = mop.get_CurrentDeliveryBoy();
		softAssert.assertEquals(current_boy, "Jack");
		driver.navigate().back();
		hp.manageOrders_editStatus("Order id", "704", "Status", "Change status", "Paid");
		driver.navigate().back();
		String current_status = mop.get_CurrentStatus();
		softAssert.assertEquals(current_status, "PAID");
		driver.navigate().back();
		softAssert.assertAll();
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_HT002_ManagePagesAddPage(String username, String password) {
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
	public void TC_HT003_ManagePagesEditPage(String username, String password) {
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
	public void TC_HT004_ManagePagesDeletePage(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.managePages_DeletePage("Java");
		ManagePages mp = new ManagePages(driver);
		Assert.assertTrue(mp.isDeletedPage("Java"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_HT005_DeactivateUser(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.adminUsers_deactivate("Joan");
		AdminUsersPage au = new AdminUsersPage(driver);
		Assert.assertTrue(au.isDeactivated("Joan"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_HT006_UserPasswordView(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.user_PasswordView("Parvathy Mohan");
		ManageUsersPage mu = new ManageUsersPage(driver);
		Assert.assertTrue(mu.isPasswordDisplayed("Parvathy Mohan"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_HT007_CategorySearch(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.category_Search("Heavy");
		ListCategoryPage lcp = new ListCategoryPage(driver);
		Assert.assertTrue(lcp.isSearchResultCorrect("Heavy"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_HT008_CategoryReset(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.reset_Search("Heavy");
		ListCategoryPage lcp = new ListCategoryPage(driver);
		Assert.assertFalse(lcp.isCategorySearchAvailable());
	}

}
