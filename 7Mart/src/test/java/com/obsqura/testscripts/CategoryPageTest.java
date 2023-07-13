package com.obsqura.testscripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.listeners.reportListners;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.ListCategoryPage;
import com.obsqura.pages.LoginPage;

@Listeners(reportListners.class)
public class CategoryPageTest extends TestHelper {
	@DataProvider(name = "ValidLogin")
	public Object[][] getDataFromDataprovider1() {
		return new Object[][] { { "admin", "admin" } };

	}

	@Test(dataProvider = "ValidLogin")
	public void TC_CP001_CategorySearch(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.category_Search("Heavy");
		ListCategoryPage lcp = new ListCategoryPage(driver);
		Assert.assertTrue(lcp.isSearchResultCorrect("Heavy"));
	}

	@Test(dataProvider = "ValidLogin")
	public void TC_CP002_CategoryReset(String username, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.successfulLoginCheckWithLoginButton(username, password);
		HomePage hp = new HomePage(driver);
		hp.reset_Search("Heavy");
		ListCategoryPage lcp = new ListCategoryPage(driver);
		Assert.assertFalse(lcp.isCategorySearchAvailable());
	}
}
