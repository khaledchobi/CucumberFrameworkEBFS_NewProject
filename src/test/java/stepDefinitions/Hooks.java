package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class Hooks {
    TestContext testContext;
    private WebDriver driver;


    public Hooks(TestContext context) {

        testContext = context;

    }



    @Before

    public void BeforeSteps() {

 /*What all you can perform here

 Starting a webdriver

 Setting up DB connections

 Setting up test data

 Setting up browser cookies

 Navigating to certain page

 or anything before the test

 */

    }


    @After(order = 0)

    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }

    }


    /*@After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);

        }

    }*/


    @After(order = 1)

    public void AfterSteps() throws InterruptedException {

        Thread.sleep(3000);

        testContext.getWebDriverManager().closeDriver();

    }

}
