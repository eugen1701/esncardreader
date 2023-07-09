package com.app.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class HandleExcel {

    static public String pathFile = "C:\\dev\\esncr\\src\\main\\resources\\dummy.xlsx";

    static public boolean verifyIdIsPresent(String idToVerify) {
        try {
            File file = new File(pathFile);
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0); // get the first cell of the row (assuming ID is in the first column)
                CellType type = cell.getCellType();
                if(type == CellType.NUMERIC) {
                    DataFormatter formatter = new DataFormatter();
                    String stringCell = formatter.formatCellValue(cell);
                    if(stringCell.equals(idToVerify))
                        return true;
                }
                if (type == CellType.STRING && cell.getStringCellValue().startsWith(idToVerify)) {
                    return true;
                }
            }


        }catch (Exception exception){
            System.out.println(exception);
        }
        return false;
    }
}
