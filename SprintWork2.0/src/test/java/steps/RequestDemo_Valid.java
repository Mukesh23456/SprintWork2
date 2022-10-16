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
public class RequestDemo_Valid extends ScreenshotGenerator{
 
  static WebDriver driver;
  String email,fname,lname,company,phone,country,role,agree;
	RequestDemo r=new RequestDemo(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
    
	@Given("the user is in the request demo page {string} and {int}")
	public void the_user_is_in_the_request_demo_page_and(String SheetName, Integer row) throws InterruptedException, InvalidFormatException, IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		Home a=new Home(driver);
	    a.enterRequestDemo();
	    
	    startReport();
	    startTest();
	    
	    Thread.sleep(3000);
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
	
 
	@When("he enters all details")
	public void he_enters_all_details() throws NumberFormatException, InterruptedException, IOException {
		js.executeScript("window.scrollBy(0,350)", "");
	    r.enterEmail(email);
	    r.enterFname(fname);
	    r.enterLname(lname);
	    r.enterCompany(company);
	    r.enterPhone(phone);
	    takeScreenshot(driver);
	    r.selectCountry(country);
	    r.selectRole(role);
	    r.clickAgree(Integer.valueOf(agree));
	    
	    
	    
	    
	}
 
 
	@SuppressWarnings("deprecation")
	@Then("he submits the details")
	public void he_submits_the_details() throws IOException {
		r.enterRequestDemo();
	    takeScreenshot(driver);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		boolean a=driver.findElement(By.xpath("//*[@class='ProductDemoFormTemplate_h4__zNlcM']")).isDisplayed();
		assertEquals(true,a);
		endTest();
		driver.quit();
		
	    
	}
}
