package testYandexSamokat;
import org.junit.runners.Parameterized;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.orderForm;
import pom.mainPage;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;



@RunWith(Parameterized.class)
public class testYandexSamokatOrder {




    private final int enterPoint;
    private final String name;
    private final String surname;
    private final String adress;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final By period;
    private final By colour;
    private final String comment;
    private WebDriver driver;

    public testYandexSamokatOrder(int enterPoint, String name, String surname, String adress, String metroStation, String phoneNumber, String date, By period, By colour, String comment) {

        this.enterPoint = enterPoint;
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
    @Parameterized.Parameters
    public static Object[][] fillForm() {
        return new Object[][]{
                {0, "Иван", "Иванов", "Санкт-Петербург", "Академическая", "78945612301", "01.02.2023", By.xpath("//div[@class='Dropdown-option' and text()='двое суток']"), By.xpath("//input[@id='black']"), "Первый комментарий"},
                {1, "Петр", "Петров", "Москва", "Академическая", "78945633301", "05.02.2023", By.xpath("//div[@class='Dropdown-option' and text()='трое суток']"), By.xpath("//input[@id='grey']"), "Второй комментарий"},
        };
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Test
    public void testOrderScenario() {
        mainPage MainPage = new mainPage(driver);
        MainPage.open()
                .clickMakeOrderButton(enterPoint);
        orderForm form = new orderForm(driver);
        form.enterName(name)
            .enterSurName(surname)
            .enterAdress(adress)
            .chooseMetro(metroStation)
            .enterPhoneAndClickProceed(phoneNumber)
            .chooseDate(date)
            .choosePeriod(period)
            .selectColour(colour)
            .writeComment(comment)
            .clickYes()
            .acceptance();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}