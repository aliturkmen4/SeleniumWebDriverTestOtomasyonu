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

public class C05_RadioButton {
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

    public void test() throws InterruptedException {
        //"https://www.facebook.com" adresine git!
        driver.get("https://www.facebook.com");

        //Cookies i kabul edin!


        //Create an account butonuna bas!
        WebElement createAccount=driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));
        createAccount.click();

        Thread.sleep(2000);

        WebElement firstName=driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[1]"));
        firstName.sendKeys("Lorem");

        WebElement lastName=driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[2]"));
        lastName.sendKeys("Ipsum");

        WebElement email=driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[3]"));
        email.sendKeys("fdsadafadfa@gmail.com");

        WebElement remail=driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[4]"));
        remail.sendKeys("fdsadafadfa@gmail.com");

        WebElement password=driver.findElement(By.xpath("(//*[@class=\"inputtext _58mg _5dba _2ph-\"])[5]"));
        password.sendKeys("abcabc+%&");

        WebElement birthDay=driver.findElement(By.xpath("//*[@id=\"day\"]"));
        birthDay.sendKeys("17");

        WebElement birthMonth=driver.findElement(By.xpath("//*[@id=\"month\"]"));
        birthMonth.sendKeys("Mar");

        WebElement birthYear=driver.findElement(By.xpath("//*[@id=\"year\"]"));
        birthYear.sendKeys("1996");

        //Gender radio buttonlarını locate et!

        WebElement genderFemale=driver.findElement(By.xpath("(//*[@name='sex'])[1]"));

        WebElement genderMale=driver.findElement(By.xpath("(//*[@name='sex'])[2]"));

        if (!genderFemale.isSelected()){
            genderMale.click();
        }
        Thread.sleep(2000);
        genderFemale.click();

    }
}
