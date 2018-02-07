package com.paypal.algorithms;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SelectionSort {

    private int steps;

    public <T> void sort(T[] input, Comparator<T> comparator) {
        sortNonRecursive(input, comparator, 0);
    }

    private  <T> void sort(T[] input, Comparator<T> comparator, int startIndex) {
        if (startIndex == input.length - 1 || input.length == 0) {
            return;
        }
        int minIndex = min(input, comparator, startIndex);
        swap(input, startIndex, minIndex);
        sort(input, comparator, startIndex + 1);
    }

    private  <T> void sortNonRecursive(T[] input, Comparator<T> comparator, int startIndex) {
        if (input.length == 0) {
            return;
        }
        for (int i = startIndex; i < input.length - 1; i++) {
            int minIndex = min(input, comparator, i);
            swap(input, i, minIndex);
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

    private <T> int min(T[] input, Comparator<T> comparator, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < input.length; i++) {
            steps++;
            if (comparator.compare(input[i], input[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        Random random = new Random(32);
        Comparator<Integer> comparator = (Integer a, Integer b) -> a.compareTo(b);
        Integer[] array = IntStream.generate(() -> random.nextInt(100)).limit(100)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
        SelectionSort sortAlgorithm = new SelectionSort();
        sortAlgorithm.sort(array, comparator);
        System.out.println(Stream.of(array).map(Object::toString).collect(Collectors.joining(",")));
        System.out.println(sortAlgorithm.steps);
    }
}
