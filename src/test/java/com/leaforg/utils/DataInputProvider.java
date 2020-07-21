package com.leaforg.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider {
	
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public String text;
	
	public Object[][] readValuesFromExcel(String file)
	{
		try
		{
			FileInputStream fis = new FileInputStream(file);
			wb 		= new XSSFWorkbook(fis);
			sheet 	= wb.getSheetAt(0);
			
			int rowSize 	= sheet.getLastRowNum();
			int cellSize 	= sheet.getRow(0).getLastCellNum();
			
			Object[][] data = new Object[rowSize][cellSize];
			
			for(int i=1;i<=rowSize;i++)
			{
				row = sheet.getRow(i);
				for(int j=0;j<cellSize;j++)
				{
					text = row.getCell(j).getStringCellValue();
					System.out.println(text);
					if(text.equals(""))
					{
						data[i-1][j]="";
					}
					else
					{
						data[i-1][j] = text;
					}
				}
			}
			
			return data;
			
		}
		catch(Exception e)
		{
			System.out.println("Issue in reading the values from excel successfully >>>"+e.getMessage());
		}
		return null;
	}

}
