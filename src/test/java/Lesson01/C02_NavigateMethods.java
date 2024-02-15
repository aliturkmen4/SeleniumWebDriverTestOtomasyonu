package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        //Chrome driver ı setup ediniz!
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver(); //WebDriver class ından driver objesi oluşturdum!

        driver.manage().window().maximize();

        //"www.amazon.com.tr" adresine git!
        driver.navigate().to("https://www.amazon.com.tr/"); //navigate().to() & get() e göre daha hızlı çalışır!

        Thread.sleep(1000);

        //Google ana sayfasına git!
        driver.navigate().to("https://www.google.com.tr/");

        Thread.sleep(1000); //sayfalar arası geçişi görebilmek için sleep yaptım!

        //Tekrar amazon sayfasına git!
        driver.navigate().back(); //bir önceki url e yani amazon a git dedim!

        Thread.sleep(1000);

        //Tekrar google sayfasına git!
        driver.navigate().forward(); // bir sonraki url e yani google a gitt dedim!

        Thread.sleep(1000);

        //Sayfayı yenile!
        driver.navigate().refresh();

        Thread.sleep(1000);

        //Sayfayı kapat!
        driver.quit(); //açılan bütün browserları kapatır!
        //driver.close() --> açılan son browser ı kapatır!

    }
}
