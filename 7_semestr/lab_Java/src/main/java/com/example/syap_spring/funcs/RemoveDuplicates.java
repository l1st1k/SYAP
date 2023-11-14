package com.example.syap_spring.funcs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);

        System.out.println("Original List: " + numbers);
        System.out.println("List with Duplicates Removed: " + uniqueNumbers);
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> uniqueSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer item : list) {
            if (uniqueSet.add(item)) {
                result.add(item);
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {}
        return result;
    }
}


