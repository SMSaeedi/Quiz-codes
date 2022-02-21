package onlineExams;

/**
 * Created with IntelliJ IDEA.
 * User: Mahsa
 * Date: 2/11/19
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvertMorseToEnglish {
    static String[] ensglish = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0","!", ",", "?", ".", "'"};
    static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----","-.-.--", "--..--", "..--..", ".-.-.-", ".----.",};

    public static String decode(String morseCode) {
        String build = "";
        String change = morseCode.trim();
        String[] words = change.split("   ");
        for (String word : words) {
            for(String letter : word.split(" ")){
                for(int x=0;x<morse.length;x++){
                    if(letter.equals(morse[x]))
                        build=build+ensglish[x];
                }
            }
            build+=" ";
        }
        return build.toUpperCase();
    }

    public static void main(String[] args){
        System.out.println(decode(".... . .-.. .-.. ---   -- -.--   -. .- -- .   .. ...   -... .-. --- --.- ..- . --..--   .-- .... .- -   .. ...   -.-- --- ..- .-.   -. .- -- . ..--..   "));
    }
}