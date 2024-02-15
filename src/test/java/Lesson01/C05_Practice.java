package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Practice {
    public static void main(String[] args) throws InterruptedException {
        //Facebook sayfasına gidin ve başlığın "facebook" olduğunu doğrula!
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com/");
        if(driver.getTitle().contains("facebook")){ //acceptance criteria da büyük küçük harf önemli ne istendiyse ona bak "facebook"
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed \nActual title: "+driver.getTitle());
        }

        //Sayfa url inin "facebook" kelimesini içerdiğini onayla, içermiyorsa gerçek url i yazdır!
        if(driver.getCurrentUrl().contains("facebook")){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed \nActual url: "+driver.getCurrentUrl());
        }

        //"https://www.walmart.com/" sayfasına git!
        Thread.sleep(2000);
        driver.get("https://www.walmart.com/");

        //Tekrar facebook sayfasına dön!
        Thread.sleep(2000);
        driver.navigate().back();

        //Sayfayı yenile!
        Thread.sleep(2000);
        driver.navigate().refresh();

        //Sayfayı maksimize yap!
        Thread.sleep(2000);
        driver.manage().window().maximize();

        //Browserı kapat!
        Thread.sleep(2000);
        driver.close();
    }
}
