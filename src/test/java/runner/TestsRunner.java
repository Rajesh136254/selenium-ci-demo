package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions", "utility"},
        plugin = {
                "pretty",
                "json:target/cucumber.json"  // Only JSON for reporting plugin
                // Remove "html:..." → let masterthought generate proper report
        },
        monochrome = true
)
public class TestsRunner { } // Use 'public' class