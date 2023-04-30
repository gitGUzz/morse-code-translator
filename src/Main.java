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


        Pattern pattern_for_word = Pattern.compile("^\\s*[A-Za-z0-9]*$"); // accepts withoutspaces
        Pattern pattern_for_morse = Pattern.compile("[.-]{1,5}(?> [.-]{1,5})*(?>[.-]{1,5}(?> [.-]{1,5})*)*");

        Matcher matcher_word = pattern_for_word.matcher(phrase);
        Matcher matcher_morse = pattern_for_morse.matcher(phrase);

        boolean matchesWord = matcher_word.matches();
        boolean matchesMorse = matcher_morse.matches();


        if(matchesWord){
            System.out.println("THIS IS A WORD MATCH!!");
            wordsToMorse(phrase);

            //TODO: wordsToMorse()

        }

        if(matchesMorse){
            System.out.println("_*_*_*__*_*_*_*__*______***_ MATHC!!!");

            //TODO: morseToWords()
        }


    }
    public static void morseToWords(String input){
        // check for space, if so, new words begins

        // input is "phrase"
    }

    public static void wordsToMorse(String input){
        // check for space, if so, new words begins

        // input is "phrase"

        String[] asdf = input.split("");
        String result = "";
        for (int i = 0; i < asdf.length; i++) {
            String[] letter = new String[]{asdf[i]};

            // switch and add to a array of .-..- one by one into a string then print

            System.out.print(Arrays.toString(letter));
        }
    }
}
