package onlineExams;

/**
 * Created with IntelliJ IDEA.
 * User: Mahsa
 * Date: 2/11/19
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvertEnglishToMorse {
    static String[] ensglish = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
            "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "0","!", ",", "?", ".", "'"};

    static String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----","-.-.--", "--..--", "..--..", ".-.-.-", ".----.",};


    public static String decodeEnglish(String englishCode) {
        String build = "";
        String change = englishCode.trim();
        String[] words = change.split(" ");
        for(String word : words){
            for(int i=0;i<word.length();i++){
                for(int x=0; x<morse.length;x++){
                    if(word.substring(i, i+1).equalsIgnoreCase(ensglish[x])){
                        build=build+morse[x]+" ";
                    }
                }
            }
            build+="  ";
        }
        return build;
    }

    public static void main(String[] args){
        System.out.println(decodeEnglish("hello my name is broque, what is your name?"));
    }
}