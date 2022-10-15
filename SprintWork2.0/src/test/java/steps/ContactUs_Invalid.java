package steps;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ContactUs;
import pagefactory.Home;

import utilities.ExcelReader;
import utilities.ScreenshotGenerator;
@Test
public class ContactUs_Invalid extends ScreenshotGenerator{
	
	static WebDriver driver;

	
	@SuppressWarnings("deprecation")
	@Given("The user views the contact page {string} and {int}")
	public void the_user_views_the_contact_page_and(String SheetName, Integer row) throws InvalidFormatException, IOException, InterruptedException {
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	    driver=new ChromeDriver();
	    Home a=new Home(driver);
	    a.entercontactus();
	    startTest();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    ContactUs c=new ContactUs(driver);
	    Thread.sleep(3000);
	    ExcelReader reader=new ExcelReader();
	    List<Map<String,String>> testdata=reader.getData("D:\\capgemini\\automation.xlsx",SheetName);
	    String reason=testdata.get(row).get("reason");
	    String fname=testdata.get(row).get("fname");
	    String lname=testdata.get(row).get("lname");
	    String country=testdata.get(row).get("country");
	    String phone=testdata.get(row).get("phone");
	    String company=testdata.get(row).get("company");
	    String email=testdata.get(row).get("email");
	    String role=testdata.get(row).get("role");
	    String interest=testdata.get(row).get("interest");
	    String message=testdata.get(row).get("message");
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    //js.executeScript("window.scrollBy(0,350)", "");
	    c.reason(reason);
	    c.fname(fname);
	    c.lname(lname);
	    c.country(country);
	    c.phone(phone);
	    c.company(company);
	    js.executeScript("window.scrollBy(0,550)", "");
	    c.email(email);
	    c.role(role);
	    c.interest(interest);
	    c.message(message);
	    
	    c.agree();
	    takeScreenshot(driver);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Contact_Me_Details__c")));
	    c.clickcontactus();
	    takeScreenshot(driver);
	    Thread.sleep(4000);
	    
	}
	
	
	@When("he enters invalid details")
	public void he_enters_invalid_details() throws InterruptedException {
		
		String a="Contact us - Tricentis";
	    assertEquals(true,a.equals(driver.getTitle()));
	}
	@Then("He submits the contact details")
	public void He_submits_the_contact_details() {
	    endTest();
	    endReport();
	    driver.close();
	}


}
