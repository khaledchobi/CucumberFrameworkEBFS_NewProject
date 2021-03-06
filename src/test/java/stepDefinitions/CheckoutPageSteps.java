package stepDefinitions;

import cucumber.TestContext;

;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();

    }

    @When("Enter personal details on checkout page")
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
        //checkoutPage = pageObjectManager.getCheckoutPage();

        checkoutPage.login_Registered_User();
        checkoutPage.fill_PersonalDetails();
        checkoutPage.click_SubmitAddress();

    }

    @When("Select delivery address")
    public void select_delivery_address() {
        /*driver.findElement(By.xpath("//button[@name='processAddress']")).click();
        driver.findElement(By.xpath("//input[@id='cgv']")).click();
        driver.findElement(By.xpath("//button[@name='processCarrier']")).click();*/

        checkoutPage.proceed_ToCheckout();


    }

    @When("Select payment method as {string} payment")
    public void select_payment_method_as_payment(String arg1) {
        //List<WebElement> paymentMethod = driver.findElements(By.xpath("//div[@id='HOOK_PAYMENT']/div/div/p/a"));
        //paymentMethod.get(1).click();

        checkoutPage.select_PaymentMethod("Payment by check");


    }

    @When("Place the order")
    public void place_the_order() {
        //driver.findElement(By.xpath("//p[@id='cart_navigation']/button")).click();

        checkoutPage.clickOn_PlaceOrder();

        //driver.quit();
        //testContext.getWebDriverManager().closeDriver();
    }


}
