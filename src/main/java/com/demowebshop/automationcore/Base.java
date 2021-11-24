package com.demowebshop.automationcore;

import com.demowebshop.constants.Constants;
import com.demowebshop.utilits.EmailUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


    public class Base {
        public WebDriver driver;
        FileInputStream file;
        public Properties prop;
        EmailUtility email;
        public static ExtentTest test;
        public ExtentReports report;
    public Base()
        {
            try {
                file = new FileInputStream(System.getProperty("user.dir")+Constants.CONFIG_FILE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            prop = new Properties();
            try {
                prop.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        @Deprecated
        public void testInitialize(String browser) {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
           // driver.manage().timeouts().pageLoadTimeout(WaitUtility.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
        test.log(LogStatus.PASS,"Successfully initialized test");
    }
    @BeforeTest
    public void errorLogin(){
        report = new ExtentReports(System.getProperty("user.dir") + "//test-output//Extent.html", true);
        test = report.startTest("DemoWebShop");
    }
    @BeforeMethod
    @Parameters("browser")
    public void setup(String browserName) {
       String url= prop.getProperty("url");
        testInitialize(browserName);
        driver.get(url);
        test.log(LogStatus.PASS, "Navigated to the  URL");
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        takeScreenShot(result);
        test.log(LogStatus.PASS, " successfully captured screen shot");
        driver.close();
    }
    @AfterTest
    public void endReport() {
        report.endTest(test);
        report.flush();
    }
        @AfterSuite
        public void sendingEmail(){
            email = new EmailUtility();
            email.sendEmail(System.getProperty("user.dir")+"//test-output//","Extent.html", prop.getProperty("to_email_id"));
            test.log(LogStatus.PASS, "Successfully Generated Email ");

        }

    public void takeScreenShot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            FileUtils.copyFile(screenShot, new File("./Screenshots/"+ result.getName() + date + ".png"));
        }
    }

}
