package Lesson04;

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
import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle {
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
        //driver.quit();
    }

    @Test

    public void windowHandleTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        String herokuAppWindowHandle=driver.getWindowHandle(); //ilk gittiğim sayfanın handle kodunu string değere atadım! (geri döneceğim için)
        Thread.sleep(2000);

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Click Here butonuna basın.
        WebElement clickHere=driver.findElement(By.xpath("//*[text()='Click Here']"));
        clickHere.click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        List<String> windowHandle=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1)); //1.indexli 2.window u seçtim!
        Thread.sleep(2000);
        String actualText=driver.getTitle();
        String expectedText="New Window";
        Assert.assertEquals(expectedText,actualText);

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        Thread.sleep(2000);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowHandle.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}
