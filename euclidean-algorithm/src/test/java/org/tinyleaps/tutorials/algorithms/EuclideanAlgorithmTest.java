package org.tinyleaps.tutorials.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class EuclideanAlgorithmTest {
    
    @ParameterizedTest
    @MethodSource("testData")
    public void testGreatestCommonDivisor(Long value1, Long value2, Long result) {
        assertEquals(EuclideanAlgorithm.greatestCommonDivisor(value1, value2), result);
    }
    
    public static Stream<Arguments> testData() {
        return Stream.of(
            Arguments.of(4L, 6L, 2L),
            Arguments.of(1680L, 640L, 80L)
            );
    }
    
}
