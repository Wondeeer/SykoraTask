package SykoraTask;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class FileManager {
    private static final Logger logger = LogManager.getLogger(App.class);

/* Funkce pro načítání celých kladných čísel z exelu zjistí z každé buňky zda jsou dané data textového nebo číselného
   formátu a dále zpracovává, pokud je formát číselný tak pouze zkontroluje zda není menší než 1, pokud je formát
   textový tak text zarovná a zkusí převést na celočíselný datový typ, v případě neúspěchu buňku ignoruje.*/
    public static List<Long> loadPosNumFromExcel(InputStream inputStream) {
        logger.info("Loading file.");
        List<Long> primeNumbers = new ArrayList<>();
        try {
            Workbook wb = new XSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        if (cell.getNumericCellValue() < 1)
                            break;
                        primeNumbers.add((long) cell.getNumericCellValue());
                    } else {
                        if (cell.getStringCellValue().equals(""))
                            break;
                        if (cell.getCellType() == CellType.STRING) {
                            String Trimed = cell.toString().trim();
                            try {
                                if (Long.parseLong(Trimed) < 1) {
                                    logger.info("'" + Long.parseLong(Trimed) + "' " + "is negative number");
                                    break;
                                }
                                primeNumbers.add(Long.parseLong(Trimed));
                            } catch (NumberFormatException e) {
                                logger.info("'" + Trimed + "' " + "is incorrect number");
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        logger.info("Finished loading file.");
        return primeNumbers;
    }
}
