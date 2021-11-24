package com.demowebshop.pages;

import com.demowebshop.utilits.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class RegisterPage extends TestHelper {
    WebDriver driver;
    public RegisterPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    private final String _genders = "//div[@class='gender']//label";
    @FindBy(xpath = _genders)
    private List<WebElement> genders;
    private final String _fName = "FirstName";
    @FindBy(id = _fName)
    private    WebElement firstName;
    private final String _lName = "LastName";
    @FindBy(id =_lName )
    private    WebElement lastName;
    private final String _EMAIL = "Email";
    @FindBy(id =_EMAIL )
    private   WebElement email;
    private final String _PWord = "Password";
    @FindBy(id = _PWord)
    private   WebElement password;
    private final String _CPWord = "ConfirmPassword";
    @FindBy(id = _CPWord)
    private   WebElement cPassword ;
    private final String _RegisterButton = "register-button";
    @FindBy(id = _RegisterButton)
    private    WebElement registerButton;

    public void selectGender(String genderToSelect) {
        for (int i = 0; i < genders.size(); i++) {
            String value = page.getElementText(genders.get(i));
            if (value.equals(genderToSelect)) {
                page.clickOnElement(genders.get(i));
            }
        }
    }

    public void enterFirstName(String fName) {
        page.enterText(firstName, fName);
    }

    public void enterLastName(String lName) {
        page.enterText(lastName, lName);
    }

    public void enterEmail(String emailId) {
        page.enterText(email, emailId);
    }

    public void enterPassWord(String pWord) {
        page.enterText(password, pWord);
    }

    public void enterCPassWord(String cPword) {
        page.enterText(cPassword, cPword);
    }

    public UserAccountPage clickOnRegisterButton() {
        page.clickOnElement(registerButton);
        return new UserAccountPage(driver);
    }
    public String randomStringGeneration(){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomStringEmail = sb.toString()+"@gmail.com";
        return randomStringEmail;
    }

}