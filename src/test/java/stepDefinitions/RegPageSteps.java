package stepDefinitions;

import cucumber.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.HomePage;
import pageObjects.RegPage;
import testDataTypes.Customer;

public class RegPageSteps {

    TestContext testContext;
    RegPage regPage;

    public RegPageSteps(TestContext context) {
        testContext = context;
        regPage = testContext.getPageObjectManager().getRegPage();

    }

    @Given("User is on the Login Page")
    public void user_is_on_the_login_page() throws InterruptedException {
        //driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();

        regPage.navigateTo_LoginPage();

        Thread.sleep(3000);
    }

    @When("User enters email address for Registration")
    public void user_enters_email_address_for_registration(){

        regPage.login_Registered_User();


    }

    @When("User is on Registration Page")
    public void user_is_on_registration_page() throws InterruptedException {
        Thread.sleep(3000);
    }

    @When("User fills {string} details page to register")
    public void user_fills_details_page_to_register(String customerName) throws InterruptedException {

        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);

        regPage.fill_RegistrationDetails(customer);
        Thread.sleep(3000);

    }
}
