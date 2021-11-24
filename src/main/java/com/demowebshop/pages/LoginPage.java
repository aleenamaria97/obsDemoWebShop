package com.demowebshop.pages;

import com.demowebshop.utilits.PageUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    PageUtility page = new PageUtility();

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    private final String _userName = "//input[@id='Email']";
    private final WebElement USERNAME = driver.findElement(By.xpath(_userName));
    private final String _passWordLogin="//input[@id='Password']";
    private final WebElement PASSWORD=driver.findElement(By.xpath(_passWordLogin));
    private final String _rememberMe="//input[@id='RememberMe']";
    private final WebElement REMEMBER=driver.findElement(By.xpath(_rememberMe));
    private final String _loginButton="//input[@class='button-1 login-button']";
    private final WebElement LOGINBUTTON=driver.findElement(By.xpath(_loginButton));
    public void enterUserName(String uName) {
        page.enterText(USERNAME, uName);
    } public void enterPassWordLogin(String pwordLogin) {
        page.enterText(PASSWORD, pwordLogin);
    } public void rememberMeLogin(String rememberMe) {
        if(rememberMe.equals("True")){
        page.clickOnElement(REMEMBER);}
    } public UserAccountPage loginButtonClick() {
        page.clickOnElement(LOGINBUTTON);
        return new UserAccountPage(driver);
    }

}
