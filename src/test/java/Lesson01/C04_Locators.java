package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {
        //Chrome driver ı setup edin!
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //15 sn boyunca sayfadaki elementlerin yüklenmesi için bekleyecek eğer bu sürede yüklenmezse hata veriip işlemi durduracak!
        //2.sn de yükledi herhangi bir sıkıntı yok işleme devam eder bir etkisini görmezsin!

        //"www.amazon.com.tr/" adresine git!
        driver.get("https://www.amazon.com.tr/");

        //Amazonda notebook aratalım.
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("notebook" + Keys.ENTER); //searchbox a notebook kelimesini yazdım ve arattım!

        //Amazon sayfasında tagleri a olanların sayısını yazdır!
        List<WebElement> tag = driver.findElements(By.tagName("a")); //birden fazla a olan eleman olduğu için listeye atıyorum!
        System.out.println("Tagı a olanların sayısı: "+tag.size());

        //Sayfayı kapat!
        driver.close();

    }
}
