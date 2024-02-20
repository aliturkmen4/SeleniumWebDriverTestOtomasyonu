package Lesson07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test

    public void test() throws IOException {
        //Dosya yolunu bir String degiskene atayalim
        //FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String excel="src/resources/takimlar.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excel);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //sayfa 2'ye gidip satir sayisinin 17, kullanilan satir sayisinin ise 5 oldugunu test edin
        int sonSatir=workbook.getSheet("Sayfa2").getLastRowNum(); //dolu olan son satıra bakar!
        System.out.println(sonSatir);
        int expectedLastRow=17;
        Assert.assertEquals(expectedLastRow,sonSatir+1);

        int kullanilanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows(); //aralıklı olarak 17.satıra kadar ama totalde 5 satır dolu onu test ettim!
        System.out.println(kullanilanSatirSayisi);
        int expectedUsedRow=5;
        Assert.assertEquals(expectedUsedRow,kullanilanSatirSayisi);
    }
}
