package Lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Checkbox {
    WebDriver driver; //class seviyesinde kullanılsın diye before un üstüne class ın içine tanınmlıyorum! (scope)
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After

    public void tearDown() {
        //driver.quit();
    }

    @Test

    public void test() {
        //Verilen web sayfasına git ("https://the-internet.herokuapp.com/checkboxes")
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        //Checkbox1 ve checkbox2 elementlerini locate et!
        WebElement checkbox1=driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")); //type a göre locate etme şekli!
        WebElement checkbox2=driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        //Checkbox1 seçili değilse onay kutusana tıkla!
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }

        //Checkbox2 seçili değilse onay kutusana tıkla!
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
    }
}
