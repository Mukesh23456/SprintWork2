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
	String email,fname,lname,company,phone,country,role,agree;
	RequestDemo r=new RequestDemo(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;


	
	@Given("The user is in the request demo page {string} and {int}")
	public void the_user_is_in_the_request_demo_page_and(String SheetName, Integer row) throws InvalidFormatException, IOException, InterruptedException {
		System.setProperty("Webdriver.chrome.driver","D:\\capgemini\\selenium\\selenium demo\\Sprint2\\src\\test\\resources\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    Home a=new Home(driver);
	    a.enterRequestDemo();
	    

	    startTest();
	    Thread.sleep(3500);
	    ExcelReader reader=new ExcelReader();
	    List<Map<String,String>> testdata=reader.getData("D:\\capgemini\\automation.xlsx",SheetName);
	     email=testdata.get(row).get("email");
	     fname=testdata.get(row).get("fname");
	     lname=testdata.get(row).get("lname");
	     company=testdata.get(row).get("company");
	     phone=testdata.get(row).get("phone");
	     country=testdata.get(row).get("country");
	     role=testdata.get(row).get("role");
	     agree=testdata.get(row).get("agree");
	    
	}
	
	
	
	@SuppressWarnings("deprecation")
	@When("He enters invalid details")
	public void he_enters_invalid_details() throws NumberFormatException, InterruptedException, IOException {
		r.enterEmail(email);
	    r.enterFname(fname);
	    r.enterLname(lname);
	    
	    js.executeScript("window.scrollBy(0,350)", "");
	    r.enterCompany(company);
	    r.enterPhone(phone);
	    r.selectCountry(country);
	    r.selectRole(role);
	    
	    r.clickAgree(Integer.valueOf(agree));
	    takeScreenshot(driver);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    
	    
		
	    
		
	}
	
	
	@Then("He submits the details")
	public void He_submits_the_details() throws IOException, InterruptedException {
		r.enterRequestDemo();
	    takeScreenshot(driver);
	    Thread.sleep(3000);
	    boolean b=driver.findElement(By.xpath("//*[@id='Company']")).isDisplayed();
	    assertEquals(true,b);
	    driver.quit();
	    endTest();
	   
	    
	}

}
