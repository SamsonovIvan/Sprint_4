package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class firstForm {
    private WebDriver driver;
    private String name;
    private String surname;
    private String adress;
    private String metroStation;
    private String phoneNumber;
    private String date;
    private By period;
    private By colour;
    private String comment;

    public firstForm() {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.period = period;
        this.colour = colour;
        this.comment = comment;
    }
    public void fillName(String name){
        driver.findElement(By.xpath("//input[@placeholder='* Имя']")).sendKeys();
    }



}
