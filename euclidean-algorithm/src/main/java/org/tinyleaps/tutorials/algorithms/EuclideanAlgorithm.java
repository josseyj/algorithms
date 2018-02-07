package org.tinyleaps.tutorials.algorithms;

/**
 * Hello world!
 *
 */
public class EuclideanAlgorithm {
    
    public static Long greatestCommonDivisor(Long value1, Long value2) {
        if (value1 == 0L) return value2;
        if (value2 == 0L) return value1;
        
        if (value1 > value2) {
            return greatestCommonDivisor(value2, value1 % value2);
        } else {
            return greatestCommonDivisor(value1, value2 % value1);
        }
    }
}
