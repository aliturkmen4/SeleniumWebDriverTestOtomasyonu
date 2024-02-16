package Lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClass {
    static WebDriver driver; //class seviyesinde kullanılsın diye before un üstüne class ın içine tanınmlıyorum! (scope)
    @BeforeClass //bunu kullanıyorsam methodun static olması lazım!
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass //bunu kullanıyorsam methodun static olması lazım!
    public static void tearDown() {
        driver.quit();
    }

    @Test

    public void Test() throws InterruptedException {
        //Amazon sayfasına git!
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(1000);
    }

    @Test

    public void Test1() throws InterruptedException {
        //Facebook sayfasına git!
        driver.get("htpps://www.facebook.com/");
        Thread.sleep(1000);
    }

    //aynı browserda önce amazon u sonra facebook u açacak!

}
