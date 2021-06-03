package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import org.apache.commons.compress.archivers.dump.InvalidFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public String getExcelData(String sheetname, int rownum, int cellnum) {
		String retVal=null;
		try {
			
			FileInputStream fis=new FileInputStream("H:\\Selenium\\ERP Excel DataDriven.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheetname);
			Row r=s.getRow(rownum);
			Cell c=r.getCell(cellnum);
			retVal =c.getStringCellValue();
			
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(EncryptedDocumentException e) {
			e.printStackTrace();
		}
			catch(InvalidFormatException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		return retVal;
	}
	
	public int getLastRowNumber(String sheetname) {
		
		int retval=0;
		try {
			
			FileInputStream fis=new FileInputStream("H:\\Selenium\\ERP Excel DataDriven.xlsx");
			
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheetname);
			retval=s.getLastRowNum();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch(EncryptedDocumentException e) {
			e.printStackTrace();
		}
			catch(InvalidFormatException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		return retval;
	}

	
}
