package artID;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage {
	
	WebDriver driver;
	
	public static final String expectedTitle = "JungleSocks";
	public static final String expectedZebraValue = "zebra";
	public static final String expectedLionValue = "lion";
	public static final String expectedElephantValue = "elephant";
	public static final String expectedGiraffeValue = "giraffe";
	public static final String ZEBRAID = "line_item_quantity_zebra";
	public static final String LIONID = "line_item_quantity_lion";
	public static final String ELEPHID = "line_item_quantity_elephant";
	public static final String GIRAFFID = "line_item_quantity_giraffe";
	
	public static final double CALITAXES = 0.08;
	public static final double NYTAXES = 0.06;
	public static final double MNTAXES = 0;
	public static final double OTHERSTATES = 0.05;
	
	public static final String CALISTATE = "California";
	public static final String NYSTATE = "New York";
	public static final String MNSTATE = "Minnesota";
	public static final String OREGONSTATE = "Oregon";
		
	
	public MainPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String mainPageTitle(){
		String titleFromPage = driver.getTitle();
		return titleFromPage;
	}
	
	public WebElement checkoutButton(){
        WebElement checkoutButton = driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]"));
        return checkoutButton;
	}
	
	public String[] arrOfAnimals(int index){
        WebElement elements = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr["+ index +"]"));
        String[] arrFromElements = elements.getText().split(" ");
        return arrFromElements;
	}
	

	public int getTotalPrice(String animalID, int value, int inStockNum, int orderNum){
		int totalFromAnimal = 0;
		WebElement inputField = driver.findElement(By.id(animalID));

		if(inStockNum>orderNum){
			inputField.clear();
			inputField.sendKeys(Integer.toString(orderNum));
			totalFromAnimal = totalFromAnimal + value;
			totalFromAnimal = totalFromAnimal * orderNum;
			return totalFromAnimal;
		}
		else if(inStockNum<=orderNum){
			inputField.sendKeys(Integer.toString(inStockNum));
			totalFromAnimal = totalFromAnimal + value;
			totalFromAnimal = totalFromAnimal * inStockNum;
			return totalFromAnimal;
		}
		return totalFromAnimal;
	}
	
	public ResultsPage navigateToResultsPage(String state){
		selectStateValue(state);
		checkoutButton().click();
		return new ResultsPage(driver);
	}
	
	public void selectStateValue(String state){
		new Select (driver.findElement(By.name("state"))).selectByVisibleText(state);
	}
	
	public Map<String, Integer[]> priceAndQuantity(){
		
		Map<String, Integer[]> map = new HashedMap();
		
    	String priceValueFromZebra = arrOfAnimals(2)[1];
    	// Price value from Zebra
    	int inStockValueFromZebra = Integer.parseInt(arrOfAnimals(2)[2]);
    	// InStock number from Zebra
    	String priceValueFromLion = arrOfAnimals(3)[1];
    	// Price value from Lion
    	int inStockValueFromLion = Integer.parseInt(arrOfAnimals(3)[2]);
    	// InStock number from Lion
    	String priceValueFromElepgh = arrOfAnimals(4)[1];
    	// Price value from Lion
    	int inStockValueFromEleph = Integer.parseInt(arrOfAnimals(4)[2]);
    	// InStock number from Lion   
    	String priceValueFromGiraff = arrOfAnimals(5)[1];
    	// Price value from Lion
    	int inStockValueFromGiraff = Integer.parseInt(arrOfAnimals(5)[2]);
    	// InStock number from Lion
		
    	Integer[] zebraArr = new Integer[2];
    	zebraArr[0]=Integer.parseInt(priceValueFromZebra);
    	zebraArr[1]=inStockValueFromZebra;	

    	Integer[] lionArr = new Integer[2];
    	lionArr[0]=Integer.parseInt(priceValueFromLion);
    	lionArr[1]=inStockValueFromLion;
    	
    	Integer[] elephArr = new Integer[2];
    	elephArr[0]=Integer.parseInt(priceValueFromElepgh);
    	elephArr[1]=inStockValueFromEleph;
    	
    	Integer[] giraffArr = new Integer[2];
    	giraffArr[0]=Integer.parseInt(priceValueFromGiraff);
    	giraffArr[1]=inStockValueFromGiraff;
    	
    	map.put(expectedZebraValue, zebraArr);
    	map.put(expectedLionValue, lionArr);
    	map.put(expectedElephantValue, elephArr);
    	map.put(expectedGiraffeValue, giraffArr);
    	
    	return map;
	}
	
	
	public double[] pricesTotals(double state){
		
		double [] totals = new double[3];
		
    	int zebraTotalPrice = getTotalPrice(MainPage.ZEBRAID, priceAndQuantity().get(MainPage.expectedZebraValue)[0],   priceAndQuantity().get(MainPage.expectedZebraValue)[1], 1);
    	int lionTotalPrice  = getTotalPrice(MainPage.LIONID,  priceAndQuantity().get(MainPage.expectedLionValue)[0],    priceAndQuantity().get(MainPage.expectedLionValue)[1], 1);
    	int elephTotalPrice = getTotalPrice(MainPage.ELEPHID, priceAndQuantity().get(MainPage.expectedElephantValue)[0],priceAndQuantity().get(MainPage.expectedElephantValue)[1], 1);
    	int giraffTotalPrice= getTotalPrice(MainPage.GIRAFFID,priceAndQuantity().get(MainPage.expectedGiraffeValue)[0], priceAndQuantity().get(MainPage.expectedGiraffeValue)[1], 1);

    	double subtotalPrice = zebraTotalPrice + lionTotalPrice + elephTotalPrice + giraffTotalPrice;
    	double percentage = subtotalPrice * state;
    	double total = subtotalPrice + percentage;
    	
    	totals[0]=subtotalPrice;
    	totals[1]=percentage;
    	totals[2]=total;
    	
    	return totals;	
	}
	

	
	

}
