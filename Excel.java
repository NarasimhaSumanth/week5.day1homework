package week5.day1homework;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	public static String[][] readData(String fileName) throws IOException {

//set the path of the excel workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+fileName+".xlsx");

		// get into the sheet
		XSSFSheet ws = wb.getSheetAt(0);

		// get no of rows from the excel
		int rowCount = ws.getLastRowNum();
		System.out.println(rowCount);

		int rows = ws.getPhysicalNumberOfRows();
		System.out.println(rows);
		
		// get Column Count
		XSSFRow header = ws.getRow(0);
		int columnCount = header.getLastCellNum();
		System.out.println(columnCount);
		
		String[][] data = new String[rowCount][columnCount];
		
		// Get the data from second row and first column
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				// Retrieve the data from the cell
				String cellValue = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(cellValue);
				data[i-1][j] = cellValue;
			}
		}
		// Close workbook
		wb.close();
		return data;
		
		
	

	}

}
