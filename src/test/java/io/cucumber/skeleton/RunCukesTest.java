package io.cucumber.skeleton;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;

@RunWith(ExtendedCucumber.class)
@CucumberOptions(
        features = "src/test/resources/General/",
        plugin = {"pretty", "io.qameta.allure.cucumberjvm.AllureCucumberJvm", "junit:target/surefire-reports/Cucumber.xml", "html:target", "com.cucumber.listener.ExtentCucumberFormatter:./Reports/index.html"},
        glue = {"Steps.Seera"},
       dryRun=false,
       monochrome = true
)

public class RunCukesTest {


}
