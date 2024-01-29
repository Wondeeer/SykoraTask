package SykoraTask;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    @Test
    void onlyPrimeNumbers_ShouldTakeLargeNumbersThanInteger(){
        List<Long> longPrimeNumbers = Arrays.asList(2147483659L, 2147483857L);
        List<Long> longNumbers = Arrays.asList(2147483659L,2147483658L, 2147483857L,2147483856L);
        assertEquals(longPrimeNumbers,Function.onlyPrimeNumbers(longNumbers));
    }
}