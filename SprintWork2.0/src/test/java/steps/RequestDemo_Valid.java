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
	
	
    @SuppressWarnings("deprecation")
	@Given("the user is in the request demo page {string} and {int}")
	public void the_user_is_in_the_request_demo_page_and(String SheetName, Integer row) throws InvalidFormatException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		Home a=new Home(driver);
	    a.enterRequestdemo();
	    RequestDemo r=new RequestDemo(driver);
	    startReport();
	    startTest();
	    
	    Thread.sleep(2000);
	    ExcelReader reader=new ExcelReader();
	    List<Map<String,String>> testdata=reader.getData("D:\\automation.xlsx",SheetName);
	    String email=testdata.get(row).get("email");
	    String fname=testdata.get(row).get("fname");
	    String lname=testdata.get(row).get("lname");
	    String company=testdata.get(row).get("company");
	    String phone=testdata.get(row).get("phone");
	    String country=testdata.get(row).get("country");
	    String role=testdata.get(row).get("role");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)", "");
	    r.enterEmail(email);
	    r.enterFname(fname);
	    r.enterLname(lname);
	    r.enterCompany(company);
	    r.enterPhone(phone);
	    r.selectCountry(country);
	    r.selectRole(role);
	    r.clickAgree();
	    
	    
	    r.enterrequestdemo();
	    takeScreenshot(driver);
	    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
 
	@When("he enters all details")
	public void he_enters_all_details() {
		boolean a=driver.findElement(By.xpath("//*[@class='ProductDemoFormTemplate_h4__zNlcM']")).isDisplayed();
		assertEquals(true,a);
	    
	}
 
 
	@Then("he submits the details")
	public void he_submits_the_details() {
		endTest();
		driver.quit();
		
	    
	}
}
