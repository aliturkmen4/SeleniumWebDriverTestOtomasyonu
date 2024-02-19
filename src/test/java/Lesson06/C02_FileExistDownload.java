package Lesson06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistDownload extends TestBaseBeforeAfter {
    @Test

    public void fileExistTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");

        //Sample.pdf dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='sample.pdf']")).click();
        Thread.sleep(1500);

        //Ardından isExist( ) methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String samplepath="C:\\Users\\alitu\\OneDrive\\Masaüstü\\test\\sample.pdf";
        Assert.assertTrue(Files.exists(Paths.get(samplepath)));

        //İndirildiğini konsolda gösterin
        System.out.println(Paths.get(samplepath));
    }
}
