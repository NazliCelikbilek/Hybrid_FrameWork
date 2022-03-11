package demoProject.step_definitions;



import demoProject.utilities.DBUtils;
import demoProject.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Similar to TestBase.java in TestNG framework
 * We open close browser here etc.
 */
public class Hooks {

    @Before
    public void setup(){
        System.out.println("BEFORE - setUp method is running before the scenario");
    }
    @Before("@db")
    public void  setupDb(){
        System.out.println("Setting up database connections");
        DBUtils.createConnection();
    }
    @After

    /**
     * Scenario scenario: represents current running cucumber scenario
     * -cast webdriver to TakesScreenshot interface.(TakesScreenshot)Driver.getDriver()
     * -call getScreenShotAs method and output type as OutputType.BYTES
     * -save the result into byte[] array: byte[] image
     * -attach the image into the scenario html report: scenario.attach(image, "image/png", scenario.getName());
     * if we want to only fails screenshot we can use if statement with a isFailed().
     * if(scenario.isFailed()){ .......}
     */
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }
        System.out.println("AFTER - tearDown method is running after the scenario" + scenario.getName());
        Driver.closeDriver();
    }
    @After("@db")
    public  void destroyDB(){
        DBUtils.destroy();
        System.out.println("CLOSING DATABASE CONNECTION......");
    }

}
/** @AfterStep
public void tearDownStep(Scenario scenario) {
byte[] image=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
scenario.attach(image, "image/png", scenario.getName());
} */



/**
 * Hooks are blocks of code that run before or after each scenario in the Cucumber execution cycle. This allows us to manage the code workflow better and helps to reduce code redundancy. Hooks can be defined anywhere in the project or step definition layers using the methods @Before and @After.
 */