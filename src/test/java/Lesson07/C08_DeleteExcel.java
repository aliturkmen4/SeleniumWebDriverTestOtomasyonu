package Lesson07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C08_DeleteExcel {
    @Test

    public void deleteExcelTest() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String excel="src/resources/takimlar.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(excel);

        // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //- Sheet objesi olusturun
        Sheet sheet=workbook.getSheet("Sayfa1");

        //- Row objesi olusturun
        Row row=sheet.getRow(2);

        //- Cell objesi olusturun
        Cell cell= row.getCell(2);

        //-3. Satır 3. Cell'deki veriyi silelim
        row.removeCell(cell);

        FileOutputStream fileOutputStream=new FileOutputStream(excel);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
