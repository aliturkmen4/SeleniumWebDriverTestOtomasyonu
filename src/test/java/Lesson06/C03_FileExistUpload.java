package Lesson06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_FileExistUpload extends TestBaseBeforeAfter {
    @Test

    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        //Dosyasec locate et
        WebElement selectFile=driver.findElement(By.xpath("//*[@id='file-upload']"));
        Thread.sleep(5000);

        //Yuklemek istediginiz dosyayi secelim.
        String uploadFile="C:\\Users\\alitu\\OneDrive\\Masaüstü\\test\\deneme.txt";
        selectFile.sendKeys(uploadFile);

        //Upload butonuna bas!
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
