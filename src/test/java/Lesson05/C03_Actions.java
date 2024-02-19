package Lesson05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test

    public void actionTest() throws InterruptedException {
        //https://www.amazon.com.tr/ sayfasina gidelim

        driver.navigate().to("https://www.amazon.com.tr/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();

        //Hesaplar menusunden  liste olusturun linkine tıklayalım

        WebElement hesaplar=driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        WebElement listeolustur= driver.findElement(By.xpath("(//*[@class='nav-text'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hesaplar).click(listeolustur).perform(); //actionslar da sona perform konur!
        //movetoElement ile elementi taşıdım yani mouse u hesaplar üzerine götürdüm ardından liste oluştur a tıkladım!
        Thread.sleep(2000);

        //Arama kutusuna actions method’larine kullanarak  Iphone 15 Plus yazdirin ve Enter’a basarak arama  yaptirin

        WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        actions.click(searchBox).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).sendKeys("phone").sendKeys(" ").sendKeys("15")
                .sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("lus").sendKeys(Keys.ENTER).perform();

        //keyDown(Keys.SHIFT).sendKeys("i") --> shifte basılı tutup i ye bas demek yani I
        //keyUp(Keys.SHIFT) --> elimi shiftten kaldır demek!
        Thread.sleep(2000);

        //Aramanin gerceklestigini test edin

        String actualTitle=driver.getTitle();
        String expectedTitle="Iphone 15 Plus";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
