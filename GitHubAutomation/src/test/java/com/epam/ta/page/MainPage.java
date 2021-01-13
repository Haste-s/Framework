package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{

	private final String BASE_URL = "https://www.muzdv.ru/";

	@FindBy(id = "title-search-input_fixed")
	private WebElement searchBar;

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/div/div[1]/div/div[2]/div/div/nav/div/table/tbody/tr/td/div/a")
	private WebElement catalog;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public CatalogPage searchForProducts(String product)
	{
		searchBar.sendKeys(product);
		searchBar.sendKeys(Keys.ENTER);
		return new CatalogPage(driver);
	}

	public CatalogPage openCatalog()
	{
		catalog.click();
		return new CatalogPage(driver);
	}
}
