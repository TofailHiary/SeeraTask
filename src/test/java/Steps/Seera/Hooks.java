package Steps.Seera;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import general.manager.DriverManager;
import io.qameta.allure.Allure;
import pageObjectsFactory.PageFactory;

public class Hooks {

	/*
	 *This class is the hooks clase contain before and after annotation to open and close browser after each senario  
	 */
	@Before
	public void beforeAll(Scenario Scenario) {
		System.out.println("Scenario " + Scenario.getName() + " has been started");
		DriverManager.getDriver(PageFactory.instance().getProps().getProperty("browserValue"));
	}
	
	
	
	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed with attached screen shot 
	 */
	public void embedScreenshot(Scenario scenario) throws IOException, InterruptedException {
		
		if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) PageFactory.instance().getWebDriver();
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "./Reports/" + System.currentTimeMillis() + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            Reporter.addScreenCaptureFromPath(destination.getAbsolutePath());
		
		}
		DriverManager.closeDriver();

	}

}
