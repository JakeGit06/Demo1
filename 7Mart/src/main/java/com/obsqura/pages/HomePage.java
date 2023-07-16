package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class HomePage extends PageUtility {

	WebDriver driver;
	@FindBy(xpath = "//nav/ul[2]/li/a")
	WebElement profile;
	@FindBy(xpath = "//div/div/div/div[2]/ol/li[1]/a")
	WebElement home;
	@FindBy(xpath = "//section/div/div/div[11]/div/a")
	WebElement manageOrders;
	@FindBy(xpath = "//section/div/div/div[1]/div/a")
	WebElement managePages;
	@FindBy(xpath = "//section/div/div/div[2]/div/a")
	WebElement adminUsers;
	@FindBy(xpath = "//section/div/div/div[10]/div/a")
	WebElement manageUsers;
	@FindBy(xpath = "//section/div/div/div[4]/div/a")
	WebElement category;
	@FindBy(xpath = "//section/div/div/div[6]/div/a")
	WebElement manageOffersCode;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isHomePageLoaded() {
		boolean element1 = isElementPresent(profile);
		boolean element2 = isElementPresent(home);
		if (((element1) && (element2)) == true) {
			return true;
		}
		return false;
	}

	public void manageOrders_editStatus(String col1, String col1_val, String col2, String col2_1, String newData) {
		clickManageOrders();
		ManageOrdersPage mop = new ManageOrdersPage(driver);
		mop.editStatus(col1, col1_val, col2, col2_1, newData);
	}

	public void clickManageOrders() {
		manageOrders.click();
	}

	public void clickManagePages() {
		managePages.click();
	}

	public void managePages_AddPages(String title, String pageName) {
		clickManagePages();
		ManagePages mp = new ManagePages(driver);
		mp.addPages(title, pageName);
	}

	public void managePages_DeletePage(String title) {
		clickManagePages();
		ManagePages mp = new ManagePages(driver);
		mp.deletePage(title);
	}

	public void managePages_EditPage(String oldPageName, String newPageName) {
		clickManagePages();
		ManagePages mp = new ManagePages(driver);
		mp.editPage(oldPageName, newPageName);
	}

	public void adminUsers_deactivate(String user) {
		clickAdminUsers();
		AdminUsersPage au = new AdminUsersPage(driver);
		au.deactivateUser(user);
	}

	public void clickAdminUsers() {
		adminUsers.click();
	}

	public void user_PasswordView(String user) {
		clickManageUsers();
		ManageUsersPage mu = new ManageUsersPage(driver);
		mu.user_passwordView(user);
	}

	public void clickManageUsers() {
		manageUsers.click();
	}

	public void category_Search(String category) {
		clickCategory();
		ListCategoryPage lcp = new ListCategoryPage(driver);
		lcp.category_search(category);
	}

	public void reset_Search(String category) {
		clickCategory();
		ListCategoryPage lcp = new ListCategoryPage(driver);
		lcp.category_search(category);
		lcp.clickReset();
	}

	public void clickManageOffersCode() {
		manageOffersCode.click();
	}

	public void clickCategory() {
		category.click();

	}

}
