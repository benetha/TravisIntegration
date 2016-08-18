package test.java.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.java.pojo.Oreg;

public class OregTest {
	private WebDriver driver;
	private  Oreg oreg;

	@Before
	public void setUp() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe" ); 
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 oreg = new Oreg(driver);
	}

	@Test
	public void loginTouchstone() {
		oreg.loginWith("qa072", "W92Tester072");		
		assertTrue("Failed: Bad Credentials", oreg.isLoginSuccess());
	}
	
	@Test
	public void searchTest()
	{
		oreg.visit("https://registration-test.mit.edu/onlineregem/impersonate.htm");
		oreg.loginWith("qa072", "W92Tester072");
		oreg.searchKerb("abe707");
		
	}
	@Test
	public void testAdminLink()
	{
		oreg.visit("https://registration-test.mit.edu/onlineregem/impersonate.htm");
		oreg.loginWith("qa071", "W92Tester072");
		oreg.testPartialLink("Admin Home");
		
		assertTrue("Navigate Admin Home Failed", oreg.isDisplayed(By.id("adminHomeLink")));
	}
	
	@Test
	public void testStudentLink()
	{
		oreg.visit("https://registration-test.mit.edu/onlineregem/impersonate.htm");
		oreg.loginWith("qa072", "W92Tester072");
		oreg.testPartialLink("Student Home");
	}
	
	@Test
	public void testExitLink()
	{
		oreg.visit("https://registration-test.mit.edu/onlineregem/impersonate.htm");
		oreg.loginWith("qa072", "W92Tester072");
		oreg.testLink("Exit impersonation");
		assertTrue("Exit Failed", oreg.isDisplayed(By.linkText("LOGIN")));
	}
	
	@After
	public void tearDown() throws Exception {
	//	driver.quit();
		
	}
}
