package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownPractice {
    WebDriver driver;
    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After

    public void tearDown() {
        driver.quit();
    }

    @Test

    public void test() throws InterruptedException {
        //"https://wwww.amazon.com.tr/" adresine gir!
        driver.navigate().to("https://www.amazon.com.tr/");
        //Cerezleri "reddet" secenegine tiklayiniz
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
        Thread.sleep(2000);
        //Arama kutusunun yanindaki kategori menusunun kategori sayisinin 40 oldugunu test ediniz
        List<WebElement> ddm=driver.findElements(By.xpath("//option"));
        System.out.println(ddm.size());
        System.out.println("------------------------------");
        for(WebElement w:ddm){
            System.out.println(w.getText());
        }
        System.out.println("------------------------------");
        int actualDropDown=ddm.size();
        int expectedDropDown=40;
        Assert.assertNotEquals(expectedDropDown,actualDropDown);

        //Kategori menusunden Kitaplar seceneginin secin
        WebElement ddmList=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddmList);
        select.selectByIndex(9);
        Thread.sleep(2000);

        //arama kutusuna Java yazin ve aratin
        WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        search.sendKeys("Java"+ Keys.ENTER);
        Thread.sleep(2000);

        //bulunan sonuc sayisinin yazdirin
        WebElement resultText=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultText.getText());
        Thread.sleep(2000);

        //Sonucun Java kelimesini icerdigini test edin
        String actualResult=resultText.getText();
        String expectedResult="Java";
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
