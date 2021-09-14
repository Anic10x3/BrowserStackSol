package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utils.utils;

public class onePlusPage {
	WebDriver driver;
	utils utility;
	@FindBy(how = How.XPATH, using = "//input[@id = 'twotabsearchtextbox']")
	WebElement textBoxSearch;
	
	@FindBy(how = How.XPATH, using = "//input[@value = 'Go']")
	WebElement buttonSearch;
	
	@FindBy(how = How.XPATH, using = "(//i[@class = 'a-icon a-icon-checkbox'])[3]")
	WebElement checkboxOnePlus;
	
	@FindBy(how = How.XPATH, using = "//section[@aria-label = '4 Stars & Up']")
	WebElement ratings4andabove;

	@FindBy(how = How.XPATH, using = "//span[@data-action= 'a-dropdown-button']")
	WebElement dropdownSortBy;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Price: Low to High']")
	WebElement dropDownLowToHighValue;
	
	public onePlusPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void searchMobile(String searchMobile) throws IOException {
		String expectedTitle = utils.getPropertyValues("Title");
		textBoxSearch.sendKeys(searchMobile);
		String actualTitle =  driver.getTitle();
		System.out.println(actualTitle);
		assertEquals(expectedTitle, actualTitle);
	}
	
	public void clickSearch() throws InterruptedException {
		buttonSearch.click();
		Thread.sleep(5000);
		checkboxOnePlus.click();
		Thread.sleep(5000);
		ratings4andabove.click();
		Thread.sleep(5000);
		dropdownSortBy.click();
		Thread.sleep(5000);
		dropDownLowToHighValue.click();
		Thread.sleep(5000);
	}
	public void results() {
		List<WebElement> listyWebName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> listyWebPrice = driver.findElements(By.xpath("//span[@class = 'a-price-whole']"));
		List<WebElement> listyWebLinks = driver.findElements(By.xpath("//h2/a"));
		
		System.out.println(listyWebName.size() +" Results found on page 1");
		for(int i= 0; i<listyWebName.size(); i++) {
			
			System.out.println("Product Name: " +listyWebName.get(i).getText());
			System.out.println("Display Price: " +listyWebPrice.get(i).getText());
			System.out.println("Link to Product Details Page: " +listyWebLinks.get(i).getAttribute("href"));
		}
	
	}
}
