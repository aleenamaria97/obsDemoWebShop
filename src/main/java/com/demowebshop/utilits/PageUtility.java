package com.demowebshop.utilits;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageUtility {
    Actions action;
    Alert alert;
    Select select;
    public void clickOnElement(WebElement element){

        element.click();
    }
    public void enterText(WebElement element,String value){

        element.sendKeys(value);
    }
    public String getAttributeValue(WebElement element,String attribute){

        return element.getAttribute(attribute);
    }
    public String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }
    public void doubleClickOnElement(WebDriver driver,WebElement element)
    {
         action = new Actions(driver);
        action.doubleClick(element).build().perform();
    }
    public void rightClickOnElement(WebDriver driver,WebElement element)
    {
         action = new Actions(driver);
        action.contextClick(element).build().perform();
    }
    public void moveToElements(WebDriver driver,WebElement element)
    {
         action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
    public void dragAndDrop(WebDriver driver,WebElement dragElement,WebElement dropElement)
    {
         action = new Actions(driver);
        action.dragAndDrop(dragElement,dropElement).build().perform();
    }
    public void clickAndHold(WebDriver driver,WebElement element,WebElement element1)
    {
         action = new Actions(driver);
        action.clickAndHold(element).dragAndDrop(element,element1);
    }
    public void simpleAlert(WebDriver driver)
    {
         alert = driver.switchTo().alert();
        alert.accept();
    }

    public void confirmationAlertAccept(WebDriver driver)
    {
         alert = driver.switchTo().alert();
        alert.accept();
           }
    public void confirmationAlertDismiss(WebDriver driver)
    {
         alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendValuesToAlert(WebDriver driver,String dataToEnter)
    {
         alert = driver.switchTo().alert();
        alert.sendKeys(dataToEnter);
        alert.accept();
    }
    public String getTextAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    public boolean isElementSelected(WebElement element)
    {
        return element.isSelected();
    }
    public boolean isElementDisplayed(WebElement element)
    {
     return element.isDisplayed();
    }
    public boolean isElementEnabled(WebElement element)
    {
       return element.isEnabled();
    }
    public void selectDropdownByVisibleText(WebElement element,String text)
    {
         select = new Select(element);
        select.selectByVisibleText(text);
    }
    public void selectDropdownByValue(WebElement element,String value)
    {
         select = new Select(element);
        select.selectByValue(value);
    }
    public void selectDropdownByIndex(WebElement element,int index)
    {
         select = new Select(element);
        select.selectByIndex(index);
    }
    public List<WebElement> getOptions(WebElement element){
         select=new Select(element);
        return select.getOptions();
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
}
