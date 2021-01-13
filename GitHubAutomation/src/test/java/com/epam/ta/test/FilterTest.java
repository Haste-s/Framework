package com.epam.ta.test;

import com.epam.ta.model.Filter;
import com.epam.ta.page.CatalogPage;
import com.epam.ta.page.MainPage;
import com.epam.ta.service.FilterCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTest extends CommonConditions {

    @Test
    public void SelectSpecificTypeOfProduct()
    {
        Filter filter = FilterCreator.withEmptyFilterBrandAndSorting("first");
        boolean catalogIsType = new MainPage(driver)
                .openPage()
                .openCatalog()
                .openCatalogByType(filter.getType())
                .openCatalogByType(filter.getCategory())
                .thisCatalogIsType(filter.getCategory());

        Assert.assertTrue(catalogIsType);
    }

    @Test
    public void selectProduct()
    {
        Filter filter = FilterCreator.withAllProperty("second");
        CatalogPage catalogIsType = new MainPage(driver)
                .openPage()
                .openCatalog()
                .openCatalogByType(filter.getType())
                .sortingByParameter(filter.getSorting());

        Assert.assertTrue(true);
    }
}
