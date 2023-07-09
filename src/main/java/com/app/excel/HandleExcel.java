package com.app.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class HandleExcel {

    public String pathFile = "C:\\dev\\esncr\\src\\main\\resources\\dummy.xlsx";

    public boolean verifyIdIsPresent(String idToVerify) {
        try {
            File file = new File(pathFile);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0); // get the first cell of the row (assuming ID is in the first column)
                if (cell != null && cell.getCellType() == CellType.STRING && idToVerify.equals(cell.getStringCellValue())) {
                    return true;
                }
            }


        }catch (Exception exception){

        }
        return false;
    }
}
