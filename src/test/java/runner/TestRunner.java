package runner;

import junit.textui.TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinitions", "utility"},
        // 👉 To run only 2nd scenario
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report"
        },
        monochrome = true
)
class TestsRunner {
}