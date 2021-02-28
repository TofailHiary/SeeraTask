package Seera.pages;

import general.manager.DriverManager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

import java.util.Random;

public class FlightsPage extends DriverManager {

	static String[] origin = { "DXB", "AUH", "SHJ", "JED", "RUH" };
	static String[] destination = { "AMM", "CAI", "DEL", "KHI", "PAR" };
	static String random = "";

	public FlightsPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[@id='uncontrolled-tab-example-tab-flights']")
	protected WebElement flightPage;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
	protected WebElement originfield;

	@FindBy(css = "[data-testid='FlightSearchBox__ToAirportInput']")

	protected WebElement destinationfield;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]")
	protected WebElement fromDate;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]")
	protected WebElement toDate;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[7]/span[1]")
	protected WebElement selectFromDate;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[7]")
	protected WebElement selectToDate;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
	protected WebElement Passengers;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]")
	protected WebElement selectPassengers;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
	protected WebElement Cabin_Class;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
	protected WebElement selectCabin_Class;

	@FindBy(xpath = "//body/div[@id='__next']/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
	protected WebElement searchFlight;

	@FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[2]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")
	protected WebElement selectFlight;

	@FindBy(xpath = "//body/div[@id='root']/div[3]/div[1]/div[2]/div[2]/div[3]/div[1]/button[1]/div[1]")
	protected WebElement sortPrice;

	@FindBy(xpath = "//div[@data-testid='Group0__PriceLabel']")
	protected WebElement firstPrice;

	@FindBy(xpath = "//DIV[@data-testid='Collapsed_PriceFilter']")
	protected WebElement priceFilter;

	@FindBy(xpath = "//span[@data-testid='FlightSearchResult__PriceFilter__Min']")
	protected WebElement priceFilterValue;

	/*
	 * defining element completed here
	 */

	/*
	 * to select flight page in case not selected
	 */
	public void openFlightsPage() {
		flightPage.click();
		waitUntilPageIsLoadded();
	}

	/*
	 * this to fill all search field and check the search
	 */

	public void fillSearchCriteria() {
		waitUntilPageIsLoadded();
		waitUntilElemnetIsVisible(destinationfield);
		String origin = getRandom("origin");
		String dest = getRandom("destination");
		originfield.sendKeys(origin);
		originfield.sendKeys(Keys.ENTER);
		waitUntilPageIsLoadded();
		waitUntilElemnetIsVisible(destinationfield);
		destinationfield.sendKeys(dest);
		//waitUntilElemnetIsVisible(destinationfield);
		destinationfield.sendKeys(Keys.ENTER);
		fromDate.click();
		selectFromDate.click();
		selectToDate.click();
		//flightPage.click();
		Passengers.click();
		assertTrue(selectPassengers.getText().equalsIgnoreCase("1"));
		flightPage.click();
		Cabin_Class.click();
		selectCabin_Class.click();
		searchFlight.click();
		waitUntilPageIsLoadded();
		sortPrice.click();
		waitUntilPageIsLoadded();
	}

	/*
	 * this method to check the price sorting appear based on the price filter
	 */
	public boolean checkPriceWithFilter() {
		waitUntilPageIsLoadded();
		waitUntilElemnetIsClickable(priceFilter);
		String price = firstPrice.getText();
		priceFilter.click();
		String filterPrice = priceFilterValue.getText();
		assertTrue(filterPrice.contains(price));
		return true;

	}

	public static String getRandom(String type) {
		if (type.contentEquals("origin")) {
			int idx = new Random().nextInt(origin.length);
			random = (origin[idx]).toString();
		} else {

			int idx = new Random().nextInt(destination.length);
			random = (destination[idx]);
		}
		return random;

	}

}
