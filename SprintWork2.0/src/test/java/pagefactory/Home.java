package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@SuppressWarnings("unused")
public class Home {
	WebDriver driver;
	WebElement requestdemo,resources;
	
	

	public Home(WebDriver driver)
	{
		this.driver=driver;
		
	}

	public void enterRequestdemo()
	{
		driver.get("https://www.tricentis.com/software-testing-tool-trial-demo/demo-request");
	}
	
	public void entercontactus()
	{
		driver.get("https://www.tricentis.com/contact-us");
	}
}
