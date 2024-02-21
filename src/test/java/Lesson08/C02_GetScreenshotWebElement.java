package Lesson08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenshotWebElement extends TestBaseBeforeAfter {
    @Test

    public void test() throws InterruptedException, IOException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();

        //Iphone aratalım
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Iphone");
        driver.findElement(By.xpath("//*[@id='nav-search-submit-button']")).click();

        //Arama sonuc yazısının resmini alalım
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));

        File screenshot=aramaSonucu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("target/WEScreenShot/WESS"+tarih+".jpeg")); //aldığım screenshot ı buraya kaydediyorum!
    }
}
