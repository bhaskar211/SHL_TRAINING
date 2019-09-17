package utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    WebDriverWait wait;
    
    
	public void sendValue(WebElement Element,String TextToEnter) {
		
		Element.sendKeys(TextToEnter);
	}
    
	public void click(WebElement Element)
	{
		Element.click();
	}
	public void clear(WebElement Element) {
		Element.clear();
	}
	    
}
