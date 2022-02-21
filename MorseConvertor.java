package onlineExams;

/**
 * Created with IntelliJ IDEA.
 * User: Mahsa
 * Date: 2/11/19
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class MorseConvertor {
    public static String run(boolean morseToEnglish, String textToTranslate) {

        String[] english = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "0", "!", ",", "?", ".", "'"};

        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
                "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--", "..--..", ".-.-.-", ".----.",};
        String n = "";

        if (morseToEnglish) {//morse to english
            if (textToTranslate.isEmpty() || textToTranslate.contains("    ")) {
                return n = "Invalid Morse Code Or Spacing";
            }
            String change = textToTranslate.trim();

            String[] words = change.split("   ");
            for (String word : words) {
                for (String letter : word.split(" ")) {
                    for (int x = 0; x < morse.length; x++) {
                        if (letter.equals(morse[x]))
                            n = n + english[x];
                    }
                }
                n += " ";
            }
        } else {//english to morse
            String change = textToTranslate.trim();
            String[] words = change.split(" ");
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    for (int x = 0; x < morse.length; x++) {
                        if (word.substring(i, i + 1).equalsIgnoreCase(english[x])) {
                            n = n + morse[x] + " ";
                        }
                    }
                }
                n += "  ";
            }
        }
        String translatedText = n;
        return translatedText;

    }

   public static void main(String[] str) {
        run(true, "Hello this is translator uses Morse algorithm");
    }
}