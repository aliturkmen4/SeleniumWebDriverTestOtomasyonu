package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v121.indexeddb.model.Key;

import java.time.Duration;

public class C06_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //"https://www.heroku.com/home" adresine git!
        driver.navigate().to("https://www.heroku.com/home");

        //Signup butonuna tıkla!
        WebElement signUp=driver.findElement(By.linkText("Sign up"));
        signUp.click();

        //Firstname textbox, lastname text box, company elementlerini locate et!
        WebElement firstName=driver.findElement(By.id("first_name")); //webelement e atamamın sebebi ileride de signup ı kullanabilmek!
        firstName.sendKeys("Ali");
        Thread.sleep(2000);
        WebElement lastName=driver.findElement(By.id("last_name"));
        lastName.sendKeys("Türkmen");
        Thread.sleep(2000);
        WebElement emailAdress=driver.findElement(By.id("email"));
        emailAdress.sendKeys("alym11731996@gmail.com");
        WebElement company=driver.findElement(By.name("company"));
        company.sendKeys("None");

    }
}
