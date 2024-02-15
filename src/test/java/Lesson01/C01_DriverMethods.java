package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) {

        //Chrome driver ı setup ediniz!
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver(); //WebDriver class ından driver objesi oluşturdum!

        //"www.amazon.com.tr" adrisine git!
        driver.get("https://www.amazon.com.tr/");

        //Sayfayı maximum boyuta getir!
        driver.manage().window().maximize();

        //Sayfanın başlığını yazdırın!
        System.out.println("Sitenin başlığı: "+driver.getTitle());

        //Sayfanın url adresini yazdırın!
        System.out.println("Sitenin urli: "+driver.getCurrentUrl());

        //Sayfanın kaynak kodlarını yazdırın!
        System.out.println("Sayfanın kaynak kodları:\n"+driver.getPageSource());

        //Kaynak kodlarının içerisinde "Gateway" kelimesi olduğunu test et!
        String actualData=driver.getPageSource();
        String expectedData="Gateway";
        if(actualData.contains(expectedData)){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
        }

        //Sayfanın handle kodunu yazdırın!
        System.out.println("Window handle: "+driver.getWindowHandle()); //pencereler arası geçişler için kullanılır!

        //Sayfayı kapat!
        driver.close();
    }
}
