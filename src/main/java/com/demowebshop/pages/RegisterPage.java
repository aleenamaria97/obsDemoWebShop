package com.demowebshop.pages;

import com.demowebshop.utilits.PageUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage {
    WebDriver driver;
    PageUtility page = new PageUtility();

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    private String _genders = "///div[@class='gender']//label";
    private List<WebElement> genders = driver.findElements(By.xpath(_genders));
    private final String _fName = "//input[@id='FirstName']";
    private final WebElement FIRSTNAME = driver.findElement(By.xpath(_fName));
    private final String _lName = "//input[@id='LastName']";
    private final WebElement LASTNAME = driver.findElement(By.xpath(_lName));
    private final String _EMAIL = "//input[@id='Email']";
    private final WebElement EMAIL = driver.findElement(By.xpath(_EMAIL));
    private final String _PWord = "//input[@id='Password']";
    private final WebElement PASSWORD = driver.findElement(By.xpath(_PWord));
    private final String _CPWord = "//input[@id='ConfirmPassword']";
    private final WebElement CPASSWORD = driver.findElement(By.xpath(_CPWord));
    private final String _Register = "//input[@id='register-button']";
    private final WebElement REGISTER = driver.findElement(By.xpath(_Register));

    public void SelectGender(String genderToSelect) {
        for (int i = 0; i < genders.size(); i++) {
            String value = page.getElementText(genders.get(i));
            if (value.equals(genderToSelect)) {
                page.clickOnElement(genders.get(i));
            }
        }
    }

    public void enterFirstName(String fName) {
        page.enterText(FIRSTNAME, fName);
    }

    public void enterLastName(String lName) {
        page.enterText(LASTNAME, lName);
    }

    public void enterEmail(String email) {
        page.enterText(EMAIL, email);
    }

    public void enterPassWord(String pWord) {
        page.enterText(PASSWORD, pWord);
    }

    public void enterCPassWord(String cpword) {
        page.enterText(CPASSWORD, cpword);
    }

    public UserAccountPage clickOnRegister() {
        page.clickOnElement(REGISTER);
        return new UserAccountPage(driver);
    }
}