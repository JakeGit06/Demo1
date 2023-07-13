package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.obsqura.utilities.PageUtility;
import com.obsqura.utilities.WaitUtility;

public class ManageOrdersPage extends PageUtility {
	WebDriver driver;
	@FindBy(xpath = "//*[@id='status']")
	WebElement changeStatusDropDownList;
	@FindBy(xpath = "//*[@id='delivery_boy_id']")
	WebElement changeDeliveryBoyDropDownList;
	@FindBy(xpath = "//*[@id='mymodal3704']/div/div/form/div[3]/div/button")
	WebElement deliveryBoyButton;
	@FindBy(xpath = "//*[@id='mymodal1704']/div/div/form/div[3]/div/button")
	WebElement deliveryStatusButton;
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/span[1]")
	WebElement currentStatus;
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/span[3]")
	WebElement currentDeliveryBoy;
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]/span[2]")
	WebElement currentDate;
	WaitUtility wu = new WaitUtility();

	public ManageOrdersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void editStatus(String col1, String col1_val, String col2, String col2_1, String newData) {

		if (col2_1.equalsIgnoreCase("change status")) {
			changeStatus(col1, col1_val, col2, newData);
		} else if (col2_1.equalsIgnoreCase("change delivery date")) {
			changeDeliveryDate(col1, col1_val, col2, newData);
		} else if (col2_1.equalsIgnoreCase("assign delivery boy")) {
			changeDeliveryBoy(col1, col1_val, col2, newData);
		}

	}

	public void changeStatus(String col1, String col1_val, String col2, String newData) {
		WebElement changeDeliveryStatus = getChangeDeliveryStatusXpath(col1, col1_val, col2, driver);
		changeDeliveryStatus.click();
		changeStatusDropDownList.click();
		selectDropDown(changeStatusDropDownList, newData);
		deliveryStatusButton.click();
	}

	public void changeDeliveryDate(String col1, String col1_val, String col2, String newData) {
		WebElement changeDeliveryDate = getChangeDeliveryDateXpath(col1, col1_val, col2, driver);
		changeDeliveryDate.click();
	}

	public void changeDeliveryBoy(String col1, String col1_val, String col2, String newData) {
		WebElement changeDeliveryBoy = getChangeDeliveryBoyXpath(col1, col1_val, col2, driver);
		changeDeliveryBoy.click();
		changeDeliveryBoyDropDownList.click();
		selectDropDown(changeDeliveryBoyDropDownList, newData);
		deliveryBoyButton.click();
	}

	public String get_CurrentStatus() {
		return (currentStatus.getText());
	}

	public String get_CurrentDeliveryBoy() {
		return (currentDeliveryBoy.getText());
	}

	public String get_CurrentDeliveryDate() {
		return (currentDate.getText());
	}

}
