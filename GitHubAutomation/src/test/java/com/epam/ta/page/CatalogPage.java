package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "title-search-input_fixed")
    private WebElement searchBar;

    @FindBy(className = "button_block")
    private WebElement addButtonProduct;

    @FindBy(className = "wrap_button")
    private WebElement linkBasketPage;

    @FindBy(id ="pagetitle")
    private WebElement pagetitle;

    @FindBy(xpath = "//*[@id=\"right_block_ajax\"]/div[1]/div[1]/div[2]/div/div[1]")
    private WebElement sortingMenu;

    @FindBy(xpath = "//*[@id=\"right_block_ajax\"]/div[1]/div[2]/div/div/form/div[2]/div[4]")
    private WebElement brandMenu;

    @FindBy(xpath = "//*[@id=\"bx_117848907_17161\"]/div[1]/div/div[2]/div/div/div/div[1]")
    private WebElement postponeButton;
    public CatalogPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public CatalogPage openPage()
    {
        driver.get("https://www.muzdv.ru/catalog/");
        return this;
    }

    public BasketPage openBasketPage()
    {
        waitWebElementToBeClickable(linkBasketPage).click();
        return new BasketPage(driver);
    }

    public CatalogPage addProductIntoBasket(String nameProduct)
    {
        driver.findElement(By.linkText(nameProduct)).click();
        waitWebElementToBeClickable(addButtonProduct).click();
        logger.info("Probuct "+nameProduct+" added to basket");
        return this;
    }

    public CatalogPage searchForProducts(String product)
    {
        searchBar.sendKeys(product);
        searchBar.sendKeys(Keys.ENTER);
        return new CatalogPage(driver);
    }

    public CatalogPage openCatalogByType(String type)
    {
        driver.findElement(By.linkText(type)).click();
        logger.info("Open catalog with type "+type);
        return this;
    }

    public boolean thisCatalogIsType(String type)
    {
        if(type.equals(pagetitle.getText()))
            return true;
        else
            return false;
    }
    public CatalogPage sortingByParameter(String sorting)
    {
        sortingMenu.click();
        driver.findElement(By.linkText(sorting)).click();
        return this;
    }

    public CatalogPage postpone(String nameProduct)
    {
        driver.findElement(By.linkText(nameProduct)).click();
        postponeButton.click();
        return this;
    }
}
