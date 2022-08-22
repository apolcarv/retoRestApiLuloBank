package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/feature/employees.feature"},
        glue = "stepDefinitions",
        /** tags = "@EmployeesFail", */
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
)
@RunWith(CucumberWithSerenity.class)
public class TestRunnersCreate {
}
