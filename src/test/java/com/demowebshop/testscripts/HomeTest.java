package com.demowebshop.testscripts;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends Base {
    HomePage home;
    @Test(priority=1,enabled=true,description ="verification of home page Title")
    public void verifyHomePageTitle() throws IOException {
        home=new HomePage(driver);
        String actualTitle=home.getActualHomePageTitle();
        String expectedTitle=home.getExpectedHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR : Invalid Home Page Title Found");
        test.log(LogStatus.PASS, "Successfully Asserted");
    }
    }


