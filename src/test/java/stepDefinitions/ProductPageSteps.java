package stepDefinitions;

import cucumber.TestContext;
import enums.Context;

import io.cucumber.java.en.When;
import pageObjects.ProductListingPage;

public class ProductPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductPageSteps(TestContext context) {
        testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();

    }


    @When("Choose to buy the first item")
    public void choose_to_buy_the_first_item() {
        /*List<WebElement> items = driver.findElements(By.xpath("//ul[@class='product_list grid row']/li"));
        items.get(0).click();
        WebElement addToCart = driver.findElement(By.xpath("//button[@name='Submit']/span"));
        addToCart.click();*/
        //productListingPage = pageObjectManager.getProductListingPage();
        String productName = productListingPage.getProductName(0);
        testContext.scenarioContext.setContext(Context.PRODUCT_NAME, productName);

        productListingPage.select_Product(0);
        productListingPage.clickOn_AddToCart();


    }


}
