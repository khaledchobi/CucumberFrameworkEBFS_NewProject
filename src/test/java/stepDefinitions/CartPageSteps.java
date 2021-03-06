package stepDefinitions;

import cucumber.TestContext;

import io.cucumber.java.en.When;
import pageObjects.CartPage;

public class CartPageSteps {
    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();

    }

    @When("Moves to checkout from mini cart")
    public void moves_to_checkout_from_mini_cart() {
        /*WebElement proceedToCart = driver.findElement(By.xpath("//a[@title='Proceed to checkout']/span"));
        proceedToCart.click();
        WebElement proceedToCheckout = driver.findElement(By.xpath("//p/a[@title='Proceed to checkout']/span"));
        proceedToCheckout.click();*/
        //cartPage = pageObjectManager.getCartPage();

        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();
    }

}
