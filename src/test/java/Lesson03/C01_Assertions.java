package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    WebDriver driver;
    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
    }

    @After

    public void tearDown() {
        driver.quit();
    }

    @Test

    public void test() {
        //url in amazon içerdiğini kontrol et!

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl)); //actual url im expected url i içeriyor mu dedim! bu kontrol başarısızsa testi durdurur (fail olur)

    }

    @Test

    public void test2() {
        //title ın facebook içermediğini kontrol et!

        String actualTitle=driver.getTitle();
        String expectedTitle="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle)); //title ın facebook içermediğini bildiğim için assertfalse la kontrol ettim (fail alıp test durmasın diye)

    }

    @Test

    public void test3() {
        //sol üst köşede amazon logosunun göründüğünü kontrol et!

        WebElement logo=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());

    }

    @Test

    public void test4() {
        //url in "https://wwww.facebook.com/" olduğunu test et!

        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://wwww.facebook.com/";
        Assert.assertFalse(actualUrl.contains(expectedUrl));

    }


}
