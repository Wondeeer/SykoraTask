package SykoraTask;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.List;

class FileManagerTest {

    @Test
    void loadPosNumFromExcel_onlyPositiveNumbers_True(){
        try {
            String fileName = "TestData.xlsx";
            ClassLoader classLoader = FileManagerTest.class.getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            InputStream inputStream = new FileInputStream(file);
            List<Long> result = FileManager.loadPosNumFromExcel(inputStream);
            for(Long number : result){
                assertTrue(number > 0);
            }
        }catch (IOException ignored){
        }
    }
}