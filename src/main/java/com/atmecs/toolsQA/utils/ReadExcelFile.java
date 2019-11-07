package com.atmecs.toolsQA.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atmecs.toolsQA.logreports.LogReports;

public class ReadExcelFile {
	static FileInputStream fileReader;
	static Workbook book;
	static Sheet sheet;
	static LogReports log = new LogReports();

	public Object[][] readExcel(String sheetName, String path)
	// sheet name to fetch data from particular // sheet
	{
		@SuppressWarnings("unused")
		FileInputStream file = null;
		try {
			fileReader = new FileInputStream(path);
			// set test data excel file as testData_path in // constants class

		} catch (FileNotFoundException e) {
			log.info("file not found");
		}
		try {
			book = WorkbookFactory.create(fileReader);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		// Read Every rows,columns and pass value to data provider

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static String[][] getUserData(String filePath) throws IOException {
		FileInputStream fileInput = new FileInputStream(filePath);
		XSSFWorkbook book = new XSSFWorkbook(fileInput);
		org.apache.poi.ss.usermodel.Sheet sheet = book.getSheetAt(0);
		int row1 = sheet.getLastRowNum();
		row1 += 1;
		int col = sheet.getRow(0).getLastCellNum();
		String array[][] = new String[row1][col];
		int count = 0;
		for (Row row : sheet) {
			int count1 = 0;
			for (Cell cell : row) {
				String Data = cell.toString();
				array[count][count1] = Data;
				count1++;
			}
			count++;

		}
		book.close();
		return array;

	}
}
