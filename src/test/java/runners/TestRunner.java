package runners;


import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/java/resources/functionalTests/Reg_Test.feature",
        glue = {"stepDefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/Cucumber-Report.json",
                "junit:target/cucumber-reports/Cucumber.xml" },
        // plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
        // plugin = { "usage" },
        monochrome = true



)
public class TestRunner {
}
