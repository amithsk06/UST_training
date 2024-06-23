package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertToArray {
public static String[] getarray(File f, String s) {
	try {
		Workbook wb = new XSSFWorkbook(f);
		Sheet sheet = wb.getSheet(s);
		int rowC = sheet.getPhysicalNumberOfRows();
		String[] array =  new String[rowC];
		DataFormatter df = new DataFormatter();
		for(int i=0;i<rowC;i++) {
			array[i]= df.formatCellValue(sheet.getRow(i).getCell(0));
		}
		return array;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
}
