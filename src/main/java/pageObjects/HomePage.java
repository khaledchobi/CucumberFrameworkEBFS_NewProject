package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;

public class HomePage {
    WebDriver driver;
    //ConfigFileReader configFileReader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //configFileReader= new ConfigFileReader();

    }


    public void perform_Search(String search) {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl() +"?controller=search&orderby=position&orderway=desc&search_query=" + search + "&submit_search=");
    }



    public void navigateTo_HomePage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }
}
