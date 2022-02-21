package onlineExams;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Mahsa
 * Date: 2/11/19
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringTheory {
    public static void main(String[] arg) {
        String s = "My Name Is Mahsa";
        System.out.print(putPV(s));
    }

    private static String putPV(String p) {

        String[] vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
        for (String str : vowels)
            p = p.replaceAll(str, "pv" + str);

        return p;
    }

    private static String reverse(String str) {
        String[] split = str.split(" ");
        for (int i = split.length - 1; i >= 0; i--) {
            str = getReverse(split[i]+ " ");
        }
        return str;
    }

    private static String getDash(String p) {
        return p.replace(" ", "-");
    }

    private static String getReverse(String str) {
        String reverse = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            } else {
                c = Character.toLowerCase(c);
            }
            reverse = reverse + c;
        }
        System.out.print(reverse);
        return reverse;
    }

    private static int getCountVowel(String p) {
        String lowerCaseString = p.toLowerCase();
        int vowelCount = 0;
        for (int i = 0; i < lowerCaseString.length(); ++i) {
            Character charCharacter = lowerCaseString.charAt(i);
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            if (Arrays.binarySearch(vowels, charCharacter) >= 0) {
                vowelCount += 1;
            }
        }
        System.out.print(vowelCount);
        return vowelCount;
    }

    private static int getCharWithOutDupCount(String str) {

        str = str.toLowerCase();
        char[] inp = str.toCharArray();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (inp[i] == inp[j]) {

                    cnt++;
                    break;
                }
            }
        }
        System.out.print(cnt);
        return cnt;
    }

}