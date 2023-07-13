package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.*;

@Listeners(reportListners.class)
public class ManageOfferCodeTest extends TestHelper {

	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };
	}
	@Test(dataProvider = "ValidLogin")
	public void TC_MOC001_ManageOffersImageChange(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.manageOffers_ImageChange("T151 (First Order)","D:\\images\\cake1.jpeg");
		
		//ManageOffersCodepage moc = new ManageOffersCodepage(driver);
		//Assert.assertTrue(moc.isImageChanged("D:\\images\\cake1.jpeg"));
	}
}
