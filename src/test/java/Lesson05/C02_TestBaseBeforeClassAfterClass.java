package Lesson05;

import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_TestBaseBeforeClassAfterClass extends TestBaseBeforeClassAfterClass {
    @Test

    public void test() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
    }
}
