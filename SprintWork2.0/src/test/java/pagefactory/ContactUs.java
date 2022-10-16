package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
	WebDriver driver;

	@FindBy(id="FirstName")
	WebElement fname;
	
	@FindBy(id="LastName")
	WebElement lname;
	
	@FindBy(id="Phone")
	WebElement Phone;
	

	@FindBy(id="Company")
	WebElement Company;
	
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Contact_Me_Details__c")
	WebElement contact;

	@FindBy(id="emailOptin")
	WebElement emailOptin;
	
	@FindBy(xpath="//*[@class='mktoButton']")
	WebElement submit;
	
	
public ContactUs(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
		
}
	

public void reason(String s)
{
	Select a=new Select(driver.findElement(By.id("Reason_for_contacting__c")));
	a.selectByVisibleText(s);
}

public void fname(String s)
{
	fname.sendKeys(s);
}

public void lname(String s)
{
	lname.sendKeys(s);
}

public void country(String s)
{
	Select a=new Select(driver.findElement(By.id("Country")));
	a.selectByVisibleText(s);
}

public void phone(String s)
{
	Phone.sendKeys(s);
}

public void company(String s)
{
	Company.sendKeys(s);
}

public void email(String s)
{
	Email.sendKeys(s);
}

public void role(String s)
{
	Select a=new Select(driver.findElement(By.id("Role__c")));
	a.selectByVisibleText(s);
}

public void interest(String s)
{
	Select a=new Select(driver.findElement(By.id("Interested_in_Learning_About__c")));
	a.selectByVisibleText(s);
}

public void message(String s)
{
	contact.sendKeys(s);
}

public void clickAgree(int s) throws InterruptedException
{
	if(s==1)
	{
		emailOptin.click();
	}
	Thread.sleep(500);
}

public void clickContactUs()
{
	submit.click();;
}

}
