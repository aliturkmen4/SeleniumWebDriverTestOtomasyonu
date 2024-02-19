package Lesson06;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test

    public void test() {
        System.out.println(System.getProperty("user.dir")); // path yolumu gösterir!
        // C:\Users\alitu\IdeaProjects\JUnitFramework

        String anaDizin=System.getProperty("user.home");
        System.out.println(anaDizin); //C:\Users\alitu

        String file="C:\\Users\\alitu\\OneDrive\\Masaüstü\\deneme.txt";
        Assert.assertTrue(Files.exists(Paths.get(file))); //file ın konumunda varlığını test ettim! (bu dosya masaüstünde var mı?)
    }
}
