package artID;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FurstTest extends MainClassTestClass {
	
    @Test(priority=0)
    public void titleAssetion() {
    	MainPage mainPage = new MainPage(driver);  
        Assert.assertEquals(MainPage.expectedTitle, mainPage.mainPageTitle());
    }
    
    
    @Test(priority=1)
    public void validateCheckoutButtonWithEmptyFields() {
    	MainPage mainPage = new MainPage(driver); 
    	Assert.assertTrue(mainPage.checkoutButton().isEnabled());        
    }
    
  
    @Test(priority=2)
    public void validateMainItems() {
        MainPage mainPage = new MainPage(driver); 
    	
        Assert.assertEquals(MainPage.expectedZebraValue, mainPage.arrOfAnimals(2)[0]);
        Assert.assertEquals(MainPage.expectedLionValue, mainPage.arrOfAnimals(3)[0]);
        Assert.assertEquals(MainPage.expectedElephantValue, mainPage.arrOfAnimals(4)[0]); 
        Assert.assertEquals(MainPage.expectedGiraffeValue, mainPage.arrOfAnimals(5)[0]);    
    }    
    
	
    @Test(priority=3)
    public void californiaTotalsTest(){
    	MainPage mainPage = new MainPage(driver);
    	double totals = mainPage.pricesTotals(MainPage.CALITAXES)[0];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.CALISTATE);
   
    	Assert.assertEquals(totals, resultsPage.subtotalValueFromResultsPage());
    }
    
    
    @Test(priority=4)
    public void californiaSubTotalsTest(){
    	MainPage mainPage = new MainPage(driver);
    	double subTotals = mainPage.pricesTotals(MainPage.CALITAXES)[1];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.CALISTATE);
   
    	Assert.assertEquals(subTotals, resultsPage.taxesValueFromResultsPage());
    }
    
    
    @Test(priority=5)
    public void californiaPercentsTest(){
    	MainPage mainPage = new MainPage(driver);
    	double percents = mainPage.pricesTotals(MainPage.CALITAXES)[2];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.CALISTATE);
   
    	Assert.assertEquals(percents, resultsPage.totalValueFromResultsPage());
    }
    
    
    @Test(priority=6)
    public void nyTestTotal(){
    	MainPage mainPage = new MainPage(driver);
    	double totals = mainPage.pricesTotals(MainPage.NYTAXES)[0];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.NYSTATE);
   
    	Assert.assertEquals(totals, resultsPage.subtotalValueFromResultsPage());
    }
    
    
    @Test(priority=7)
    public void nyTestSubTotal(){
    	MainPage mainPage = new MainPage(driver);
     	double subTotals = mainPage.pricesTotals(MainPage.NYTAXES)[1];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.NYSTATE);
   
    	Assert.assertEquals(subTotals, resultsPage.taxesValueFromResultsPage());
    }
    
    
    @Test(priority=8)
    public void nyTestPercent(){
    	MainPage mainPage = new MainPage(driver);
    	double percents = mainPage.pricesTotals(MainPage.NYTAXES)[2];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.NYSTATE);

    	Assert.assertEquals(percents, resultsPage.totalValueFromResultsPage());
    }
   
    
    @Test(priority=9)
    public void mnTestTotal(){
    	MainPage mainPage = new MainPage(driver);
    	double totals = mainPage.pricesTotals(MainPage.MNTAXES)[0];  	
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.MNSTATE);
   
    	Assert.assertEquals(totals, resultsPage.subtotalValueFromResultsPage());
    }
    
    
    @Test(priority=10)
    public void mnTestSubTotal(){
    	MainPage mainPage = new MainPage(driver);
     	double subTotals = mainPage.pricesTotals(MainPage.MNTAXES)[1];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.MNSTATE);
   
    	Assert.assertEquals(subTotals, resultsPage.taxesValueFromResultsPage());
    }
    
    
    @Test(priority=11)
    public void mnTestPercent(){
    	MainPage mainPage = new MainPage(driver);
    	double percents = mainPage.pricesTotals(MainPage.MNTAXES)[2];   	
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.MNSTATE);

    	Assert.assertEquals(percents, resultsPage.totalValueFromResultsPage());
    }
    
   
    @Test(priority=12)
    public void otherStateTestTotal(){
    	MainPage mainPage = new MainPage(driver);
    	double totals = mainPage.pricesTotals(MainPage.OTHERSTATES)[0];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.OREGONSTATE);
    	
    	Assert.assertEquals(totals, resultsPage.subtotalValueFromResultsPage());
    }
    
    
    @Test(priority=13)
    public void otherStateTestSubTotal(){
    	MainPage mainPage = new MainPage(driver);
     	double subTotals = mainPage.pricesTotals(MainPage.OTHERSTATES)[1];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.OREGONSTATE);
    	
    	Assert.assertEquals(subTotals, resultsPage.taxesValueFromResultsPage());
    }
    
    
    @Test(priority=14)
    public void otherStatePercent(){
    	MainPage mainPage = new MainPage(driver);
    	double percents = mainPage.pricesTotals(MainPage.OTHERSTATES)[2];
    	ResultsPage resultsPage = mainPage.navigateToResultsPage(MainPage.OREGONSTATE);

    	Assert.assertEquals(percents, resultsPage.totalValueFromResultsPage());
    }
    
}


