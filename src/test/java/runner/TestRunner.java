package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/featurefiles",
    glue = {"stepdefinitions", "hooks"},
    plugin = {
        "pretty",
        "json:target/cucumber.json",
        "html:target/cucumber-report.html"
    },
    tags = "@AdminReset"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}