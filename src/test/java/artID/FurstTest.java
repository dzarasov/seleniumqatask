package artID;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FurstTest extends MainClassTestClass {
	
		
	
    @Test
    public void titleAssetion() {
    	try {
	    	MainPage mainPage = new MainPage(driver); 
	    	
	    	// Assert title on the main page
	        assertEquals(MainPage.expectedTitle, mainPage.mainPageTitle());
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }
    
    
    @Test
    public void validateCheckoutButtonWithEmptyFields() {
    	try {
    	MainPage mainPage = new MainPage(driver); 
    	
    	// Assert checkout button is enabled. This test should be failed
    	assertFalse(mainPage.checkoutButton().isEnabled());
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }
    
  
    @Test
    public void validateMainItems() {
    	try {
	        MainPage mainPage = new MainPage(driver); 
	    	
	        // Assert correct animals are presented
	        assertEquals(MainPage.expectedZebraValue, mainPage.arrOfAnimals(2)[0]);
	        assertEquals(MainPage.expectedLionValue, mainPage.arrOfAnimals(3)[0]);
	        assertEquals(MainPage.expectedElephantValue, mainPage.arrOfAnimals(4)[0]); 
	        assertEquals(MainPage.expectedGiraffeValue, mainPage.arrOfAnimals(5)[0]);
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }    
   
	
    @Test
    public void californiaTotalsTest(){
    	try{
	    	MainPage mainPage = new MainPage(driver);
	    	double[] dataValues = mainPage.pricesTotals(MainPage.CALITAXES);
	    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.CALISTATE);
	   
	    	assertEquals(dataValues[0], resultsPage.subtotalValueFromResultsPage());
	    	// Asserting total values
	    	
	    	assertEquals(dataValues[1], resultsPage.taxesValueFromResultsPage());
	    	// Asserting subtotal values
	    	
	    	assertEquals(dataValues[2], resultsPage.totalValueFromResultsPage());
	    	// Asserting percent values
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }
    
        
    @Test
    public void nyTestTotal(){
    	try{
	    	MainPage mainPage = new MainPage(driver);
	    	double[] dataValues = mainPage.pricesTotals(MainPage.NYTAXES);
	
	    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.NYSTATE);
	   
	    	assertEquals(dataValues[0], resultsPage.subtotalValueFromResultsPage());
	    	// Asserting total values
	    	
	    	assertEquals(dataValues[1], resultsPage.taxesValueFromResultsPage());
	    	// Asserting subtotal values
	    	
	    	assertEquals(dataValues[2], resultsPage.totalValueFromResultsPage());
	    	// Asserting percent values
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }
        
    
    @Test
    public void mnTestTotal(){
    	try{
	    	MainPage mainPage = new MainPage(driver);
	    	double[] dataValues = mainPage.pricesTotals(MainPage.MNTAXES);  	
	    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.MNSTATE);
	       	   
	    	assertEquals(dataValues[0], resultsPage.subtotalValueFromResultsPage());
	    	// Asserting total values
	    	
	    	assertEquals(dataValues[1], resultsPage.taxesValueFromResultsPage());
	    	// Asserting subtotal values
	    	
	    	assertEquals(dataValues[2], resultsPage.totalValueFromResultsPage());
	    	// Asserting percent values
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }
    
    
    @Test(dataProvider = "states")
    public void otherStateTestTotal(String state){
    	try{
	    	MainPage mainPage = new MainPage(driver);
	    	double[] dataValues = mainPage.pricesTotals(MainPage.OTHERSTATES);
	    	ResultsPage resultsPage = mainPage.navigateToResultsPage(state);
	    	
	    	assertEquals(dataValues[0], resultsPage.subtotalValueFromResultsPage());
	    	// Asserting total values
	    	
	    	assertEquals(dataValues[1], resultsPage.taxesValueFromResultsPage());
	    	// Asserting subtotal values
	    	
	    	assertEquals(dataValues[2], resultsPage.totalValueFromResultsPage());
	    	// Asserting percent values
    	}
    	catch (Exception e) {
    		Assert.fail();
		}
    }
}