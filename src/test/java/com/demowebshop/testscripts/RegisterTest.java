package com.demowebshop.testscripts;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilits.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends Base {
    HomePage home;
    RegisterPage register;
    ExcelUtility excel;
    UserAccountPage user;
    @Test(priority = 2,enabled = true,description = "Verification of user registration")
    public void verifyUserRegistration() throws IOException {
        register=new RegisterPage(driver);
        excel = new ExcelUtility();
        String ExcelFilePath= Constants.EXCEL_FILE_PATH;
        String ExcelSheetName=Constants.EXCEL_SHEET_REGISTER_PAGE;
        List<String> excelData = excel.readDataFromExcel(ExcelFilePath, ExcelSheetName);
      register=home.clickOnRegisterMenu();
      register.SelectGender(excelData.get(0));
      register.enterFirstName(excelData.get(1));
      register.enterLastName(excelData.get(2));
      register.enterEmail(excelData.get(3));
      register.enterPassWord(excelData.get(4));
      register.enterCPassWord(excelData.get(5));
        user = register.clickOnRegister();

        String actualUserName="aleenamariya97@gmail.com";
        String expectedUserName=user.verifyUserName();
        Assert.assertEquals(actualUserName,expectedUserName,"ERROR : Login Failed");
    }
}
