import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/simonk/Desktop/test-framework/gui-tests/src/test/resources/features/Angular.feature:12"},
        plugin = {"json:C:/Users/simonk/Desktop/test-framework/gui-tests/target/cucumber-parallel/1.json"},
        monochrome = true,
        glue = {"com.simonk.gui.configurations.webdriver", "com.simonk.gui.stepdefinitions"})
public class Parallel01IT {
}
