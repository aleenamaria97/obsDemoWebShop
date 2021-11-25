package com.demowebshop.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.listener.TestListener;
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
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 2,enabled = true,description = "Verification of user registration after entering values",groups = {"Sanity"})
    public void verifyLogin() throws IOException {
        extentTest.get().assignCategory("Sanity");
        HomePage home=new HomePage(driver);
        loginPage = home.clickOnLoginMenu();
        excel = new ExcelUtility();
        String ExcelFilePath= Constants.EXCEL_FILE_PATH;
        String ExcelSheetName=Constants.EXCEL_SHEET_LOGIN_PAGE;
        List<String> excelData = excel.readDataFromExcel(ExcelFilePath, ExcelSheetName);
        loginPage.enterUserName(excelData.get(0));
        extentTest.get().log(Status.PASS, "email id is entered");
        loginPage.enterPassWordLogin(excelData.get(1));
        extentTest.get().log(Status.PASS, "password is entered");
        user= loginPage.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "login button is clicked");
        String expectedUserName = excelData.get(0);
        extentTest.get().log(Status.PASS, "expected user name is generated");
        String actualUserName = user.verifyUserName();
        extentTest.get().log(Status.PASS, "actual user name is generated");
        Assert.assertEquals(actualUserName, expectedUserName, "ERROR : Login Failed");
        extentTest.get().log(Status.PASS, "Verify Login Test Case Passed");

    }
}



