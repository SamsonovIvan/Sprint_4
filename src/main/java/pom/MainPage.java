package pom;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class MainPage {
    private final WebDriver driver;
    private final By upperMakeOrderButton = By.xpath("//button[@class='Button_Button__ra12g']"); //верхняя кнопка заказа
    private final By bottomMakeOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']"); //нижняя кнопка заказа
    private final By faq = By.xpath("//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']"); //куда скроллить

    private final String[] answers = new String[]{"//div[@id='accordion__panel-0']/p", //массив ссылок на ответы
            "//div[@id='accordion__panel-1']/p",
            "//div[@id='accordion__panel-2']/p",
            "//div[@id='accordion__panel-3']/p",
            "//div[@id='accordion__panel-4']/p",
            "//div[@id='accordion__panel-5']/p",
            "//div[@id='accordion__panel-6']/p",
            "//div[@id='accordion__panel-7']/p"};

    private final String[] questions = new String[]{"//div[@id='accordion__heading-0']", //массив ссылок на вопросы
            "//div[@id='accordion__heading-1']",
            "//div[@id='accordion__heading-2']",
            "//div[@id='accordion__heading-3']",
            "//div[@id='accordion__heading-4']",
            "//div[@id='accordion__heading-5']",
            "//div[@id='accordion__heading-6']",
            "//div[@id='accordion__heading-7']"};

    private final By COOKIE_BUTTON = By.xpath("//button[@class='App_CookieButton__3cvqF']"); //Куки кнопка тоже константа
    private static final String URL = "https://qa-scooter.praktikum-services.ru/"; //константа УРЛ

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() { //открываем страницу и закрываем куки
        driver.get(URL);
        driver.findElement(COOKIE_BUTTON).click();
        return this;
    }

    public void clickMakeOrderButton(int enterPoint) { //выбираем точку входа
        if (enterPoint == 0) {
            driver.findElement(upperMakeOrderButton).click();
        } else if (enterPoint == 1) {
            WebElement element = driver.findElement(bottomMakeOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(bottomMakeOrderButton)).click();
        }
    }

    public void clickQuestionAndCheckAnswer(int question, String givenAnswer) { //проходим по элементам массивабсравниваем текст
        WebElement element = driver.findElement(faq);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(questions[question])).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answers[question])));
        String takenAnswer = driver.findElement(By.xpath(answers[question])).getText();
        Assert.assertEquals(givenAnswer, takenAnswer);
    }
}


