package Lesson04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        // driver.quit();
    }

    @Test

    public void IframeTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        //“An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.

        WebElement text=driver.findElement(By.xpath("//h3[normalize-space()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(text.isDisplayed());
        System.out.println(text.getText());
        Thread.sleep(2000);

        //Text Box’a “Merhaba Dunya!” yazin.

        WebElement iframeTextBox=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeTextBox);
        WebElement textBox=driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("Merhaba Dünya");
        Thread.sleep(2000);

        //TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin!

        //driver.switchTo().parentFrame(); ==> 1 üst seviyedeki frame e geçiş yapar!
        driver.switchTo().defaultContent(); // ==> en üst seviyedeki frame e çıkmak için kullanılır'
        WebElement link=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(link.isDisplayed());
        System.out.println(link.getText());

    }
}
