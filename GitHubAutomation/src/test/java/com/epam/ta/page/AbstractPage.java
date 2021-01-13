package com.epam.ta.page;

import com.epam.ta.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage
{
	protected WebDriver driver;

	protected abstract AbstractPage openPage();
	protected static final int WAIT_TIMEOUT_SECONDS = 10;

	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public static WebElement waitWebElementLocatedBy(By by)
	{
		return (new WebDriverWait(DriverSingleton.getDriver(), WAIT_TIMEOUT_SECONDS))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public static WebElement waitWebElementInvisibilityOf(WebElement element)
	{
		while (!new WebDriverWait(DriverSingleton.getDriver(),WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.invisibilityOf(element))){}
		return element;
	}
	public static WebElement waitWebElementToBeClickable(WebElement element)
	{
		return (new WebDriverWait(DriverSingleton.getDriver(), WAIT_TIMEOUT_SECONDS))
				.until(ExpectedConditions.elementToBeClickable(element));
	}

}
