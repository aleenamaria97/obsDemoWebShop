package com.demowebshop.pages;

import com.demowebshop.constants.Constants;
import com.demowebshop.utilits.ExcelUtility;
import com.demowebshop.utilits.PageUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class HomePage {
    WebDriver driver;
    PageUtility page = new PageUtility();
    ExcelUtility excel;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final String _registerMenu="//a[@class='ico-register']";
    private final WebElement REGISTER= driver.findElement(By.xpath(_registerMenu));
    private String _loginMenu="//a[@class='ico-login']";
    private final WebElement LOGIN= driver.findElement(By.xpath(_loginMenu));

    public String getHomePageActualTitle() {
        return page.getPageTitle(driver);

    }

    public String getHomePageExpectedTitle() throws IOException {
        excel = new ExcelUtility();
        String ExcelFilePath= Constants.EXCEL_FILE_PATH;
        String ExcelSheetName=Constants.EXCEL_SHEET_NAME;
        List<String> excelData = excel.readDataFromExcel(ExcelFilePath, ExcelSheetName);
        return excelData.get(0);
    }
    public RegisterPage clickOnRegisterMenu(){
    page.clickOnElement(REGISTER);
    return new RegisterPage(driver);
}
    public LoginPage clickOnLoginMenu(){
        page.clickOnElement(LOGIN);
        return new LoginPage(driver);
    }
}
