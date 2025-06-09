package RestAssured.Basic.Day11ExcelIntegration.Resources;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ExcelDataTest {
    @DataProvider(name = "CreateLibrary")
    public Object[][] getObjects() throws IOException {
    XSSFWorkbook xssfWorkbook=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/src/main/java/RestAssured/Basic/Day11ExcelIntegration/Resources/Excel/ExcelData.xlsx")));
        XSSFSheet sheet=xssfWorkbook.getSheet("BookData");
        int row=sheet.getLastRowNum();
        int coloumn=sheet.getRow(0).getLastCellNum();
        Object[][] objects=new Object[row][1];
        HashMap<String,String> hashMap=null;
        for(int i=1;i<=row;i++){
            hashMap=new HashMap<>();
            for (int j=0;j<coloumn;j++){
                String key=sheet.getRow(0).getCell(j).getStringCellValue();
                String value=sheet.getRow(i).getCell(j).getStringCellValue();
                hashMap.put(key,value);
            }
            objects[i-1][0]=hashMap;
        }
        return objects;
    }
}
