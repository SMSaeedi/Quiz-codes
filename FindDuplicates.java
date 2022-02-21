package com.example.demo.otherSamples;

public class FindDuplicates {

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        int[] a = {1, 1, 2, 3, 4, 4, 2, 6, 8, 8, 7, 2};
        System.out.printf("result = " + findDuplicates.findDuplicates(a));
    }

    public int findDuplicates(int[] a) {
        if (a.length == 0)
            return 0;
        int j = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[j]) {
                a[++j] = a[i];
            }
        }
        return j++;
    }
}