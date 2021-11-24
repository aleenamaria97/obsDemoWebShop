package com.demowebshop.pages;

import com.demowebshop.utilits.PageUtility;
import com.demowebshop.utilits.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestHelper {
    WebDriver driver;
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private final String _userName = "Email";
    @FindBy(id =_userName )
    private   WebElement userName;
    private final String _passWordLogin="Password";
    @FindBy(id = _passWordLogin)
    private    WebElement password;
    private final String _loginButton="//input[@class='button-1 login-button']";
    @FindBy(xpath = _loginButton)
    private   WebElement loginButton;
    public void enterUserName(String uName) {
        page.enterText(userName, uName);
    } public void enterPassWordLogin(String pWordLogin) {
        page.enterText(password, pWordLogin);
    } public UserAccountPage clickOnLoginButton() {
        page.clickOnElement(loginButton);
        return new UserAccountPage(driver);
    }

}
