package Lesson05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class C06_Actions extends TestBaseBeforeAfter {
    @Test

    public void test() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(5000);
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions action=new Actions(driver);
        action.sendKeys("Ali").sendKeys(Keys.TAB).sendKeys("Türkmen").sendKeys(Keys.TAB).sendKeys("555555555555").sendKeys(Keys.TAB).sendKeys("dasfasfads").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("17").sendKeys(Keys.TAB).sendKeys("Mar").sendKeys(Keys.TAB).sendKeys("1996").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
    }
}
