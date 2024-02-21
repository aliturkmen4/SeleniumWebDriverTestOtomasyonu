package Lesson07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C06_ReadExcel {
    @Test

    public void readExcelTest() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String excel="src/resources/takimlar.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excel);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //Sayfa1 deki excel tablosundaki tüm tabloyu konsola yazdırınız
        String tablo="";
        for (int i=0;i<workbook.getSheet("Sayfa1").getLastRowNum();i++){
            tablo=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString()+" "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+" "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+" "+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(tablo);
        }
    }
}
