package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelData {
	  String excelpath1 = "C:\\Users\\lmakn\\OneDrive\\Desktop\\ExcelData1.xlsx";
	  
	  public String[] readExcel() throws IOException {
		  
		  	String[] data = new String[5];
			FileInputStream fis = new FileInputStream(excelpath1);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell1 = row.getCell(0);
			String userId = cell1.getStringCellValue();
			Cell cell2 = row.getCell(1);
			String newPassword = cell2.getStringCellValue();
			Cell cell3 = row.getCell(2);
			String repeatPassord = cell3.getStringCellValue();
			
			data[0]=userId;
			data[1]=newPassword;
			data[2]=repeatPassord;
	  
			return data;
		  
	  }
}
