package rlg.exercises.buzzfizz;

public class DivisibleValidator {
    public DivisibleValidator() {
    }

    public static boolean isDivisible(int number, int divider) {
        return number % divider == 0;
    }
}