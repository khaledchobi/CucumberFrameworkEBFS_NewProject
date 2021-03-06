package others;

import dataProvider.ConfigFileReader;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;
    HomePage homePage;
    ProductListingPage productListingPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PageObjectManager pageObjectManager;
    //ConfigFileReader configFileReader;
    WebDriverManager webDriverManager;

    //@Given("User is on Home Page")
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

        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();

        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navigateTo_HomePage();
    }

    //@When("User search for {string}")
    public void user_search_for(String product) {
        //driver.navigate().to("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=search&orderby=position&orderway=desc&search_query=" + product + "&submit_search=");
        //homePage = new HomePage(driver);
        homePage.perform_Search(product);
    }

    //@When("Choose to buy the first item")
    public void choose_to_buy_the_first_item() {
        /*List<WebElement> items = driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));
        items.get(0).click();

        WebElement addToCart = driver.findElement(By.xpath("//button[@name='Submit']/span"));
        addToCart.click();*/

        productListingPage = pageObjectManager.getProductListingPage();
        productListingPage.select_Product(0);
        productListingPage.clickOn_AddToCart();


    }

    //@When("Moves to checkout from mini cart")
    public void moves_to_checkout_from_mini_cart() {
        /*WebElement proceedToCart = driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span"));
        proceedToCart.click();
        WebElement proceedToCheckout = driver.findElement(By.xpath("//p/a[@title='Proceed to checkout']/span"));
        proceedToCheckout.click();*/

        cartPage = pageObjectManager.getCartPage();
        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();
    }

    //@When("Enter personal details on checkout page")
    public void enter_personal_details_on_checkout_page() throws InterruptedException {
        /*driver.findElement(By.id("email")).sendKeys("khaled1925@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("khaled12345");
        driver.findElement(By.id("SubmitLogin")).click();

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Bruteforce Solution");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("11 Susan Terrace");
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Jamaica");


        WebElement countyDropDown = driver.findElement(By.xpath("//div[@id='uniform-id_state']"));
        countyDropDown.click();
        Thread.sleep(2000);
        List<WebElement> countyList = driver.findElements(By.xpath("//select[@id='id_state']/option"));
        for(WebElement county : countyList){
            if(county.getText().equals("New York")) {
                county.click();
                Thread.sleep(3000);
                break;
            }
        }

        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("11435");
        driver.findElement(By.xpath("//select[@id='id_country']")).click();

        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9296638556");
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("9296638556");
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("Hi, This is my order address.");
        driver.findElement(By.xpath("//input[@id='alias']")).click();

        driver.findElement(By.xpath("//button[@id='submitAddress']")).click();*/

        checkoutPage = pageObjectManager.getCheckoutPage();
        checkoutPage.login_Registered_User();
        checkoutPage.fill_PersonalDetails();
        checkoutPage.click_SubmitAddress();

    }

    //@When("Select delivery address")
    public void select_delivery_address() {
        /*driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        driver.findElement(By.xpath("//input[@id='cgv']")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();*/

        checkoutPage.proceed_ToCheckout();


    }

    //@When("Select payment method as {string} payment")
    public void select_payment_method_as_payment(String arg1) {
        //List<WebElement> paymentMethod = driver.findElements(By.xpath("//div[@id='HOOK_PAYMENT']/div/div/p/a"));
        //paymentMethod.get(1).click();

        checkoutPage.select_PaymentMethod("Payment by check");


    }

    //@When("Place the order")
    public void place_the_order() {
        //driver.findElement(By.xpath("//p[@id='cart_navigation']/button")).click();

        checkoutPage.clickOn_PlaceOrder();

        //driver.quit();
        webDriverManager.closeDriver();
    }


}
