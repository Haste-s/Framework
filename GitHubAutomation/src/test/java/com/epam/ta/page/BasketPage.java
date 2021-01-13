package com.epam.ta.page;

import com.epam.ta.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasketPage extends AbstractPage{
    private final Logger logger = LogManager.getRootLogger();
   @FindBy(className = "basket-coupon-block-total-price-current")
   private WebElement totalPrise;

   @FindBy(className = "basket-item-table")
   private WebElement tableProducts;

   @FindBy(xpath = "//*[@id=\"basket-items-list-wrapper\"]/div[1]/div[2]/div/span")
   private WebElement  buttonForclearBusket;

   @FindBy(xpath = "//*[@id=\"basket-root\"]/div[1]/div/div/div[1]/div/div[2]/div/input")
   private WebElement  couponInput;

   public BasketPage(WebDriver driver)
   {
       super(driver);
       PageFactory.initElements(this.driver, this);
   }

    @Override
    public BasketPage openPage()
    {
        driver.get("https://www.muzdv.ru/basket/");
        return this;
    }
    public BasketPage clearBusket() {
        buttonForclearBusket.click();
        return this;
    }
    public int getTotalCost()
    {
        return StringUtils.ConvertToInt(totalPrise.getText());
    }

    public boolean existenceOfTheCheckoutButton()
    {
        List<WebElement> elements=driver.findElements(By.className(" btn btn-lg btn-default basket-btn-checkout has-ripple"));
        if(elements==null||elements.isEmpty())
            return false;
        else
            return true;
    }

    public int getProductCostByNumber(int number)
    {
        return StringUtils.ConvertToInt(driver.findElements(By.className("basket-item-price-current-text")).get(number).getText());
    }

    public int increaseTheNumberOfProduct(int numberProduct,int countProducts)
    {
        for(int i=0;i<countProducts-1;i++) {
            driver.findElements(By.className("basket-item-amount-btn-plus")).get(numberProduct-1).click();
        }
        return StringUtils.ConvertToInt(driver.findElements(By.className("basket-item-amount-filed")).get(numberProduct-1).getAttribute("value"));
    }
    public int removeTheNumberOfProduct(int numberProduct,int countProducts)
    {
        for(int i=0;i<countProducts;i++) {
            driver.findElements(By.className("basket-item-amount-btn-minus")).get(numberProduct-1).click();
        }
        return StringUtils.ConvertToInt(driver.findElements(By.className("basket-item-amount-filed")).get(numberProduct-1).getAttribute("value"));
    }
    public String enterCoupon(String coupon)
    {
        couponInput.sendKeys(coupon);
        couponInput.sendKeys(Keys.ENTER);
        return  waitWebElementLocatedBy((By.xpath("//*[@id=\"basket-root\"]/div[1]/div/div/div[3]/div/div/span[1]"))).getText();
    }

}
