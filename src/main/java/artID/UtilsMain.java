package artID;

import java.io.File; 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.OutputType; 
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtilsMain {

	public static void takeAScreenshot(WebDriver driver) throws IOException{
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		System.out.println("Find your screen here: "+ "/Users/mikhaildzarasov/Desktop/"+name+timeStamp);
		FileUtils.copyFile(scrFile, new File("/Users/mikhaildzarasov/Desktop/"+ name + timeStamp +".jpg")); 
	}
}

