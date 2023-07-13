package com.obsqura.testscripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageOrdersPage;

@Listeners(reportListners.class)
public class ManageOrdersPageTest extends TestHelper {
	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };

	}

	@Test(dataProvider = "ValidLogin")
	public void TC_MO001_ManageOrdersStatusEditing(String username, String password) {
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

}
