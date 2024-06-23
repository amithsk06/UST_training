package com.ust.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	
	public static String[][] getExcelData(String path,String sheetname) throws IOException{	
		FileInputStream fis = new FileInputStream(path);
	//				apache poi-handle excel files
	//xlsx-XSSFworkbook
	//				xls-HSSFworkbook-->poi library
	Workbook workbook = new XSSFWorkbook(fis);
	Sheet sheet = workbook.getSheet(sheetname);
	int rowCount = sheet.getPhysicalNumberOfRows(); // to get used row count
	Row row = sheet.getRow(0);
	int colCount = row.getPhysicalNumberOfCells();// to get used cell count

	
	String data[][] = new String[rowCount][colCount];
	DataFormatter df=new DataFormatter();
	for (int i = 0; i < rowCount; i++) {
		for(int j=0;j<colCount;j++) {
		  data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
		}
	}
	
 

       return data;
}
}