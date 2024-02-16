package Lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver; //class seviyesinde kullanılsın diye before un üstüne class ın içine tanınmlıyorum! (scope)
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test

    public void Test() throws InterruptedException {
        //Amazon sayfasına git!
        driver.get("htpps://www.amazon.com.tr/");
        Thread.sleep(1000);
    }

    @Test

    public void Test1() throws InterruptedException {
        //Facebook sayfasına git!
        driver.get("htpps://www.facebook.com/");
        Thread.sleep(1000);
    }

    @After

    public void tearDown() {
        driver.quit();
    }
}
