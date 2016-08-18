package main.java.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	private WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void visit(String url)
	{
		driver.get(url);
	}
	
	public WebElement find(By locator)
	{
		return driver.findElement(locator);
	}
	
	public void click(By locator)
	{
		find(locator).click();
	}
	
	public void type(String inputText, By locator)
	{
		find(locator).sendKeys(inputText);
	}
	
	public void submit(By locator)
	{
		find(locator).submit();
	}

	public Boolean isDisplayed(By locator)
	{
		try
		{
			return find(locator).isDisplayed();
		}
		catch(NoSuchElementException exception)
		{
			return false;
		}
	}
	 public void testPartialLink(String link)
	 {
		click(By.partialLinkText(link));
	 }
	 public void testLink(String link)
	 {
		 click(By.linkText(link));
	 }
}
