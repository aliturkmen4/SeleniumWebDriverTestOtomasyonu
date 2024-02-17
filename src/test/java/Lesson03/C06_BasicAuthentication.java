package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BasicAuthentication {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test

    public void basicAuthenticationTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //    asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //    Html komutu : https://username:password@URL
        //    Username	: admin
        //    password	: admin
        //
        //    Basarili sekilde sayfaya girildigini dogrulayin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).isDisplayed());
    }
}
