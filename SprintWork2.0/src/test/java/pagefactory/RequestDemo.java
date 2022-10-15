package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RequestDemo {
	WebDriver driver;

	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="Phone")
	WebElement Phone;
	
	@FindBy(id="Company")
	WebElement Company;
	
	@FindBy(id="emailOptin")
	WebElement emailOptin;
	
	@FindBy(xpath="//*[@class='mktoButton']")
	WebElement submit;
	
	
	public RequestDemo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterEmail(String s)
	{
		Email.sendKeys(s);
	}
	
	
	public void enterFname(String s)
	{
		FirstName.sendKeys(s);
	}
	
	
	public void enterLname(String s)
	{
		LastName.sendKeys(s);
	}
	

	public void enterPhone(String s)
	{
		Phone.sendKeys(s);
	}
	

	public void enterCompany(String s)
	{
		Company.sendKeys(s);
	}
	

	public void selectCountry(String s)
	{
		Select a=new Select(driver.findElement(By.xpath("//*[@id='Country']")));
		a.selectByVisibleText(s);
	}

	public void selectRole(String s)
	{
		Select a=new Select(driver.findElement(By.id("Role__c")));
		a.selectByVisibleText(s);
	}
	

	public void clickAgree(int s) throws InterruptedException
	{
		if(s==1) {
		emailOptin.click();
		}
		Thread.sleep(2000);
	}
	
	
	public void enterrequestdemo()
	{
		submit.click();
	}
	
	
}
