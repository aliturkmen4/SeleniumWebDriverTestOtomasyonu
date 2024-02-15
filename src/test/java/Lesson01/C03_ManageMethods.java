package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.MessageFormat;

public class C03_ManageMethods {
    public static void main(String[] args) throws InterruptedException {
        //Chrome driver ı setup edin!
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //"www.amazon.com.tr/" adresine git!
        driver.navigate().to("https://www.amazon.com.tr/");

        //Sayfanın konumunu ve boyutlarını yazdır!
        System.out.println("Sayfanın konumu: "+driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutu: "+driver.manage().window().getSize());

        //Sayfayı simge durumuna getir!
        driver.manage().window().minimize();

        //Simge durumunda 2 sn bekleyip sayfayı maksimize yap!
        Thread.sleep(2000);
        driver.manage().window().maximize();

        //Sayfanın konumu ve boyutlarını maksimize durumda yazdır!
        Thread.sleep(2000);
        System.out.println("Sayfanın konumu: "+driver.manage().window().getPosition());
        System.out.println("Sayfanın boyutu: "+driver.manage().window().getSize());

        //Saydayı fullscreen moda al!
        Thread.sleep(2000);
        driver.manage().window().fullscreen();

        //Sayfanın boyutu ve konumunu fullscreenmodda yazdır!
        System.out.println("Fullscreen sayfanın konumu: "+driver.manage().window().getPosition());
        System.out.println("Fullscreen sayfanın boyutu: "+driver.manage().window().getSize());

        //Sayfanın boyutu ve konumunu isteğine göre ayarla!
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(20,20));
        driver.manage().window().setSize(new Dimension(1800,900));
        System.out.println("Belirlediğim  konum: "+driver.manage().window().getPosition());
        System.out.println("Belirlediğim  boyut: "+driver.manage().window().getSize());

        //Sayfayı kapatın!
        driver.quit();
    }
}
