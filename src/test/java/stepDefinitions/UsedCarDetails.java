package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.UsedCarspage;

public class UsedCarDetails {
	WebDriver driver;
	HomePage hp;
	UsedCarspage ucp;
		
		@When("user hovers to Used cars toggle")
		public void user_hovers_to_used_cars_toggle() {
		 hp=new HomePage(BaseClass.getDriver());
		 hp.moveToUsedCars();
		}
		
		@When("user clicks on Chennai as preferd location")
		public void user_clicks_on_chennai_as_preferd_location() {
			 hp=new HomePage(BaseClass.getDriver());
			 hp.selectCity();
		}
		
		@Then("All the popular car modles list will be diplayed")
		public void all_the_popular_car_modles_list_will_be_diplayed() {
		  ucp =new UsedCarspage(BaseClass.getDriver());
		  List<WebElement>popularCars=ucp.ListOfPopularcars();
		  for(WebElement x:popularCars) {
			  System.out.println(x.getText());
		  }
		}

}
