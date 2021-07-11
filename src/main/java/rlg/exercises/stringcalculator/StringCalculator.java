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
        List<String> delimiters = new ArrayList<>();

        //add default delimiter
        delimiters.add(",");

        //Does it have delimiters definition?
        if(numbers.indexOf("//") == 0 && numbers.indexOf("\n") >= 3) {
            //Get the delimiter
            String delimiter = numbers.substring(numbers.indexOf("//"), numbers.indexOf("\n") + 1);

            //Get the numbers
            numbers = numbers.replace(delimiter, "");

            //Remove delimiter definition convention
            delimiter = delimiter.replace("//", "").replaceFirst("\\n", "");

            //Does is have complex delimiter specification?
            if(delimiter.contains("[") && delimiter.contains("]")) {
                delimiters = new ArrayList<>();

                //Get all complex delimiter definitions
                String[] delims = delimiter.split("\\[", 1);
                for (int i = 0; i < delims.length; i++) {
                    delimiters.add(delims[i].substring(0, delims[i].length() - 2));
                }
            } else {
                //Just a simple character delimiter definition
                delimiters = new ArrayList<>();
                delimiters.add(delimiter);
            }
        }

        //if delimiter is defined as a new line, replace them by default delimiter
        if(numbers.contains("\n")) {
            numbers = numbers.replaceAll("\\n", delimiters.get(0));
        }

        //Process adding according to all delimiter types separating those numbers
        for (String delim: delimiters) {
            StringTokenizer stringTokenizer = new StringTokenizer(numbers, delim);

            List<Integer> negatives = new ArrayList<>();
            while(stringTokenizer.hasMoreTokens()) {

                int num = Integer.parseInt(stringTokenizer.nextToken().trim());

                //Negative numbers are not allowed but need to be stored to be displayed in logs
                if(num < 0) {
                    negatives.add(num);
                }

                //No adding is performed if numbers are negative or greater than 1000
                if(negatives.size() == 0 && num <= 1000) {
                    sum += num;
                }
            }

            //If negative numbers were found, throw an exception displaying those numbers
            if(negatives.size() > 0) {
                throw new Exception("negatives not allowed: " + negatives.toString());
            }
        }

        return sum;
    }
}
