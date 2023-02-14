package com.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ApachePOITest {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		File file = new File("C:\\Users\\K C K\\Desktop\\Excel sheets\\datasheet.xlsx");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook workbook = WorkbookFactory.create(inputStream);

		System.out.println("sheets = " + workbook.getNumberOfSheets());

		Sheet sheet = workbook.getSheet("Sheet1");

		System.out.println("Rows = " + sheet.getPhysicalNumberOfRows());

		System.out.println("first Row number = " + sheet.getFirstRowNum());

		System.out.println("last Row number = " + sheet.getLastRowNum());

		System.out.println("cells = " + sheet.getRow(0).getPhysicalNumberOfCells());

		System.out.println("first cell number = " + sheet.getRow(0).getFirstCellNum());

		System.out.println("last cell number = " + sheet.getRow(0).getLastCellNum());

		for (int row = sheet.getFirstRowNum(); row <= sheet.getLastRowNum(); row++) {
			for (int cell = sheet.getRow(row).getFirstCellNum(); cell < sheet.getRow(row).getLastCellNum(); cell++) {
				System.out.print(sheet.getRow(row).getCell(cell) + "\t");

			}
			System.out.println();
		}

		sheet.getRow(0).createCell(10).setCellValue("status");
		sheet.getRow(1).createCell(10).setCellValue("Active");
		sheet.getRow(2).createCell(10).setCellValue("In-Active");

		workbook.write(new FileOutputStream(file));

		sheet.getRow(0).createCell(10);
		sheet.getRow(1).createCell(10);
		sheet.getRow(2).createCell(10);

		workbook.write(new FileOutputStream(file));

		workbook.close();
	}

}
