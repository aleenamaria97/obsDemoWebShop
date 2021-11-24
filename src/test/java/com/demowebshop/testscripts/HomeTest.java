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
    public ExtentReports report;
    static ExtentTest test;
    @Test(priority = 1,enabled = true,description = "Verification of Home Page Title")
    public void verifyHomePageTitle() throws IOException {
        home = new HomePage(driver);
        String actualTitle = home.getHomePageActualTitle();
        String expectedTitle=home.getHomePageExpectedTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR : INVALID HOME PAGE TITLE FOUND");
        test.log(LogStatus.PASS, "Test Passed");
    }
    }


