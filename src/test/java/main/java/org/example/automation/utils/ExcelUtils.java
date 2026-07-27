package main.java.org.example.automation.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import main.java.org.example.automation.apitesting.User;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExcelUtils {

    public void readDataFromExcel(String src){
        try {
            FileInputStream fis =new FileInputStream(src);
            XSSFWorkbook workbook  =  new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            String row = sheet.getRow(1).getCell(0).getStringCellValue();
         }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @DataProvider
    public Object[][] readUserName(){
        return new Object[][]{
                {
                    "test1"
                },
                {
                    "test2"
                }
        };

    }

    public String readJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        User user =mapper.readValue("src/test/user.json", User.class);
        return user.getLastName();
    }
    public void manageBrokenLinks() throws IOException {
         for(int i=0;i<5;i++){
             HttpURLConnection conn = (HttpURLConnection) new URL("www.com").openConnection();
             conn.setRequestMethod("HEAD");
             conn.connect();
             if(conn.getResponseCode()>=400){
                 System.out.println("Broken link: "+conn.getURL());
             }
         }
    }
}
