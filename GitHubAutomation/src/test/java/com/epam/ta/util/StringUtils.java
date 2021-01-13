package com.epam.ta.util;

public class StringUtils {

    public static int ConvertToInt(String number)
    {
        return Integer.parseInt( number.replaceAll("[^0-9]", ""));
    }
}
