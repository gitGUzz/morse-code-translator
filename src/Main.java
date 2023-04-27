import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public void morseToWords(String input){
        // check for space, if so, new words begins

        // input is "phrase"
    }

    public void wordsToMorse(String input){
        // check for space, if so, new words begins

        // input is "phrase"
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the phrase: ");
        String phrase = sc.nextLine();


        // SINGLE CHARACTER     >>  "[a-zA-Z]", Pattern.CASE_INSENSITIVE

        // word                 >>  ""
        // morse                >>  "[.-]{1,5}(?> [.-]{1,5})*(?>[.-]{1,5}(?> [.-]{1,5})*)*"

        // TODO: word  >> ""  [find whole word match]

        Pattern pattern_for_word = Pattern.compile("?");
        Pattern pattern_for_morse = Pattern.compile("[.-]{1,5}(?> [.-]{1,5})*(?>[.-]{1,5}(?> [.-]{1,5})*)*");

        Matcher matcher_word = pattern_for_word.matcher(phrase);
        Matcher matcher_morse = pattern_for_morse.matcher(phrase);

        boolean matchesWord = matcher_word.matches();
        boolean matchesMorse = matcher_morse.matches();


        if(matchesWord){
            System.out.println("THIS IS A WORD MATCH!!");

            //TODO: wordsToMorse()
        }

        if(matchesMorse){
            System.out.println("_*_*_*__*_*_*_*__*______***_ MATHC!!!");

            //TODO: morseToWords()
        }


    }
}
