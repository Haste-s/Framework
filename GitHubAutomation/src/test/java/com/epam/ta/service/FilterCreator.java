package com.epam.ta.service;

import com.epam.ta.model.Filter;
import com.epam.ta.model.Product;

public class FilterCreator {
    public static final String FILTER_BRAND="testdata.filter.%s.brand";
    public static final String FILTER_CATEGORY="testdata.filter.%s.category";
    public static final String FILTER_TYPE="testdata.filter.%s.type";
    public static final String FILTER_SORTING="testdata.filter.%s.sorting";

    public static Filter withAllProperty(String filterNumber){
        String filterBrand=String.format(FILTER_BRAND,filterNumber);
        String filterCategory=String.format(FILTER_CATEGORY,filterNumber);
        String filterType=String.format(FILTER_TYPE,filterNumber);
        String filterSorting=String.format(FILTER_SORTING,filterNumber);
        return new Filter(TestDataReader.getTestData(filterBrand),
                TestDataReader.getTestData(filterCategory),
                TestDataReader.getTestData(filterType),
                TestDataReader.getTestData(filterSorting));
    }

    public static Filter withEmptyFilterBrandAndSorting(String filterNumber){
        String filterCategory=String.format(FILTER_CATEGORY,filterNumber);
        String filterType=String.format(FILTER_TYPE,filterNumber);
        return new Filter("default",
                TestDataReader.getTestData(filterCategory),
                TestDataReader.getTestData(filterType),
                "default");
    }
}
