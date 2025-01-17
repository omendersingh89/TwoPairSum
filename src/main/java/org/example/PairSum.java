package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairSum {
    public static List<int[]> findPairs(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                int lower = Math.min(num, complement);
                int higher = Math.max(num, complement);
                String pairKey = lower + "," + higher;

                // Avoid duplicate pairs
                if (!uniquePairs.contains(pairKey)) {
                    result.add(new int[]{lower, higher});
                    uniquePairs.add(pairKey);
                }
            }
            seen.add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {2, 4, 3,3,7, 1, 5};
        int target = 6;
        List<int[]> pairs = findPairs(array, target);

        System.out.println("Pairs with sum " + target + ":");
        for (int[] pair : pairs) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
