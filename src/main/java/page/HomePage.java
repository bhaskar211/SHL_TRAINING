package page;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.Constants;

public class HomePage extends BaseClass {
	WebDriver Driver;
	@FindBy(xpath="//button[text()='✕']")
	WebElement quit;
	
	@FindBy(xpath="//input[@class=\"LM6RPg\"]")
	WebElement search;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement enter;
	
	

	public HomePage(WebDriver Driver)
	{
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}

	public void closeLoginWindow() {
		click(quit);

	}
	
	public WebDriver search() {
	
		click(search);
		sendValue(search, Constants.PRODUCT);
		click(enter);
		
		return Driver;
		
	}





}
