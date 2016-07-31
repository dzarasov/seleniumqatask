package artID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class MainClassTestClass {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void setup(){
  	  System.setProperty("webdriver.chrome.driver", "/Users/mikhaildzarasov/Desktop/chromedriver");
  	  this.driver = new ChromeDriver();
    }
    
    @BeforeMethod
    public void navigateToUrl(){
		this.driver.get("https://jungle-socks.herokuapp.com/");
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
