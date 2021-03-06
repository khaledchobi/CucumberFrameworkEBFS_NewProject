package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ConfirmationPage {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//a[@title='View my customer account']")
    private WebElement btn_CustomerAccount;

    @FindBy(how = How.XPATH, using = "//a[@title='Orders']")
    private WebElement btn_OrderHistory;

    @FindBy(how = How.XPATH, using = "//*[@id='order-list']/tbody/tr[1]/td[7]/a[1]")
    private WebElement btn_OrderDetails;

    @FindAll(@FindBy(how = How.XPATH, using = "//span[@class='order_qte_span editable']"))
    private List<WebElement> prd_List;



    public void click_CustomerAccount() {
        btn_CustomerAccount.click();

    }

    public void click_OrderHistory() {
        btn_OrderHistory.click();

    }

    public void click_OrderDetails() {
        btn_OrderDetails.click();

    }


    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        for(WebElement element : prd_List) {
            productNames.add(element.findElement(By.xpath("//td[@class='bold']/label")).getText());
        }
        return productNames;

    }
}
