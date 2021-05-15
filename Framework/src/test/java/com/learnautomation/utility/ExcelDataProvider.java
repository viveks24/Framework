package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src= new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis= new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
	
		} catch (Exception e) {
			
			System.out.println("Unable to read file"+e.getMessage());
		}
	}

	public String getstringvalue(String sheetname,int row,int cell)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	public double getnumericvalue(String sheetname,int row,int cell)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	
}
