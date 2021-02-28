package general.manager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Tofail Al-Hiary on 2/28/2021.
 */
public class DriverManager {

	private static WebDriver localDriver = null;
	protected static int timeOut = 30;
	public static WebDriverWait waitFor;
	public static Actions builder;
	public static Properties props = new Properties();

	public DriverManager(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	/*
	 * this function created to retrieve  local driver 
	 * 
	 */
	public static WebDriver getDriver(String browser) {
		if (localDriver == null) {
			setWebDriver(createInstance(browser));
		}
		return localDriver;
	}

	/*
	 * this function created to get instance from driver  
	 * 
	 */
	public static WebDriver getInstance() {
		if (localDriver != null) {
			return localDriver;
		}
		return null;

	}
	
	/*
	 * this function will create instance based on the name of the browser added in props file 
	 * 
	 */

	public static WebDriver createInstance(String browserName) {
		WebDriver driver;

		switch (browserName.toUpperCase()) {
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "drivers/windows/fireFox/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			;
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", "drivers/windows/IE/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			
			break;
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "drivers/windows/chrome/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "EDGE":
			System.setProperty("webdriver.edge.driver", "drivers/windows/edge/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "drivers/windows/chrome/chromedriver.exe");
			driver = new ChromeDriver();

			break;
		}
		waitFor = new WebDriverWait(driver, timeOut);
		builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver + "has been opened");
		return driver;
	}

	public static void setWebDriver(WebDriver driver) {
		if (driver != null) {
			localDriver = driver;
		}

	}

	public static void closeDriver() throws InterruptedException {
		if (localDriver != null) {
			localDriver.quit();
			localDriver = null;
		

		}

	}

	
	/*
	 * this functions help you in case you need wait for specific element 
	 * 
	 */
	public void waitUntilElemnetIsClickable(WebElement elemnet) {
		waitFor.until(ExpectedConditions.elementToBeClickable(elemnet));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}

	public void waitUntilElemnetIsVisible(WebElement elemnet) {
		waitFor.until(ExpectedConditions.visibilityOf(elemnet));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}

	}

	public void waitUntilPageIsLoadded() {
		new WebDriverWait(pageObjectsFactory.PageFactory.instance().getWebDriver(), timeOut)
				.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
						.equals("complete"));
	}

	public void waitUntilElementIsInvisible(WebElement element) {
		waitFor.until(ExpectedConditions.invisibilityOf(element));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}
	
	/*
	 * this function is static wait function used in specific cases and not recommended to use in case you follow best bractises 
	 * 
	 */

	public void timetowait(int num) {
		try {
			long seconds = TimeUnit.SECONDS.toMillis(num);
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
