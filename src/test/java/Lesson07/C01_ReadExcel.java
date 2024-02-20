package Lesson07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test

    public void readExcelTest() throws IOException {
        //Dosya yolunu bir String degiskene atayalim
        String excel="src/resources/takimlar.xlsx";

        //FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(excel); //dosyaları okuyabilmek için gerekli kütüphanem --> FileInputStream

        //Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim --> apache poi kütüphanesinde yer alıyor!
        Workbook workbook= WorkbookFactory.create(fis);

        //Sheet objesi olusturun
        Sheet sheet=workbook.getSheet("Sayfa1"); //gitmesi gereken sayfayı belirttim!

        //Row objesi olusturun
        Row row=sheet.getRow(3); //(satır sırası 4.satır yani 3.index)

        //Cell objesi olusturun
        Cell cell=row.getCell(2); //(sütun sırası 3.sütun yani 2. index)

        //3. index'deki satirin 2. index'indeki datanin Norvec oldugunu test edin
        String expectedData="Norvec";
        String actualData=cell.toString(); //yazdırabilmek için!
        Assert.assertEquals(expectedData,actualData);
        System.out.println(actualData);

    }
}
