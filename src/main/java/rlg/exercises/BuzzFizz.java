package rlg.exercises;

/**
 * https://medium.com/@marlenac/learning-tdd-with-katas-3f499cb9c492
 * http://www.codingdojo.org/cgi-bin/index.pl?KataFizzBuzz
 */
public class BuzzFizz {

    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";

    public String process(int i) {
        String result = "";

        if(DivisibleValidator.isDivisible(i, 3)) {
            result += FIZZ;
        }

        if(DivisibleValidator.isDivisible(i, 5)) {
            result += BUZZ;
        }

        return result.isEmpty() ? String.valueOf(i) : result;
    }

    public static void main(String[] args) {
        BuzzFizz buzzFizz = new BuzzFizz();

        for (int i = 1; i <= 100; i++) {
            System.out.println(buzzFizz.process(i));
        }
    }
}
