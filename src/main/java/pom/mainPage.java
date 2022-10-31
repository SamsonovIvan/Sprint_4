package pom;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class mainPage {
    private final WebDriver driver;
    private final By upperMakeOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");
    private final By bottomMakeOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By faq = By.xpath("//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");
    private final By question1 = By.xpath("//div[@id='accordion__heading-0']");
    private final By question2 = By.xpath("//div[@id='accordion__heading-1']");
    private final By question3 = By.xpath("//div[@id='accordion__heading-2']");
    private final By question4 = By.xpath("//div[@id='accordion__heading-3']");
    private final By question5 = By.xpath("//div[@id='accordion__heading-4']");
    private final By question6 = By.xpath("//div[@id='accordion__heading-5']");
    private final By question7 = By.xpath("//div[@id='accordion__heading-6']");
    private final By question8 = By.xpath("//div[@id='accordion__heading-7']");
    private final By answer1 = By.xpath("//div[@id='accordion__panel-0']/p");
    private final By answer2 = By.xpath("//div[@id='accordion__panel-1']/p");
    private final By answer3 = By.xpath("//div[@id='accordion__panel-2']/p");
    private final By answer4 = By.xpath("//div[@id='accordion__panel-3']/p");
    private final By answer5 = By.xpath("//div[@id='accordion__panel-4']/p");
    private final By answer6 = By.xpath("//div[@id='accordion__panel-5']/p");
    private final By answer7 = By.xpath("//div[@id='accordion__panel-6']/p");
    private final By answer8 = By.xpath("//div[@id='accordion__panel-7']/p");
    public mainPage(WebDriver driver) {
        this.driver = driver;
    }

    public mainPage open() {
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
        return this;
    }

    public void clickMakeOrderButton(int enterPoint) {
        if (enterPoint == 0) {
            driver.findElement(upperMakeOrderButton).click();
        } else if (enterPoint == 1) {
            WebElement element = driver.findElement(bottomMakeOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(bottomMakeOrderButton)).click();
        }
    }

    public void checkQuestions(int question, String givenAnswer) {
        WebElement element = driver.findElement(faq);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(faq));
        if (question == 1) {
            driver.findElement(question1).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer1));
            String takenAnswer = driver.findElement(answer1).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 2) {
            driver.findElement(question2).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer2));
            String takenAnswer = driver.findElement(answer2).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 3) {
            driver.findElement(question3).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer3));
            String takenAnswer = driver.findElement(answer3).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 4) {
            driver.findElement(question4).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer4));
            String takenAnswer = driver.findElement(answer4).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 5) {
            driver.findElement(question5).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer5));
            String takenAnswer = driver.findElement(answer5).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 6) {
            driver.findElement(question6).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer6));
            String takenAnswer = driver.findElement(answer6).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 7) {
            driver.findElement(question7).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer7));
            String takenAnswer = driver.findElement(answer7).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else if (question == 8) {
            driver.findElement(question8).click();
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(answer8));
            String takenAnswer = driver.findElement(answer8).getText();
            Assert.assertEquals(givenAnswer, takenAnswer);
        } else {
            System.out.println("Вопросов больше нет");
        }
    }
}