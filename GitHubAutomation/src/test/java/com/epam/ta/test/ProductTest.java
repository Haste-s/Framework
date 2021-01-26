package com.epam.ta.test;

import com.epam.ta.model.Product;
import com.epam.ta.model.User;
import com.epam.ta.page.BasketPage;
import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.MainPage;
import com.epam.ta.service.ProductCreator;
import com.epam.ta.service.UserCreator;
import com.epam.ta.util.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends CommonConditions {
    private final Logger logger = LogManager.getRootLogger();

   // @Test
    public void CorrectDisplayingPriceSumOfTwoItems()
    {
        Product firstProduct = ProductCreator.withEmptyProductSize("first");
        Product secondProduct = ProductCreator.withEmptyProductSize("second");
        BasketPage basketPage = new MainPage(driver)
                .openPage()
                .searchForProducts(firstProduct.getProductName())
                .addProductIntoBasket(firstProduct.getProductName())
                .searchForProducts(secondProduct.getProductName())
                .addProductIntoBasket(secondProduct.getProductName())
                .openBasketPage();
        int totalCost = basketPage.getTotalCost();
        logger.info("Total cost = " + totalCost);
        int PriceFirstProduct = basketPage.getProductCostByNumber(1);
        logger.info("Total cost = " + PriceFirstProduct);
        int PriceSecondProduct = basketPage.getProductCostByNumber(2);
        logger.info("Total cost = " + PriceSecondProduct);

        Assert.assertEquals(totalCost, PriceFirstProduct + PriceSecondProduct);
    }

    //@Test
    public void PurchaseWithOutOfProduct()
    {
        Product product = ProductCreator.withEmptyProductSize("first");
        boolean opportunityToPlaceAnOrder = new MainPage(driver)
                .openPage()
                .searchForProducts(product.getProductName())
                .addProductIntoBasket(product.getProductName())
                .openBasketPage()
                .clearBusket()
                .existenceOfTheCheckoutButton();

        Assert.assertFalse(opportunityToPlaceAnOrder);
    }

  //  @Test
    public void ChooseMoreUnitsOfTheSameProduct()
    {
        Product product = ProductCreator.withAllProperty("first");
        int countProduct = new MainPage(driver)
                .openPage()
                .searchForProducts(product.getProductName())
                .addProductIntoBasket(product.getProductName())
                .openBasketPage()
                .increaseTheNumberOfProduct(1,product.getCount());

        Assert.assertEquals(countProduct, product.getCount());
    }

    //@Test
    public void removeOneUnitOfProduct()
    {
        Product product = ProductCreator.withAllProperty("first");
        BasketPage basketPage =new MainPage(driver)
                .openPage()
                .searchForProducts(product.getProductName())
                .addProductIntoBasket(product.getProductName())
                .openBasketPage();
        int countProductBeforeDeletion = basketPage.increaseTheNumberOfProduct(1,product.getCount());
        int countProductAfterDeletion = basketPage.removeTheNumberOfProduct(1,1);
        Assert.assertEquals(countProductBeforeDeletion,countProductAfterDeletion+1);
    }
   // @Test
    public void InputInvalidPromoCode()
    {
        User user = UserCreator.withCredentialsFromProperty();
        Product product = ProductCreator.withEmptyProductSize("first");
        String errorMessag =new MainPage(driver)
                .openPage()
                .searchForProducts(product.getProductName())
                .addProductIntoBasket(product.getProductName())
                .openBasketPage()
                .enterCoupon(user.getCoupon());

        Assert.assertEquals(errorMessag,user.getCoupon()+" - купон не найден");
    }
   // @Test
    public void AddItemToTheListOfPendingItems()
    {
        Product product = ProductCreator.withAllProperty("first");
        CatalogPage catalogIsType = new MainPage(driver)
                .openPage()
                .searchForProducts(product.getProductName())
                .postpone(product.getProductName());

        Assert.assertTrue(true);
    }
}
