package SykoraTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Function {
    private static final Logger logger = LogManager.getLogger(App.class);

    //------------------------------------Funkce pro hledání prvočísel z pole listu----------------------------------------
    public static List<Long> onlyPrimeNumbers(List<Long> inputDataFromFile) {
        logger.info("Processing prime numbers");
        boolean isPrime = true;
        List<Long> primesNumbersList = new ArrayList<>();
        for (Long number : inputDataFromFile) {
            if (number < 2)
                continue;
            if (number == 2) {
                primesNumbersList.add(number);
                continue;
            }
            for (long i = 2; i < Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primesNumbersList.add(number);
            isPrime = true;
        }
        logger.info("Finished processing prime numbers");
        return primesNumbersList;
    }

//------------------------------------Funkce pro generování prvočísel v daném rozsahu----------------------------------

//    public static List<Long> findPrimeNumbers(long min, long max) {
//        List<Long> result = new ArrayList<>();
//        boolean isPrime = true;
//        for (long i = min; i <= max; i++) {
//            for (long j = 2; j <= Math.sqrt(i); j++) {
//                if (i % j == 0){
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime)
//                result.add(i);
//            isPrime = true;
//        }
//        return result;
//    }
}

