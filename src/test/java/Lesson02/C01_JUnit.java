package Lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_JUnit {
    @Test //main methodu yerine kendi methodumu junit in test annotationını kullanarak run yapabilirim!
    public void Test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
    }

    @Test //birden fazla test case im olunca aynı class içinde driver ı ayrı ayrı kullanmama olanak sağladım!
    //aynı zamanda aynı class içinde birden fazla test case i çalıştırma imkanım oldu!
    public  void Test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://www.walmart.com");
    }
}
