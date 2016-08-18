package main.java.pojo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Oreg extends BasePage{
	
	 public Oreg(WebDriver driver)
	 {
		 super(driver);
		 visit("https://registration-test.mit.edu/onlineregem/impersonate.htm");
	 }
	 
	 public void loginWith(String userName, String password)
	 {
		 type(userName, By.name("j_username"));
		 type(password,By.name("j_password"));
		 submit(By.name("Submit"));
	 }
	 public Boolean isLoginSuccess()
	 {
		 return isDisplayed(By.cssSelector("div.adminLeftCol"));
	 }
	 public void searchKerb(String key)
	 {
		 type(key, By.name("j_username"));
		 submit(By.xpath("//*[@id=\"content\"]/form/div/input[2]"));
	 }
	

}
