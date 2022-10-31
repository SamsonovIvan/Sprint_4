package main.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mainPage {
    private final WebDriver driver;
    private final By makeOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    private final By makeOrderButton2 = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    private final String url = "https://qa-scooter.praktikum-services.ru/";

    public mainPage(WebDriver driver) {

        this.driver = driver;
    }
    public String getUrl() {
        return url;
    }
    public By getMakeOrderButton(){
        return makeOrderButton;
    }
    public By getMakeOrderButton2() {
        return makeOrderButton2;
    }
    public mainPage open() {
        driver.get(url);
        return this;
    }
    public mainPage clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
        return this;
    }
    public void fillForms(){
        firstForm first = new firstForm(driver);
        first.fillForm();
        secondForm second = new secondForm(driver);
                second.fillForm2();

    }
    public mainPage clickMakeOrderButtonInBottom() {
        driver.findElement(makeOrderButton).click();
        return this;
    }
    public void fillFormsTestBottom(){
        firstForm first = new firstForm(driver);
        first.fillForm();
        secondForm second = new secondForm(driver);
        second.fillForm2();

    }
}
