package Steps.Seera;

import Seera.pages.FlightsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjectsFactory.PageFactory;
import static org.junit.Assert.assertTrue;

public class Stepdefs {

	
	/*
	 * steps definition page created to be mapped with page for each step ,
	 * i have gather the scenario in only one step because the scenario is not complex and it  could be covered in steps page  
	 * The scenario I want to open home page will open the website based on url provided in the props file and ensure the website in english language 
	 * incase the website in arabic will changed to English language and check if its changed propelry   
	 */


	@Given("^I want to open home page$")
	public void navgatetoHomePageAndCheckingLanguage() {
		PageFactory.instance().homepage().openHomePage();
		assertTrue(PageFactory.instance().homepage().checkingHomePageLanguage());
	}

	/*
	 *This will be navigate to flights page and try to test the search functionality as smoke test   
	 */
	@When("^Navigate to flights page and fill search criteria$")
	public void navigatetoFlightsPage() {
		PageFactory.instance().flightsPage().openFlightsPage();
		PageFactory.instance().flightsPage().fillSearchCriteria();
		assertTrue(FlightsPage.getInstance().getCurrentUrl().contains("1Adult"));
	}
	/*
	 *This will check if the prices sorted properly and the prcie filter match the first result price 
	 */
	@When("^Check if price sortion and price filter value$")
	public void checkPricing() {

	assertTrue(PageFactory.instance().flightsPage().checkPriceWithFilter());;
	}



}
