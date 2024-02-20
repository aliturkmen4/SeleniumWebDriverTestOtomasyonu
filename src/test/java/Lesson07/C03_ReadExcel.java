package Lesson07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    @Test

    public void readExcelTest() throws IOException {
        //Belirtilen satırNo ve sutunNo değerlerini parametre olarak alıp o cell'deki datayı konsola yazdıralım
        //Sonucun konsolda yazanla aynı olduğunu doğrulayın
        int satirNo=3;
        int sutunNo=2;
        String excel="src/resources/takimlar.xlsx";
        FileInputStream fis=new FileInputStream(excel);
        Workbook workbook= WorkbookFactory.create(fis);
        String actualData=workbook.getSheet("Sayfa1").getRow(satirNo-1).getCell(sutunNo-1).toString(); //index e çevirmek için 1 çıkardım!
        String expectedData="Real Madrid";
        Assert.assertEquals(expectedData,actualData);
        System.out.println(actualData);
    }
}
