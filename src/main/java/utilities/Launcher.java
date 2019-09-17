package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launcher {
WebDriver driver;
	
	public void launchBrowser(String BrowserName) throws Exception {
		switch(BrowserName) {
		case  "Chrome": WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
		case  "Firefox": WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver(); 
		break;
		case  "IExplorer": WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();
		break;
		default : 
			throw new Exception("pass valid browser name");
		}
		driver.manage().window().maximize();	
		
}
public WebDriver Go_To_Url(String URL) {
	driver.get(URL);
	return driver;
}
}
