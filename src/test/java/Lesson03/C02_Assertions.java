package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    WebDriver driver;
    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
    }

    @After

    public void tearDown() {
        driver.quit();
    }

    //https://www.youtube.com adresine gidin
    //Asagidadki adlari lullanarak 4 test methou olusturun ve gerekli testleri yapin
    //titleTest => Sayfa basliginin "YouTube" oldugunu test edin
    //imageTest => yotube resminin goruntulendigini test edin
    //SearchBox in erisilebilir oldugunu test edin
    //wrongTitleTest => Sayfa basliginin "youtube" olmadigini test edin

    @Test

    public void titleTest() throws InterruptedException {
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Thread.sleep(2000);
    }

    @Test
    public void imageTest() throws InterruptedException {
        WebElement icon = driver.findElement(By.xpath("(//*[@class='yt-spec-icon-shape'])[5]"));
        Assert.assertTrue(icon.isDisplayed());
        Thread.sleep(2000);
    }

    @Test

    public void seachBoxTest() throws InterruptedException {
        WebElement seachBox=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(seachBox.isEnabled());
        Thread.sleep(2000);
    }

    @Test
    public void wrongTitleTest() throws InterruptedException {
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
        Thread.sleep(2000);
    }
}
