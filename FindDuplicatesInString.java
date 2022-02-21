package com.example.demo.otherSamples;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicatesInString {

    public static void main(String[] args) {
        String blogName = "I want to get an official job offer from";
        char[] chars = blogName.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else {
                map.put(c, 1);
            }
        }

        System.out.print("Duplicate characters : ");
        for (char c : map.keySet()) {
            if (map.get(c) > 1) {
                System.out.print(c);
            }
        }

        System.out.print(" ,Duplicate characters excluding white space : ");
        for (char c : map.keySet()) {
            if (map.get(c) > 1 && !Character.isWhitespace(c)) {
                System.out.print(c);
            }
        }

        System.out.print(", Distinct characters : ");
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                System.out.print(c);
            }
        }
    }
}