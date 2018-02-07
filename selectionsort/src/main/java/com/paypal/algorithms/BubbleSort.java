package com.paypal.algorithms;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BubbleSort {
    private int steps;

    public <T> void sort(T[] input, Comparator<T> comparator) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                steps++;
                if (comparator.compare(input[j], input[j + 1]) > 0) {
                    swap(input, j, j + 1);
                }
            }
        }
    }

    private <T> void swap(T[] array, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


    public static void main(String[] args) {
        Random random = new Random(3);
        Comparator<Integer> comparator = (Integer a, Integer b) -> a.compareTo(b);
        Integer[] array = IntStream.generate(() -> random.nextInt(100)).limit(100)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
        BubbleSort sortAlgorithm = new BubbleSort();
        sortAlgorithm.sort(array, comparator);
        System.out.println(Stream.of(array).map(Object::toString).collect(Collectors.joining(",")));
        System.out.println(sortAlgorithm.steps);
    }

}
