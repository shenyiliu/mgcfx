package com.pearadmin.modules.sys.context;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtils {
    public static String getCellValue( Cell cell )
    {
        if (cell != null)
        {
            switch (cell.getCellType())
            {
//                case XSSFCell.CELL_TYPE_BLANK:
//                    return null;
//                case XSSFCell.CELL_TYPE_BOOLEAN:
//                    return String.valueOf( cell.getBooleanCellValue() );
//                case XSSFCell.CELL_TYPE_NUMERIC:
//                    return String.valueOf( ( float ) cell.getNumericCellValue() );
//                case XSSFCell.CELL_TYPE_STRING:
//                    return cell.getRichStringCellValue().toString();

            }
        }
        return null;
    }
}


