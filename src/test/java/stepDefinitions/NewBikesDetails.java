package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.HomePage;
import pageObjects.UpcomingBikesPage;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewBikesDetails {
	WebDriver driver;
	HomePage hm;
	UpcomingBikesPage ubp;
	
		
		@Given("user navigates to ZigWheels page")
		public void user_navigates_to_zig_wheels_page() {
			BaseClass.getLogger().info("Navigated to ZigWheels");
			hm=new HomePage(BaseClass.getDriver());
			
		   
		}
		
		@When("user hovers to Newbikes toggle")
		public void user_hovers_to_newbikes_toggle() {
			BaseClass.getLogger().info("Navigated to NewBikes");
			hm=new HomePage(BaseClass.getDriver());
			hm.moveToNewBikes();
		
		}
		
		@When("user clicks on Upcoming bikes")
		public void user_clicks_on_upcoming_bikes() {
			hm=new HomePage(BaseClass.getDriver());
			hm.clickOnUpcomingBikes();
			BaseClass.getLogger().info("Clicked on Upcoming bikes");
		}
		
		@When("chooses manufacturer as Honda")
		public void chooses_manufacturer_as_honda() {
		 ubp= new UpcomingBikesPage(BaseClass.getDriver());
		 ubp.selectManufacturer();
		 BaseClass.getLogger().info("Honda as manufacturer is selected ");
		}
		
		@Then("All the upcomings bikes of Honda manufacturer are displayed")
		public void all_the_upcomings_of_honda_manufacturer_are_displayed() {
			 ubp= new UpcomingBikesPage(BaseClass.getDriver());
			 ubp.clickViewMore();
			List<WebElement> modelName= ubp.listOfModels();
			List<WebElement> price= ubp.priceOfModels();
			List<WebElement> expectedDate= ubp.expectedDateOfRelease();
			
			 for(int i=0;i<modelName.size();i++) {
		    	 
				   String temp=price.get(i).getText();
				   if(!temp.contains("Lakh"))
				   {
					   System.out.println(modelName.get(i).getText()+"    "+price.get(i).getText()+"   "+expectedDate.get(i).getText());
				   }
				   else if(temp.contains("Lakh"))	 
				   {
					   double p=Double.parseDouble(temp.substring(temp.indexOf("Rs")+4,temp.indexOf("Lakh")-1));
				    	if(p<=4.00) {
				    		System.out.println(modelName.get(i).getText()+"    "+price.get(i).getText()+"   "+expectedDate.get(i).getText());
				    		     }
				   	}
			 }
		}


}
