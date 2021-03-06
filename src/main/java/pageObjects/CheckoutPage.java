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

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//input[@id='company']")
    private WebElement txtbx_CompanyName;

    @FindBy(how = How.XPATH, using = "//input[@id='address1']")
    private WebElement txtbx_Address1;

    @FindBy(how = How.XPATH, using = "//input[@id='address2']")
    private WebElement txtbx_Address2;

    @FindBy(how = How.XPATH, using = "//input[@id='city']")
    private WebElement txtbx_City;

    @FindBy(how = How.XPATH, using = "//div[@id='uniform-id_state']")
    private WebElement drpdwn_CountyDropDownArrow;

    @FindAll(@FindBy(how = How.XPATH, using = "//select[@id='id_state']/option"))
    private List<WebElement> county_List;

    @FindBy(how = How.XPATH, using = "//input[@id='postcode']")
    private WebElement txtbx_PostCode;

    @FindBy(how = How.XPATH, using = "//select[@id='id_country']")
    private WebElement drpdwn_CountryDropDown;

    @FindBy(how = How.XPATH, using = "//input[@id='phone']")
    private WebElement txtbx_Phone;

    @FindBy(how = How.XPATH, using = "//input[@id='phone_mobile']")
    private WebElement txtbx_MobilePhone;

    @FindBy(how = How.XPATH, using = "//textarea[@id='other']")
    private WebElement txtbx_AdditionalInfo;

    @FindBy(how = How.XPATH, using = "//input[@id='alias']")
    private WebElement txtbx_MyAddress;

    @FindBy(how = How.ID, using = "email")
    private WebElement txtbx_Email;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement txtbx_Password;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement btn_Login;

    @FindBy(how = How.XPATH, using = "//button[@id='submitAddress']")
    private WebElement btn_SubmitAddress;

    @FindBy(how = How.XPATH, using = "//button[@name='processAddress']")
    private WebElement btn_ProcessAddress;

    @FindBy(how = How.XPATH, using = "//input[@id='cgv']")
    private WebElement chkbx_AcceptTermsAndCondition;

    @FindBy(how = How.XPATH, using = "//button[@name='processCarrier']")
    private WebElement btn_ProcessCarrier;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@id='HOOK_PAYMENT']/div/div/p/a"))
    private List<WebElement> paymentMethod_List;

    @FindBy(how = How.XPATH, using = "//p[@id='cart_navigation']/button")
    private WebElement btn_PlaceOrder;








    public void enter_CompanyName(String companyName) {
        txtbx_CompanyName.sendKeys(companyName);

    }

    public void enter_Address1(String address) {
        txtbx_Address1.sendKeys(address);

    }

    public void enter_Address2(String address) {
        txtbx_Address2.sendKeys(address);

    }

    public void enter_City(String city) {
        txtbx_City.sendKeys(city);

    }

    public void select_County(String countyName) {
        drpdwn_CountyDropDownArrow.click();

        try { Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        for(WebElement county : county_List){
            if(county.getText().equals(countyName)) {
                county.click();
                try { Thread.sleep(3000);
                }catch (InterruptedException e) {

                }
                break;
            }
        }
    }

    public void enter_PostCode(String postCode) {
        txtbx_PostCode.sendKeys(postCode);

    }

    public void select_Country() {
        drpdwn_CountryDropDown.click();

    }

    public void enter_Phone(String phone) {
        txtbx_Phone.sendKeys(phone);

    }

    public void enter_MobilePhone(String phone) {
        txtbx_MobilePhone.sendKeys(phone);

    }

    public void enter_AdditionInfo(String text) {
        txtbx_AdditionalInfo.sendKeys(text);

    }

    public void enter_MyAddress() {
        txtbx_MyAddress.click();

    }





    public void enter_Email(String email) {
        txtbx_Email.sendKeys(email);

    }

    public void enter_Password(String pass) {
        txtbx_Password.sendKeys(pass);

    }

    public void click_Login() {
        btn_Login.click();

    }

    public void click_SubmitAddress() {
        btn_SubmitAddress.click();

    }

    public void click_ProcessAddress() {
        btn_ProcessAddress.click();

    }

    public void check_TermsAndCondition(boolean value) {
        if(value) chkbx_AcceptTermsAndCondition.click();

    }

    public void click_ProcessCarrier() {
        btn_ProcessCarrier.click();

    }




    public void select_PaymentMethod(String paymentMethod) {

        if(paymentMethod.equals("Bank wire")) {
            paymentMethod_List.get(0).click();
        }else if(paymentMethod.equals("Payment by check")) {
            paymentMethod_List.get(1).click();
        }else if(paymentMethod.equals("Credit Card")) {
            paymentMethod_List.get(2).click();
        }else {

            new Exception("Payment Method not recognised : " + paymentMethod);

        }

        try { Thread.sleep(3000);}
        catch (InterruptedException e) {
        }

        //Wait.untilJqueryIsDone(driver);



    }





    public void clickOn_PlaceOrder() {
        btn_PlaceOrder.submit();
        //Wait.untilPageLoadComplete(driver);

    }



    public void login_Registered_User(){
        enter_Email("khaled1925@gmail.com");
        enter_Password("khaled12345");
        click_Login();
    }


    public void proceed_ToCheckout(){
        click_ProcessAddress();
        check_TermsAndCondition(true);
        click_ProcessCarrier();

    }


    public void fill_PersonalDetails() {

        enter_CompanyName("Bruteforce Solution");

        enter_Address1("11 Susan Terrace");

        enter_Address2(" ");

        enter_City("Jamaica");

        select_County("New York");

        enter_PostCode("11435");

        select_Country();

        enter_Phone("9296638556");

        enter_MobilePhone("9296638556");

        enter_AdditionInfo("Hi, This is my order address.");

        enter_MyAddress();


    }
}
