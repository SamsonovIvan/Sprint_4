package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class orderForm {
    private final WebDriver driver;
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    private final By adressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroField = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By proceedButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By periodField = By.xpath("//span[@class='Dropdown-arrow']");
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    private final By yesButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By proceedButton2 = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By orderCompleteTab = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    public orderForm(WebDriver driver){
        this.driver=driver;
    }
    public orderForm enterName(String name){
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    public orderForm enterSurName(String surName){
        driver.findElement(surnameField).sendKeys(surName);
        return this;
    }
    public orderForm enterAdress(String adress){
        driver.findElement(adressField).sendKeys(adress);
        return this;
    }
    public orderForm chooseMetro (String metroStation){
        driver.findElement(metroField).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
        return this;
    }
    public orderForm enterPhoneAndClickProceed (String phoneNumber){
        driver.findElement(phoneField).sendKeys(phoneNumber);
        driver.findElement(proceedButton).click();
        return this;
    }
    public orderForm chooseDate(String date){
        driver.findElement(dateField).sendKeys(date);
        return this;
    }
    public orderForm choosePeriod(By period){
        driver.findElement(periodField).click();
        driver.findElement(period).click();
        return this;
    }
    public orderForm selectColour(By colour){
        driver.findElement(colour).click();
        return this;
    }
    public orderForm writeComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(proceedButton2).click();
        return this;
    }
    public orderForm clickYes(){
        driver.findElement(yesButton).click();
        return this;
    }
    public void acceptance(){
     String orderAcceptance = driver.findElement(orderCompleteTab).getText();
        Assert.assertNotNull(orderAcceptance);
    }
}
