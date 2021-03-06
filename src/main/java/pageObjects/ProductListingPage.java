package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

import java.util.List;

public class ProductListingPage {
    WebDriver driver;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//button[@name='Submit']/span")
    private WebElement btn_AddToCart;

    @FindAll(@FindBy(how = How.XPATH, using = "//ul[@class='product_list grid row']/li"))
    private List<WebElement> prd_List;



    public void clickOn_AddToCart() {
        btn_AddToCart.click();
        Wait.untilJqueryIsDone(driver);
    }


    public void select_Product(int productNumber) {
        prd_List.get(productNumber).click();
    }

    public String getProductName(int productNumber) {
        return prd_List.get(productNumber).findElement(By.xpath("//div[@id='center_column']/ul/li/div/div/h5")).getText();

    }

}
