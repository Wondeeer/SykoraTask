package SykoraTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Scanner inputDictionary = new Scanner(System.in);
        File file;
        try {
            logger.info("Input absolute path to file.");
            file = new File(inputDictionary.nextLine().trim());
            InputStream inputStream = new FileInputStream(file);
            List<Long> dataFromFile = FileManager.loadPosNumFromExcel(inputStream);
            List<Long> result = Function.onlyPrimeNumbers(dataFromFile);
            for(long numbers : result){
                logger.info(numbers);
            }
            inputStream.close();
        } catch (IOException e) {
            logger.error("Incorrect path: " + e.getLocalizedMessage());
        }
    }
}
