package com.demowebshop.pages;

import com.demowebshop.utilits.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends TestHelper {
    WebDriver driver;
    public UserAccountPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    private final String _userName="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath = _userName)
    private WebElement userName;
    public String verifyUserName(){
        return page.getElementText(userName);
    }
}
