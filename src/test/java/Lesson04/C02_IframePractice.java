package Lesson04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_IframePractice {
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

    public void IframeTest() {
        //https://html.com/tags/iframe/ adresine gidiniz
        driver.get("https://html.com/tags/iframe/");
        //Youtube videosunu oynatiniz
        List<WebElement> iframe=driver.findElements(By.xpath("//iframe")); //birden çok iframe olduğu için list e attım!
        driver.switchTo().frame(iframe.get(0)); //0.indexteki iframe in içerisine girdim!
        WebElement button=driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        button.click();
        driver.switchTo().defaultContent(); //iframe den çıktım!
    }
}
