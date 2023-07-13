package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ManageOffersCodepage extends PageUtility{
	WebDriver driver;

	public ManageOffersCodepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void imageChange(String Offer_Code,String imgPath) {
		WebElement edit = get_OfferEditXpath(Offer_Code, driver);
		edit.click();
		EditOfferPage eop=new EditOfferPage(driver);
		eop.imageEdit(imgPath);
	}
}
