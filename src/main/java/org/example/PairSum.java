package org.example;

import java.util.*;

public class PairSum{

    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 7, 1, 5};
        int target = 6;

        Set<String> result = pairedElement(numbers, target);

        // Print the result
        result.forEach(pair -> System.out.println(pair));
    }


    public static Set<String> pairedElement(int[] arr, int sum) {
        Set<String> pairs = new HashSet<>();

        for (int x : arr) {
            for (int y : arr) {
                if (x + y == sum) {
                    String pair1 = "(" + x + "," + y + ")";
                    String pair2 = "(" + y + "," + x + ")";
                    // Add the pair only if its reverse is not already present
                    if (!pairs.contains(pair2)) {
                        pairs.add(pair1);
                    }
                }
            }
        }
        return pairs;
    }
}
