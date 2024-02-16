package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //"https://the-internet.herokuapp.com/add_remove_elements/" adresine git!
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        //Add element butonuna bas!
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();
        Thread.sleep(2000);

        //Delete butonunun görünürlüğünü test et!
        WebElement deleteButton=driver.findElement(By.xpath("//button[@class='added-manually']"));
        if(deleteButton.isDisplayed()){
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test failed");
        }

        //Delete butonuna bas!
        Thread.sleep(2000);
        deleteButton.click();

        //"Add/Remove Elements" yazısının görünürlüğünü test et!
        Thread.sleep(2000);

        //sadece 1 kere kontrol edeceğim için web element e atamadım direkt if te kullandım!
        if(driver.findElement(By.xpath("//h3[normalize-space()='Add/Remove Elements']")).isDisplayed()){
            System.out.println("Add/remove elements yazısı görünür.");
        }
        else{
            System.out.println("Add/remove elements yazısı görünmez.");
        }
    }
}
