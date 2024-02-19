package Lesson05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {
    @Test
    public void actionsTest() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.navigate().to("https://demoqa.com/droppable");
        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement draggeble=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions action=new Actions(driver);
        Thread.sleep(2000);
        action.dragAndDrop(draggeble,dropHere).perform();
        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[@id='dropped']")));
    }
}
