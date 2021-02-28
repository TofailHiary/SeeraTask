package Seera.pages;

import general.manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Seera.pages.HomePage;
import pageObjectsFactory.PageFactory;

import static org.junit.Assert.assertTrue;

public class HomePage extends DriverManager {

	String expectedPageTitle = "Book Cheap Flights, Airline Tickets and Hotels Online at tajawal";

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "[data-testid='Header__LanguageSwitch']")
	protected WebElement lang;

	public void openHomePage() {

		String url = PageFactory.props.getProperty("env");
		getDriver(props.getProperty(url));
		PageFactory.instance().getWebDriver().get(url);
		waitUntilElemnetIsClickable(lang);

	}

	public boolean  checkingHomePageLanguage() {
	

		if (PageFactory.instance().getWebDriver().getCurrentUrl().contains("ar")) {
			lang.click();	
			waitUntilPageIsLoadded();
		} 
		assertTrue(PageFactory.instance().getWebDriver().getCurrentUrl().contains("en"));
	
return true;
	}

}
