package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.ContactUs;
import pagefactory.Home;
import utilities.ExcelReader;
import utilities.ScreenshotGenerator;
@Test
public class ContactUs_Valid extends ScreenshotGenerator{
	static WebDriver driver;
	String reason,fname,lname,country,phone,company,email,role,interest,message,agree;
	
	@Given("The person views the contact page {string} and {int}")
	public void the_person_views_the_contact_page_and(String SheetName, Integer row) throws InvalidFormatException, IOException {
		System.setProperty("Webdriver.chrome.driver","chromedriver.exe");
	     driver=new ChromeDriver();
	     Home a=new Home(driver);
	    a.enterContactUs();
	    
	    startTest();
	    
	
	    ExcelReader reader=new ExcelReader();
	    List<Map<String,String>> testdata=reader.getData("D:\\capgemini\\automation.xlsx",SheetName);
	     reason=testdata.get(row).get("reason");
	     fname=testdata.get(row).get("fname");
	     lname=testdata.get(row).get("lname");
	     country=testdata.get(row).get("country");
	     phone=testdata.get(row).get("phone");
	     company=testdata.get(row).get("company");
	     email=testdata.get(row).get("email");
	     role=testdata.get(row).get("role");
	     interest=testdata.get(row).get("interest");
	     message=testdata.get(row).get("message");
	     agree=testdata.get(row).get("agree");
	}
	
	@When("He gives the valid details")
	public void he_gives_the_valid_details() throws InterruptedException, IOException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)", "");
	    ContactUs c=new ContactUs(driver);
	    c.reason(reason);
	    c.fname(fname);
	    c.lname(lname);
	    c.country(country);
	    c.phone(phone);
	    c.company(company);
	    
	    
	    js.executeScript("window.scrollBy(0,400)", "");
	    c.email(email);
	    c.role(role);
	    c.interest(interest);
	    c.message(message);
	    
	    c.clickAgree(Integer.valueOf(agree));
	    takeScreenshot(driver);
	   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Contact_Me_Details__c")));
	}
	
	@Then("He submits the valid contact details")
	public void he_submits_the_valid_contact_details() throws InterruptedException, IOException {
		ContactUs c=new ContactUs(driver);
		c.clickContactUs();
	    takeScreenshot(driver);
	    Thread.sleep(4000);
	    
		String a="Thank you - Tricentis";
		
	    Assert.assertEquals(true,a.equals(driver.getTitle()));
	    endTest();
	    driver.close();
	}
	
	
	
}
