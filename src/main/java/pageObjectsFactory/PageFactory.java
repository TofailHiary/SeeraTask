package pageObjectsFactory;

import general.manager.DriverManager;
import general.manager.PropertiesManager;
import org.openqa.selenium.WebDriver;

import Seera.pages.FlightsPage;
import Seera.pages.HomePage;

import java.util.Properties;


public class PageFactory {

    public static Properties props = new Properties();
    public static Properties localeProps = new Properties();
 
    public static Properties extentReportProps = new Properties();
  
    private static PageFactory _pageFactory;
    private HomePage _homePage;
    private FlightsPage _flightsPage;
    public PageFactory(){
        initWebDriver();

    }

	public void initWebDriver() {
	this.setProps(PropertiesManager.getProperties());
    DriverManager.getDriver(props.getProperty("browserValue"));
       
	}




    public static PageFactory instance(){
        if (_pageFactory == null) {
            _pageFactory = new PageFactory();
        }
        return _pageFactory;
    }


    
    public HomePage homepage() {
     
        	_homePage = new HomePage(getWebDriver());     
        return _homePage;
    }

    public FlightsPage flightsPage() {
        
    	_flightsPage = new FlightsPage(getWebDriver());     
    return _flightsPage;
}

    public WebDriver getWebDriver() {
        return DriverManager.getInstance();
    }

    

    public void setProps(Properties props) {
        this.props = props;
    }

    public Properties getProps() {
        return props;
    }



	public void closeDriver() throws InterruptedException {
		DriverManager.closeDriver();
		
	}

 




}
