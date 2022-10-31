package TestOrder;

import NewOrder.mainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;


public  class testYandexSamokat {
 private WebDriver driver;

   @Before
   public void setUp(){
   driver = new FirefoxDriver();
   //driver = new ChromeDriver();
   driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

  }
    @Test
    public void testMakeOrderUpperButton(){
     mainPage makeOrder = new mainPage(driver);
     makeOrder.open()
              .clickMakeOrderButton()
              .fillForms();
     Assert.assertThat(driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ']")).getText(), containsString("Заказ оформлен"));

    }
    @Test
    public void testMakeOrderBottomButton(){
        mainPage makeOrder = new mainPage(driver);
        makeOrder.open()
                .clickMakeOrderButtonInBottom()
                .fillForms();
        Assert.assertThat(driver.findElement(By.xpath("//div[@class='Order_ModalHeader__3FDaJ']")).getText(), containsString("Заказ оформлен"));

    }
     @After
    public void teardown() {
    driver.quit();
   }
 }
