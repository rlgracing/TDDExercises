package rlg.exercises.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://github.com/mwhelan/Katas/tree/master/Katas.StringCalculator
 */
public class StringCalculator {
    public int add(String numbers) throws Exception {

        if(numbers == null || numbers.isEmpty())
            return 0;

        int sum = 0;
        String delimiter = ",";
        if(numbers.indexOf("//") == 0 && numbers.indexOf("\n") >= 3) {
            delimiter = numbers.substring(numbers.indexOf("//"), numbers.indexOf("\n") + 1);
            numbers = numbers.replace(delimiter, "");

            delimiter = delimiter.replace("//", "").replaceFirst("\\n", "");

            if(delimiter.indexOf("[") == 0 && delimiter.indexOf("]") == delimiter.length() - 1) {
                delimiter = delimiter.replace("[", "").replaceFirst("]", "");
            }
        }

        if(numbers.contains("\n")) {
            numbers = numbers.replaceAll("\\n", delimiter);
        }

        StringTokenizer stringTokenizer = new StringTokenizer(numbers, delimiter);

        List<Integer> negatives = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()) {

            int num = Integer.parseInt(stringTokenizer.nextToken().trim());
            if(num < 0) {
                negatives.add(num);
            }

            if(negatives.size() == 0 && num <= 1000) {
                sum += num;
            }
        }

        if(negatives.size() > 0) {
            throw new Exception("negatives not allowed: " + negatives.toString());
        }

        return sum;
    }
}
