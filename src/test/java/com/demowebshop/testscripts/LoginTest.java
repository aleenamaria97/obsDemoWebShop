package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilits.ExcelUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginTest extends Base {
    HomePage home;
    RegisterPage register;
    ExcelUtility excel;
    UserAccountPage user;
    public ExtentReports report;
    static ExtentTest test;
     LoginPage loginPage;

    @Test(priority = 3,enabled = true,description = "Verification of user registration after entering values")
    public void verifyLogin() throws IOException {
        loginPage=new LoginPage(driver);
        loginPage = home.clickOnLoginMenu();
        List<String> readExcelData = excel.readDataFromExcel(Constants.EXCEL_FILE_PATH, Constants.EXCEL_SHEET_LOGIN_PAGE);
        loginPage.enterUserName(readExcelData.get(0));
        loginPage.enterPassWordLogin(readExcelData.get(1));
        loginPage.rememberMeLogin(readExcelData.get(2));

        user= loginPage.loginButtonClick();

        String actualUserName = "aleenamariya97@gmail.com";
        String expectedUserName = user.verifyUserName();
        Assert.assertEquals(actualUserName, expectedUserName, "ERROR : Login Failed");
    }
}



