package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.Home;
import pagefactory.RequestDemo;

import utilities.ExcelReader;
import utilities.ScreenshotGenerator;

@Test
public class RequestDemo_Invalid extends ScreenshotGenerator{
	
	static WebDriver driver;


	@SuppressWarnings("deprecation")
	@Given("The user is in the request demo page {string} and {int}")
	public void the_user_is_in_the_request_demo_page_and(String SheetName, Integer row) throws InvalidFormatException, IOException, InterruptedException {
		System.setProperty("Webdriver.chrome.driver","D:\\capgemini\\selenium\\selenium demo\\Sprint2\\src\\test\\resources\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    Home a=new Home(driver);
	    a.enterRequestdemo();
	    RequestDemo r=new RequestDemo(driver);

	    startTest();
	    Thread.sleep(3500);
	    ExcelReader reader=new ExcelReader();
	    List<Map<String,String>> testdata=reader.getData("D:\\capgemini\\automation.xlsx",SheetName);
	    String email=testdata.get(row).get("email");
	    String fname=testdata.get(row).get("fname");
	    String lname=testdata.get(row).get("lname");
	    String company=testdata.get(row).get("company");
	    String phone=testdata.get(row).get("phone");
	    String country=testdata.get(row).get("country");
	    String role=testdata.get(row).get("role");
	    
	    r.enterEmail(email);
	    r.enterFname(fname);
	    r.enterLname(lname);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)", "");
	    r.enterCompany(company);
	    r.enterPhone(phone);
	    r.selectCountry(country);
	    r.selectRole(role);
	    
	    r.clickAgree();
	    takeScreenshot(driver);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    r.enterrequestdemo();
	    takeScreenshot(driver);
	    Thread.sleep(3000);
	    boolean b=driver.findElement(By.xpath("//*[@id='Company']")).isDisplayed();
	    assertEquals(true,b);
	    driver.quit();
	    
	}
	
	
	
	@When("He enters invalid details")
	public void he_enters_invalid_details() {
		
		
	    
		
	}
	
	
	@Then("He submits the details")
	public void He_submits_the_details() {
		
	    endTest();
	   
	    
	}

}
