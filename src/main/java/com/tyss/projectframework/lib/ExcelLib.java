 package com.tyss.projectframework.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;
import com.tyss.projectframework.init.IConstants;

public class ExcelLib {
	
	public static String getData(String sheet,int row,int cell,String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		String val="";
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Cell c=wb.getSheet(sheet).getRow(row).getCell(cell);	
		val=c.getStringCellValue();
		
		return val;
		
	}

}
