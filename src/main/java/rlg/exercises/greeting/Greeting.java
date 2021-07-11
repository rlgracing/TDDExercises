package rlg.exercises.greeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://medium.com/@marlenac/learning-tdd-with-katas-3f499cb9c492
 * https://github.com/testdouble/contributing-tests/wiki/Greeting-Kata
 */
public class Greeting {

    private static final String GREETING = "Hello";
    private static final String PERIOD_MARK = ".";
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String EXCLAMATION_MARK = "!";
    private static final String AND = "and";
    private static final String MY_FRIEND = "my friend";

    private String interpolate(String name) {
        StringBuilder sb = new StringBuilder();

        if(name.equals(name.toUpperCase())) {

            return sb.append(GREETING)
                    .append(SPACE)
                    .append(name.trim())
                    .append(EXCLAMATION_MARK)
                    .toString()
                    .toUpperCase();
        } else {

            return sb.append(GREETING)
                    .append(COMMA)
                    .append(SPACE)
                    .append(name.trim())
                    .append(PERIOD_MARK)
                    .toString();
        }
    }

    private String interpolate(String... names) {
        StringBuilder sb = new StringBuilder();
        List<String> shoutList = new ArrayList<>();
        List<String> normalList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {

            if(names[i].equals(names[i].toUpperCase())) {

                shoutList.add(names[i]);

            } else {

                normalList.add(names[i]);
            }
        }

        sb.append(GREETING)
                .append(COMMA)
                .append(SPACE);

        for(int i = 0 ; i < normalList.size() ; i++) {
            String normalName = normalList.get(i);
            sb.append(normalName.trim());

            if(normalList.size() - (i+1) > 1) {
                sb.append(COMMA)
                        .append(SPACE);
            } else {
                if((i+1) < normalList.size()) {
                    sb.append(SPACE)
                            .append(AND)
                            .append(SPACE);
                }
            }
        }

        sb.append(PERIOD_MARK);

        if(!shoutList.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();

            for (String n: shoutList) {
                sb2.append(SPACE)
                        .append(AND)
                        .append(SPACE)
                        .append(GREETING)
                        .append(SPACE)
                        .append(n)
                        .append(EXCLAMATION_MARK);

                sb.append(sb2.toString().toUpperCase());
            }
        }

        return sb.toString();
    }

    private String[] normalize(String... names) {

        List<String> resultNames = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            if(names[i].startsWith("\"") && names[i].endsWith("\"")) {
                Collections.addAll(resultNames, names[i].replace("\"", ""));
            } else {
                String[] tempName = names[i].split(",");
                Collections.addAll(resultNames, tempName);
            }
        }

        return resultNames.toArray(new String[0]);
    }

    public String greet(String... names) {

        if(names == null) {
            return interpolate(MY_FRIEND);
        } else {
            String[] newNames = normalize(names);

            if(newNames.length == 1) {
                return interpolate(newNames[0]);
            } else {
                return interpolate(newNames);
            }
        }
    }
}
