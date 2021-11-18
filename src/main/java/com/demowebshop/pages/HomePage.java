package com.demowebshop.pages;

import com.demowebshop.utilits.ExcelUtility;
import com.demowebshop.utilits.PageUtility;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class HomePage {
    WebDriver driver;
    PageUtility page = new PageUtility();
    ExcelUtility excel;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageActualTitle() {
        return page.getPageTitle(driver);

    }

    public String getHomePageExpectedTitle() throws IOException {
        excel = new ExcelUtility();
        List<String> registerData = excel.readDataFromExcel("ExcelFilePath", "ExcelSheetName");
        return registerData.get(0);
    }

}
