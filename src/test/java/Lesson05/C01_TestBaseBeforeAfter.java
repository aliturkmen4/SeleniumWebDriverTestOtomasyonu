package Lesson05;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_TestBaseBeforeAfter extends TestBaseBeforeAfter{ //C# taki katılım java da bu şekilde! (before afterları aldım(base classtan))
    @Test

    public void test() {
        driver.navigate().to("https://www.amazon.com.tr/");
    }
}
