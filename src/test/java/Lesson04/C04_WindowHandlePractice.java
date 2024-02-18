package Lesson04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandlePractice {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test

    public void windowHandleTest() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
        String amazonWindowHandle= driver.getWindowHandle();
        System.out.println(amazonWindowHandle);

        //Url'in "amazon" içerdiğini kontrol et!
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        Thread.sleep(2000);

        //Yeni bir pencere açıp "https://www.bestbuy.com" sayfasına git!
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.bestbuy.com");
        String bestBuyWindowHandle=driver.getWindowHandle();

        //title ın BestBuy içerdiğini test et!
        Thread.sleep(2000);
        String actualTitle=driver.getTitle();
        String expectedTitle="Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //İlk sayfaya dönüp java kelimesini arat!
        driver.switchTo().window(amazonWindowHandle);
        WebElement search=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        search.sendKeys("Java");
        WebElement magnify=driver.findElement(By.xpath("//*[@id='nav-search-submit-button']"));
        magnify.click();
        Thread.sleep(2000);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement actulaText= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult=actulaText.getText();
        String expectedResult="Java";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //7- Yeniden bestbuy sayfasına gidelim
        Thread.sleep(2000);
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed());
    }
}
