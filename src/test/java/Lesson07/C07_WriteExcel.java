package Lesson07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C07_WriteExcel {
    @Test

    public void writeExcelTest() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        String excel="src/resources/takimlar.xlsx";
        FileInputStream fileInputStream=new FileInputStream(excel);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //1.Sayfa 5.hucreye yeni bir cell olusturalim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Puan");

        //2.satir PUAN kolonuna 85 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(85);

        //10.satir PUAN kolonuna 72 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue(72);

        //5.satir PUAN kolonuna 72 yazdiralim
        workbook.getSheet("Sayfa1").getRow(4).getCell(4).setCellValue(78);

        //Dosyayi kaydedelim
        FileOutputStream fileOutputStream=new FileOutputStream(excel); //yazdıklarımın kaydedilmesi için bunları yapmalıyım!
        workbook.write(fileOutputStream);

        //Dosyayi kapatalim
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }
}
