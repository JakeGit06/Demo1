package com.obsqura.utilities;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public String getPageUrl(WebDriver driver) {
		return (driver.getCurrentUrl());
	}

	public String getPageTitle(WebDriver driver) {
		return (driver.getTitle());
	}

	public boolean isMasked(WebElement we) {
		if (we.getAttribute("type").equals("password")) {
			return true;
		}
		return false;
	}

	public boolean isElementPresent(WebElement we) {
		try {
			if (we.isDisplayed()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public void selectDropDown(WebElement dropDown, String newData) {
		Select dropDownSelect = new Select(dropDown);
		dropDownSelect.selectByVisibleText(newData);
	}

	public WebElement getChangeDeliveryStatusXpath(String col1, String col1_val, String col2, WebDriver driver) {
		String xpathval = getXpathOfTable(col1, col1_val, col2, driver);
		xpathval = xpathval + "/a[1]";
		WebElement changeDeliveryStatus = driver.findElement(By.xpath(xpathval));
		return changeDeliveryStatus;
	}

	public WebElement getChangeDeliveryDateXpath(String col1, String col1_val, String col2, WebDriver driver) {
		String xpathval = getXpathOfTable(col1, col1_val, col2, driver);
		xpathval = xpathval + "/a[2]";
		WebElement changeDeliveryDate = driver.findElement(By.xpath(xpathval));
		return changeDeliveryDate;
	}

	public WebElement getChangeDeliveryBoyXpath(String col1, String col1_val, String col2, WebDriver driver) {
		String xpathval = getXpathOfTable(col1, col1_val, col2, driver);
		xpathval = xpathval + "/a[3]";
		WebElement changeDeliveryBoy = driver.findElement(By.xpath(xpathval));
		return changeDeliveryBoy;
	}

	public WebElement getDeletePageXpath(String title, WebDriver driver) {
		String xpath = getXpathOfTable("Title", title, "Action", driver);
		xpath = xpath + "/a[2]";
		return (driver.findElement(By.xpath(xpath)));
	}

	public WebElement getEditPageXpath(String oldPageName, String newPageName, WebDriver driver) {
		String xpath = getXpathOfTable("Page", oldPageName, "Action", driver);
		xpath = xpath + "/a[1]";
		return (driver.findElement(By.xpath(xpath)));
	}

	public WebElement getDeactivateStatusButtonXpath(String user, WebDriver driver) {
		String xpath = getXpathOfTable("Username", user, "Status", driver);
		xpath = xpath + "/a";
		return (driver.findElement(By.xpath(xpath)));
	}

	public WebElement getPasswordButtonXpath(String user, WebDriver driver) {
		String xpath = getXpathOfTable("Name", user, "Password", driver);
		xpath = xpath + "/div/a";
		return (driver.findElement(By.xpath(xpath)));
	}

	public String getXpathOfTable(String col1, String col1_value, String col2, WebDriver driver) {
		int i = 1, col, row;
		List<WebElement> colnames1 = driver.findElements(By.xpath("//table/thead/tr/th"));
		Iterator<WebElement> itr1 = colnames1.iterator();
		while (itr1.hasNext()) {
			String header = itr1.next().getText();
			if (header.equalsIgnoreCase(col1)) {
				break;
			}
			++i;
		}
		col = i;
		String xpathval = "//table/tbody/tr/td[" + col + "]";
		i = 1;
		List<WebElement> names = driver.findElements(By.xpath(xpathval));
		Iterator<WebElement> itr2 = names.iterator();
		while (itr2.hasNext()) {
			String col1_val = itr2.next().getText();
			if (col1_val.equalsIgnoreCase(col1_value)) {
				break;
			}
			++i;
		}

		row = i;
		i = 1;
		List<WebElement> colnames2 = driver.findElements(By.xpath("//table/thead/tr/th"));
		Iterator<WebElement> itr3 = colnames2.iterator();
		while (itr3.hasNext()) {
			String header = itr3.next().getText();
			if (header.equalsIgnoreCase(col2)) {
				break;
			}
			++i;
		}
		col = i;
		xpathval = "//table/tbody/tr[" + row + "]/td[" + col + "]";
		return (xpathval);
	}

	public WebElement get_WebElementOfTable(String col1, String col1_value, String col2, WebDriver driver) {
		String xpath = getXpathOfTable(col1, col1_value, col2, driver);
		return (driver.findElement(By.xpath(xpath)));
	}

	public boolean isElementPresentInColumn(String col1, String col1_value, WebDriver driver) {
		int i = 1, col;
		List<WebElement> colnames1 = driver.findElements(By.xpath("//table/thead/tr/th"));
		Iterator<WebElement> itr1 = colnames1.iterator();
		while (itr1.hasNext()) {
			String header = itr1.next().getText();
			if (header.equalsIgnoreCase(col1)) {
				break;
			}
			++i;
		}
		col = i;
		String xpathval = "//table/tbody/tr/td[" + col + "]";
		i = 1;
		List<WebElement> names = driver.findElements(By.xpath(xpathval));
		Iterator<WebElement> itr2 = names.iterator();
		while (itr2.hasNext()) {
			String col1_val = itr2.next().getText();
			if (col1_val.equalsIgnoreCase(col1_value)) {
				return true;
			}
			++i;
		}
		return false;
	}

	public int elementRowNoInColumn(String col1, String col1_value, WebDriver driver) {
		int i = 1, col, row;
		List<WebElement> colnames1 = driver.findElements(By.xpath("//table/thead/tr/th"));
		Iterator<WebElement> itr1 = colnames1.iterator();
		while (itr1.hasNext()) {
			String header = itr1.next().getText();
			if (header.equalsIgnoreCase(col1)) {
				break;
			}
			++i;
		}
		col = i;
		String xpathval = "//table/tbody/tr/td[" + col + "]";
		i = 1;
		List<WebElement> names = driver.findElements(By.xpath(xpathval));
		Iterator<WebElement> itr2 = names.iterator();
		while (itr2.hasNext()) {
			String col1_val = itr2.next().getText();
			if (col1_val.equalsIgnoreCase(col1_value)) {
				break;
			}
			++i;
		}

		row = i;
		return (row);
	}

	public boolean isColumnSearchCorrect(String col1, String col1_value, WebDriver driver) {
		int i = 1, col;
		List<WebElement> colnames1 = driver.findElements(By.xpath("//table/thead/tr/th"));
		Iterator<WebElement> itr1 = colnames1.iterator();
		while (itr1.hasNext()) {
			String header = itr1.next().getText();
			if (header.equalsIgnoreCase(col1)) {
				break;
			}
			++i;
		}
		col = i;
		i = 0;
		String xpathval = "//table/tbody/tr/td[" + col + "]";
		List<WebElement> names = driver.findElements(By.xpath(xpathval));
		Iterator<WebElement> itr2 = names.iterator();
		while (itr2.hasNext()) {
			String col1_val = itr2.next().getText();
			if (col1_val.contains(col1_value)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public WebElement getUserPasswordXpath(String user, WebDriver driver) {
		int row = elementRowNoInColumn("Name", user, driver);
		row = row + 1;
		String xpath = "//table/tbody/tr[" + row + "]/td/div/div/span";
		return (driver.findElement(By.xpath(xpath)));
	}

}