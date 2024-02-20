package Lesson07;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel{
    @Test

    public void readExcelTest() throws IOException {
        //Dosya yolunu bir String degiskene atayalim
        String excel="src/resources/takimlar.xlsx";

        //FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(excel);

        //Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet objesi olusturun
        //Row objesi olusturun
        //Cell objesi olusturun
        String actualData=workbook.getSheet("Sayfa1").getRow(4).getCell(1).toString();
        System.out.println(actualData);
        String expectedData="Bayer Munih";
        Assert.assertEquals(expectedData,actualData);
    }
}
