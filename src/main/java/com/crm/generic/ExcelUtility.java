package com.crm.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed using Apache poi libraries,which used to handel Microsoft Excel sheet
 * @author Siba
 *
 */
public class ExcelUtility {

	
/**
 * it is used to read the data from excel based on below arguments
 * @param sheetName
 * @param rownum
 * @param cellnum
 * @return Data
 * @throws Throwable
 */
	public String getDataFromExcel(String sheetName,int rownum,int cellnum) throws Throwable 
	{
	FileInputStream fis=new FileInputStream("./External data/Book1.xlsx");	
     Workbook wb = WorkbookFactory.create(fis);
      Sheet sh = wb.getSheet(sheetName);
      Row rw = sh.getRow(rownum);
      Cell cel = rw.getCell(cellnum);
      String data = cel.getStringCellValue();
      wb.close();
      return data;
	}

/**
 * it is used to get the last used row number on specified sheet
 * @param sheetName
 * @return
 * @throws Throwable
 */
public int getRowCount(String sheetName) throws Throwable
{
 FileInputStream fis=new FileInputStream("./External data/Book1.xlsx");
 Workbook wb = WorkbookFactory.create(fis);
  Sheet sh = wb.getSheet(sheetName);
  wb.close();
  return sh.getLastRowNum();
}

/**
 * this method is used to write the data in Excel file
 * @param sheetName
 * @param rownum
 * @param cellnum
 * @param data
 * @throws Throwable
 */
public void setDataExcel(String sheetName,int rownum,int cellnum,String data) throws Throwable
{
	FileInputStream fis=new FileInputStream("./External data/Book1.xlsx");
     Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet(sheetName);
	 Row rw = sh.getRow(rownum);
	 Cell cel = rw.getCell(cellnum);
	 cel.setCellValue(data);
	 FileOutputStream fos= new FileOutputStream("./External data/Book1.xlsx");
	 wb.write(fos);
	 wb.close();
}

}
