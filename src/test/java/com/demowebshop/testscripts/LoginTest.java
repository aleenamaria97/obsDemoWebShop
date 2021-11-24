package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilits.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginTest extends Base {

    ExcelUtility excel;
    UserAccountPage user;
    LoginPage loginPage;

    @Test(priority = 2,enabled = true,description = "Verification of user registration after entering values")
    public void verifyLogin() throws IOException {
       HomePage home=new HomePage(driver);
        loginPage = home.clickOnLoginMenu();
        excel = new ExcelUtility();
        String ExcelFilePath= Constants.EXCEL_FILE_PATH;
        String ExcelSheetName=Constants.EXCEL_SHEET_LOGIN_PAGE;
        List<String> excelData = excel.readDataFromExcel(ExcelFilePath, ExcelSheetName);
        loginPage.enterUserName(excelData.get(0));
        loginPage.enterPassWordLogin(excelData.get(1));
        user= loginPage.clickOnLoginButton();

        String actualUserName = "aleena97@gmail.com";
        String expectedUserName = user.verifyUserName();
        Assert.assertEquals(actualUserName, expectedUserName, "ERROR : Login Failed");
    }
}



