import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the phrase: ");
        String phrase = sc.nextLine();

        // word                 >>  "^\s*[A-Za-z0-9]*$"
        // morse                >>  "[.-]{1,5}(?> [.-]{1,5})*(?>[.-]{1,5}(?> [.-]{1,5})*)*"

//        Pattern pattern_for_word = Pattern.compile("^\\s*[A-Za-z0-9]*$"); // accepts withoutspaces
        Pattern pattern_for_word = Pattern.compile("[\\w\\s]+\\s*[A-Za-z0-9]*$"); // accepts with spaces
//        Pattern pattern_for_morse = Pattern.compile("[.-]{1,5}(?> [.-]{1,5})*(?>[.-]{1,5}(?> [.-]{1,5})*)*"); // accepts no " / "
//        Pattern pattern_for_morse = Pattern.compile("[\\/ .-]{1,5}(?> [.-]{1,5})*(?>[.-]{1,5}(?> [.-]{1,5})*)*"); //for other
        Pattern pattern_for_morse = Pattern.compile("[\\/.\\-]{1,5}(?> [.\\-]{1,5})*(?>[.\\-]{1,5}(?> [.\\-]{1,5})*)*"); //for java

        Matcher matcher_word = pattern_for_word.matcher(phrase);
        Matcher matcher_morse = pattern_for_morse.matcher(phrase);

        boolean matchesWord = matcher_word.matches();
        boolean matchesMorse = matcher_morse.matches();


        if (matchesWord) {
            System.out.println("word match");
            wordsToMorse(phrase);
        } else if (matchesMorse) {
            System.out.println("morse code match");
            morseToWords(phrase); //TODO: find right regex pattern for matching " / "
        } else {
            System.out.printf("\n\nCan't find match for: \n[%s]", phrase);
        }

    }

    public static void morseToWords(String input) {
        String[] splitArr = input.split(" ");
        ArrayList<String> result = new ArrayList<>(splitArr.length);

        for (int i = 0; i < splitArr.length; i++) {
            String letter = splitArr[i];
            switch (letter) {
                case ".-" -> result.add("A");
                case "-..." -> result.add("B");
                case "-.-." -> result.add("C");
                case "-.." -> result.add("D");
                case "." -> result.add("E");
                case "..-." -> result.add("F");
                case "--." -> result.add("G");
                case "...." -> result.add("H");
                case ".." -> result.add("I");
                case ".---" -> result.add("J");
                case "-.-" -> result.add("K");
                case ".-.." -> result.add("L");
                case "--" -> result.add("M");
                case "-." -> result.add("N");
                case "---" -> result.add("O");
                case ".--." -> result.add("P");
                case "--.-" -> result.add("Q");
                case ".-." -> result.add("R");
                case "..." -> result.add("S");
                case "-" -> result.add("T");
                case "..-" -> result.add("U");
                case "...-" -> result.add("V");
                case ".--" -> result.add("W");
                case "-..-" -> result.add("X");
                case "-.--" -> result.add("Y");
                case "--.." -> result.add("Z");
                case ".----" -> result.add("1");
                case "..---" -> result.add("2");
                case "...--" -> result.add("3");
                case "....-" -> result.add("4");
                case "....." -> result.add("5");
                case "-...." -> result.add("6");
                case "--..." -> result.add("7");
                case "---.." -> result.add("8");
                case "----." -> result.add("9");
                case "-----" -> result.add("0");
                case "/" -> result.add(" ");
                default -> result.add("(?)");
            }
        }
        System.out.printf("%s ", String.join("", result));
    }

    public static void wordsToMorse(String input) {

        String[] splitArr = input.split("");
        ArrayList<String> result = new ArrayList<>(splitArr.length);

        for (int i = 0; i < splitArr.length; i++) {
            String letter = splitArr[i];
            switch (letter) {
                case "A", "a" -> result.add(".-");
                case "B", "b" -> result.add("-...");
                case "C", "c" -> result.add("-.-.");
                case "D", "d" -> result.add("-..");
                case "E", "e" -> result.add(".");
                case "F", "f" -> result.add("..-.");
                case "G", "g" -> result.add("--.");
                case "H", "h" -> result.add("....");
                case "I", "i" -> result.add("..");
                case "J", "j" -> result.add(".---");
                case "K", "k" -> result.add("-.-");
                case "L", "l" -> result.add(".-..");
                case "M", "m" -> result.add("--");
                case "N", "n" -> result.add("-.");
                case "O", "o" -> result.add("---");
                case "P", "p" -> result.add(".--.");
                case "Q", "q" -> result.add("--.-");
                case "R", "r" -> result.add(".-.");
                case "S", "s" -> result.add("...");
                case "T", "t" -> result.add("-");
                case "U", "u" -> result.add("..-");
                case "V", "v" -> result.add("...-");
                case "W", "w" -> result.add(".--");
                case "X", "x" -> result.add("-..-");
                case "Y", "y" -> result.add("-.--");
                case "Z", "z" -> result.add("--..");
                case "1" -> result.add(".----");
                case "2" -> result.add("..---");
                case "3" -> result.add("...--");
                case "4" -> result.add("....-");
                case "5" -> result.add(".....");
                case "6" -> result.add("-....");
                case "7" -> result.add("--...");
                case "8" -> result.add("---..");
                case "9" -> result.add("----.");
                case "0" -> result.add("-----");
                case " " -> result.add("/");
                default -> result.add("(?)");
            }
        }
        System.out.printf("%s ", String.join(" ", result));
    }
}
