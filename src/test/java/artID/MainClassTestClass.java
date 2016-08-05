package artID;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.ITestResult; 


public class MainClassTestClass {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeClass
    public void setup(){
  	  System.setProperty("webdriver.chrome.driver", "chromedriver");
  	  this.driver = new ChromeDriver();
    }
    
    @BeforeMethod
    public void navigateToUrl(){
		this.driver.get("https://jungle-socks.herokuapp.com/");
    }
    
	   @DataProvider(name = "states")
	   public static Object[][] primeNumbers() {
	      return new Object[][] {{MainPage.OREGONSTATE},{"Alabama"},{"Alaska"},{"Texas"}};
	   }
    
    @AfterMethod
    public void afterMethodExecution(ITestResult testResult) throws IOException{
    	if (testResult.getStatus() == ITestResult.FAILURE) { 
    		UtilsMain.takeAScreenshot(driver);
    		} 
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}
