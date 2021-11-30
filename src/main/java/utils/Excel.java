package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Excel {
    public static ArrayList<Map<String,String>> readExcel(String filepath, String sheetname) throws IOException {

        ArrayList<Map<String,String>> listaDatosPlanTrabajo = new ArrayList<>();

        Map<String,String> informacionProyecto = new HashMap<>();

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);

        XSSFWorkbook newWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkBook.getSheet(sheetname);

        Iterator<Row> rowIterator = newSheet.iterator();

        Row titulos = rowIterator.next();

        while (rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                switch (cell.getCellType()){
                    case STRING:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),String.valueOf(cell.getNumericCellValue()));
                        break;
                    case BLANK:
                        informacionProyecto.put(titulos.getCell(cell.getColumnIndex()).toString(),"");
                        break;
                    default:
                        break;
                }
            }

            listaDatosPlanTrabajo.add(informacionProyecto);
            informacionProyecto = new HashMap<String,String>();
        }

        return listaDatosPlanTrabajo;
    }
}
