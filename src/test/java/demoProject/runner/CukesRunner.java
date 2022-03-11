package demoProject.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // Provides Junit connections
@CucumberOptions(

        plugin = {"html:target/cucumber-report.html",
                 "rerun:target/rerun.txt", // store failed scenario names into rerun.txt file
                 "json:target/cucumber.json" //generally json execution report to be used html reports
        },
        features = "src/test/resources",
        glue ="demoProject/step_definitions",
        dryRun=false, // false=> run the test. True=> check for missing step
        tags=""
)

public class CukesRunner {
}
