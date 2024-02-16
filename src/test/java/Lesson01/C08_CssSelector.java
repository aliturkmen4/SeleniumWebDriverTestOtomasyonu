package Lesson01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        /*
        CssSelectorde sadece id ve class attributeları için locate alınabilir!
        id için başına # konulur.
        class için başına . konulur.
         */

        //"https://the-internet.herokuapp.com/add_remove_elements/" adresine git!
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        //Add element butonuna bas!
        WebElement addElementButton=driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();
        Thread.sleep(2000);

        //Delete butonunun görünürlüğünü test et!
        WebElement deleteButton=driver.findElement(By.cssSelector(".added-manually"));
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
        if(driver.findElement(By.cssSelector("div[id='content'] h3")).isDisplayed()){
            System.out.println("Add/remove elements yazısı görünür.");
        }
        else{
            System.out.println("Add/remove elements yazısı görünmez.");
        }

        //Browser kapat!
        driver.quit();
    }
}
