package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;
import testDataTypes.Customer;

import java.util.List;

public class RegPage {
    WebDriver driver;
    //ConfigFileReader configFileReader;

    public RegPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //configFileReader= new ConfigFileReader();

    }

    @FindBy(how = How.XPATH, using = "//input[@id='email_create']")
    private WebElement txtbx_EmailAddress;

    @FindBy(how = How.XPATH, using = "//button[@id='SubmitCreate']")
    private WebElement btn_CreateAnAccount;

    @FindBy(how = How.XPATH, using = "//input[@id='id_gender1']")
    private WebElement btn_TitleMale;


    @FindBy(how = How.XPATH, using = "//input[@id='customer_firstname']")
    private WebElement txtbx_FirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='customer_lastname']")
    private WebElement txtbx_LastName;

    @FindBy(how = How.XPATH, using = "//input[@id='passwd']")
    private WebElement txtbx_Password;

    @FindBy(how = How.XPATH, using = "//select[@id='days']")
    private WebElement drpdwn_Days;

    @FindAll(@FindBy(how = How.XPATH, using = "//select[@id='days']/option"))
    private List<WebElement> days_List;

    @FindBy(how = How.XPATH, using = "//select[@id='months']")
    private WebElement drpdwn_Month;

    @FindAll(@FindBy(how = How.XPATH, using = "//select[@id='months']/option"))
    private List<WebElement> month_List;

    @FindBy(how = How.XPATH, using = "//select[@id='years']")
    private WebElement drpdwn_Year;

    @FindAll(@FindBy(how = How.XPATH, using = "//select[@id='years']/option"))
    private List<WebElement> year_List;

    @FindBy(how = How.XPATH, using = "//input[@id='newsletter']")
    private WebElement chkbx_Newsletter;

    @FindBy(how = How.XPATH, using = "//button[@id='submitAccount']")
    private WebElement btn_Register;

    @FindBy(how = How.XPATH, using = "//a[@title='Add my first address']")
    private WebElement btn_AddMyFirstAddress;

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







    public void enter_EmailAddress(String emailAddress) {
        txtbx_EmailAddress.sendKeys(emailAddress);

    }

    public void click_CreateAnAccount() {
        btn_CreateAnAccount.click();
    }

    public void login_Registered_User(){
        enter_EmailAddress("khasan1275@gmail.com");
        click_CreateAnAccount();
    }

    public void click_TitleMale() {
        btn_TitleMale.click();
    }

    public void enter_FirstName(String firstName) {
        txtbx_FirstName.sendKeys(firstName);

    }

    public void enter_LastName(String lastName) {
        txtbx_LastName.sendKeys(lastName);

    }

    public void enter_Password(String password) {
        txtbx_Password.sendKeys(password);

    }

    public void select_Days(String daysValue) {
        drpdwn_Days.click();

        /*try { Thread.sleep(2000);
        } catch (InterruptedException e) {
        }*/
        Wait.untilJqueryIsDone(driver);

        for(WebElement days : days_List){
            if(days.getText().equals(daysValue)) {
                days.click();
                /*try { Thread.sleep(3000);
                }catch (InterruptedException e) {
                }*/
                Wait.untilJqueryIsDone(driver);
                break;
            }
        }
    }

    public void select_Month(String monthValue) {
        drpdwn_Month.click();

        /*try { Thread.sleep(2000);
        } catch (InterruptedException e) {
        }*/
        Wait.untilJqueryIsDone(driver);

        for(WebElement month : month_List){
            if(month.getText().equals(monthValue)) {
                month.click();
                /*try { Thread.sleep(3000);
                }catch (InterruptedException e) {
                }*/
                Wait.untilJqueryIsDone(driver);
                break;
            }
        }
    }

    public void select_Year(String yearValue) {
        drpdwn_Year.click();

        /*try { Thread.sleep(2000);
        } catch (InterruptedException e) {
        }*/
        Wait.untilJqueryIsDone(driver);

        for(WebElement year : year_List){
            if(year.getText().equals(yearValue)) {
                year.click();
                /*try { Thread.sleep(3000);
                }catch (InterruptedException e) {
                }*/
                Wait.untilJqueryIsDone(driver);
                break;
            }
        }
    }

    public void click_Newsletter() {
        chkbx_Newsletter.click();
    }

    public void click_Register() {
        btn_Register.click();
    }

    public void click_AddMyFirstAddress() {
        btn_AddMyFirstAddress.click();
    }

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

        /*try { Thread.sleep(2000);
        } catch (InterruptedException e) {

        }*/
        Wait.untilJqueryIsDone(driver);

        for(WebElement county : county_List){
            if(county.getText().equals(countyName)) {
                county.click();
                /*try { Thread.sleep(3000);
                }catch (InterruptedException e) {

                }*/
                Wait.untilJqueryIsDone(driver);
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

    public void enter_MobilePhone(String phoneMob) {
        txtbx_MobilePhone.sendKeys(phoneMob);

    }

    public void enter_AdditionInfo(String text) {
        txtbx_AdditionalInfo.sendKeys(text);

    }

    public void enter_MyAddress() {
        txtbx_MyAddress.click();

    }





    public void fill_RegistrationDetails(Customer customer) {

        //enter_EmailAddress(customer.emailAddress);

        click_TitleMale();

        enter_FirstName(customer.firstName);

        enter_LastName(customer.lastName);

        enter_Password(customer.password);

        select_Days("16  ");

        select_Month("March ");

        select_Year("1981  ");

        click_Newsletter();

        click_Register();

        click_AddMyFirstAddress();

        enter_CompanyName(customer.company);

        enter_Address1(customer.address.streetAddress);

        enter_Address2(customer.address.suiteAddress);

        enter_City(customer.address.city);

        select_County(customer.address.state);

        enter_PostCode(customer.address.postCode);

        select_Country();

        enter_Phone("9294458545");

        enter_MobilePhone("9296638576");

        enter_AdditionInfo("Hi, This is my order address.");

        enter_MyAddress();




    }












    public void navigateTo_LoginPage() {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() +"?controller=authentication&back=my-account");
    }

    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
}
