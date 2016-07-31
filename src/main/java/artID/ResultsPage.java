package artID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {
	
	WebDriver driver;
	
	public ResultsPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public double subtotalValueFromResultsPage(){
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		WebElement subtotal = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("subtotal")));
		System.out.println("SUBTOTAL IS: "+ Double.parseDouble(subtotal.getText().substring(1, subtotal.getText().length())));
		return Double.parseDouble(subtotal.getText().substring(1, subtotal.getText().length()));
	}
	
	
	public double totalValueFromResultsPage(){
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		WebElement subtotal = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("total")));
		System.out.println("SUBTOTAL IS: "+ Double.parseDouble(subtotal.getText().substring(1, subtotal.getText().length())));
		return Double.parseDouble(subtotal.getText().substring(1, subtotal.getText().length()));
	}
	
	
	public double taxesValueFromResultsPage(){
		WebDriverWait wait = new WebDriverWait(driver, 30000);
		WebElement subtotal = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("taxes")));
		System.out.println("SUBTOTAL IS: "+ Double.parseDouble(subtotal.getText().substring(1, subtotal.getText().length())));
		return Double.parseDouble(subtotal.getText().substring(1, subtotal.getText().length()));
	}
	
	

}
