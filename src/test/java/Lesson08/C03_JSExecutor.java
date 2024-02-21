package Lesson08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();

        //Aşağıdaki carrers butonunu görünceye kadar js ile scroll yapalım
        WebElement kariyerButon = driver.findElement(By.xpath("//*[text()='Kariyer']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", kariyerButon); //kariyer butonunun locate inin olduğu yere kadar sayfayı aşağı indirttim!

        //Carrers butonuna js ile click yapalım
        js.executeScript("arguments[0].click();", kariyerButon); //kariyer butonuna click yaptım!
    }
}
