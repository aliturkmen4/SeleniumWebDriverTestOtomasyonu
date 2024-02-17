package Lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;
    @Before

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After

    public void tearDown() {
        driver.quit();
    }

    //https://the-internet.herokuapp.com/dropdown adresine gidin
    //Index kullanarak Option 1 i secin ve yazdirin
    //Value kullanarak Option 2 i secin ve yazdirin
    //Visible Text kullanarak Option 1 i  ve Option 2 i secin ve yazdirin
    //Tum dropdown degerleri yazddirin
    //Dropdown un boyutunu bulun, Dropdown da 4 oge varsa konsolda true, degilse false yazdirin

    @Test

    public void dropdownTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(1000);

        //Index kullanarak option1 i seçin ve yazdırın!
        WebElement ddmList=driver.findElement(By.cssSelector("#dropdown"));
        Select select=new Select(ddmList);
        select.selectByIndex(1); //indexler 0 dan başlar yani 1.index (2.seçeneği seçtim) (option1)
        System.out.println(select.getFirstSelectedOption().getText()); //combobox dan seçtiğim option ı yazdırdım!
        System.out.println("------------------------------------");
        Thread.sleep(1000);

        //Value kullanarak Option 2 i secin ve yazdirin
        select.selectByValue("2"); //value ya göre bu şekilde seçilir!
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("------------------------------------");
        Thread.sleep(1000);

        //Visible Text kullanarak Option 1 i  ve Option 2 i secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("------------------------------------");
        Thread.sleep(1000);

        //Tum dropdown degerleri yazddirin
        List<WebElement> ddmOptions=driver.findElements(By.xpath("//option"));
        for (WebElement w:ddmOptions){ //for un içinde sol tarafa türüm ve atayacağım isim, sağa ise locate im yazılır!
            System.out.println(w.getText());
        }
        System.out.println("------------------------------------");
        Thread.sleep(1000);

        //Dropdown un boyutunu bulun, Dropdown da 4 oge varsa konsolda true, degilse false yazdirin
        System.out.println("Dropdowndaki eleman sayisi: "+ddmOptions.size());
        if (ddmOptions.size()==4){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
