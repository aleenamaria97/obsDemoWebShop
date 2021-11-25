package com.demowebshop.testscripts;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.listener.TestListener;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeTest extends Base {
    HomePage home;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority=1,enabled=true,description ="verification of home page Title")
    public void verifyHomePageTitle() throws IOException {
        extentTest.get().assignCategory("Regression");
        home=new HomePage(driver);
        String actualTitle=home.getActualHomePageTitle();
        extentTest.get().log(Status.PASS, "Actual home page title generated");
        String expectedTitle=home.getExpectedHomePageTitle();
        extentTest.get().log(Status.PASS, "Expected home page title generated");
        Assert.assertEquals(actualTitle,expectedTitle,"ERROR : Invalid Home Page Title Found");
        extentTest.get().log(Status.PASS, "verify title test case passed");

    }
    }


