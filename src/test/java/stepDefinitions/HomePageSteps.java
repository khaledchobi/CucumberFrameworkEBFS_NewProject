package stepDefinitions;

import cucumber.TestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();

    }


    @Given("User is on Home Page")
    public void user_is_on_home_page() {
        /*configFileReader= new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());*/
        //System.setProperty("webdriver.chrome.driver", FileReaderManager.getInstance().getConfigReader().getDriverPath());
        //System.setProperty("webdriver.chrome.driver","/Users/khaledhasan/Desktop/Java_Github/Frame_Work/CucumberFrameworkEBFS_NewProject/src/main/java/drivers/chromedriver");
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        //driver.get("http://ebfs.bruteforcesolution.net/ebfs/index.php");

        /*webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();*/

        homePage.navigateTo_HomePage();
    }

    @When("User search for {string}")
    public void user_search_for(String product) {
        //driver.navigate().to("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=search&orderby=position&orderway=desc&search_query=" + product + "&submit_search=");
        //homePage = new HomePage(driver);
        homePage.perform_Search(product);
    }



}
