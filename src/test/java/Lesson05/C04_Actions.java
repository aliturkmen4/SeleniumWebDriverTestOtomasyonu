package Lesson05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test

    public void actionsTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //Cizgili alan bölümün uzerinde sag click yapalim
        WebElement line=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions action=new Actions(driver);
        action.contextClick(line).perform(); //sağ click yapmak için kullanılır!

        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(expectedText,actualText);

        //Tamam diyerek alert’i kapatalim
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> windowList=new ArrayList<>(driver.getWindowHandles()); //yeni bir pencere açtığım için!
        driver.switchTo().window(windowList.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='hero__title']")).isDisplayed());
    }
}
