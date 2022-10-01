package com.rohini.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSXdata {

	@DataProvider(name = "testData")
	public String[][] getData(Method m) throws IOException {
		
		String excelsheetName = m.getName();
		File f = new File(System.getProperty("user.dir") + "/src/test/resources/testdata/testdatasaucedemo.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelsheetName);

		int totalRowNum = sheetName.getLastRowNum();
		int totalColNum = sheetName.getRow(1).getLastCellNum();

		DataFormatter format = new DataFormatter(); // to format all types of data in an uniform format
		String testData[][] = new String[totalRowNum][totalColNum];

		for (int i = 1; i <= totalRowNum; i++) {
			for (int j = 0; j < totalColNum; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}

		return testData;

	}
}
