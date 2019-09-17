package org.shl.testng.Flipcart;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import page.HomePage;
import utilities.Constants;
import utilities.Launcher;
import utilities.Product;

public class TestScript {
    Launcher Launch=new Launcher();
    HomePage Home;
   
    WebDriver Driver;
  @BeforeMethod
  public void Launch_Browser() throws Exception 
  {
      Launch.launchBrowser("Chrome");
      Driver=Launch.Go_To_Url(Constants.URL);
      
  }
  
  @Test
  public void Login()
  {
     Home=new HomePage(Driver);
     Home.closeLoginWindow();
     Driver= Home.search();
     Product  p=new Product(Driver);
     p.view();
  }
  
  @AfterMethod
  public void Close_Browser()
  {
      Driver.quit();
  }
}
