package com.base;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
		
		public static String[][] excelHandling(String path, String sheetName) throws IOException {
			FileInputStream fis = new FileInputStream(path);
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows(); // to get used row count
			Row row = sheet.getRow(0);
			int colCount = row.getPhysicalNumberOfCells();// to get used cell count
			String[][] data=new String [rowCount][colCount];
			DataFormatter df=new DataFormatter();
			for (int i = 0; i < rowCount; i++) {
				for(int j=0;j<colCount;j++) {
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
			for (int i = 0; i < rowCount; i++) {
				for(int j=0;j<colCount;j++) {
				//System.out.println(data[i][j]);
				}
			}
			
		return data;
	}

	

}

