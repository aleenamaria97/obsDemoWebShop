package com.demowebshop.testscripts;
import com.demowebshop.automationcore.Base;
import com.demowebshop.constants.Constants;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilits.ExcelUtility;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends Base {
    RegisterPage register;
    UserAccountPage user;
    ExcelUtility excel;
    HomePage home;

    @Test(priority=2,enabled=true,description ="verification of Registration Title")
    public void verifyUserRegistration() throws IOException {
        home= new HomePage(driver);
        user = new UserAccountPage(driver);
        register = new RegisterPage(driver);
        excel=new ExcelUtility();
        List<String> readExcelData = excel.readDataFromExcel(Constants.EXCEL_FILE_PATH, Constants.EXCEL_SHEET_REGISTER_PAGE);
        register=home.clickOnRegisterMenu();
        String email = register.randomStringGeneration();
        register.selectGender(readExcelData.get(0));
        register.enterFirstName(readExcelData.get(1));
        register.enterLastName(readExcelData.get(2));
        register.enterEmail(email);
        register.enterPassWord(readExcelData.get(4));
        register.enterCPassWord(readExcelData.get(5));
        user = register.clickOnRegisterButton();

        test.log(LogStatus.PASS, "Successfully Registered");

        String expectedMail=user.verifyUserName();
        Assert.assertEquals(email,expectedMail,"ERROR : Login Failed");

        test.log(LogStatus.PASS, "Successfully registered");
    }

}
