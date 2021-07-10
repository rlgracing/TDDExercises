package rlg.exercises;

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
