package com.paypal.algorithms;

import java.util.Arrays;

public class BinarySearch {

    public static int find(Comparable[] sortedItems, Comparable item) {

        if (sortedItems.length == 0) {
            return -1;
        }

        int start = 0;
        int end = sortedItems.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
//            System.out.println(String.format("start:%d;end:%d;mid:%d", start, end, mid));

            if (item.compareTo(sortedItems[mid]) == 0) {
                return mid;

            } else if (item.compareTo(sortedItems[mid]) > 0) {
                start = mid + 1;

            } else {
                end = mid - 1;

            }
        }

        return -1;
    }

    public static int findRecursive(Comparable[] sortedItems, Comparable item) {
        return findRecursive(sortedItems, 0, sortedItems.length - 1, item);
    }


    public static int findRecursive(Comparable[] sortedItems, int start, int end, Comparable item) {
        if (start > end) return -1;
        int mid = start + (end - start) / 2;

        if (item.compareTo(sortedItems[mid]) == 0) {
            return mid;
        } else if (item.compareTo(sortedItems[mid]) > 0) {
            return findRecursive(sortedItems, mid + 1, end, item);
        } else {
            return findRecursive(sortedItems, start, mid - 1, item);
        }
    }

    public static void main(String[] args) {
        String[] items = {"B", "C", "D", "E", "F", "G", "H", "I"};
        String item = "A";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "B";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "C";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "D";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "E";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "F";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "G";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "H";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "I";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));

        item = "J";
        System.out.println(find(items, item));
        System.out.println(findRecursive(items, item));
    }
}
