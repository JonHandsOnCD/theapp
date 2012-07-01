package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {
    private Pattern plus = Pattern.compile(".{8,8}: what is (\\d+) plus (\\d+)");
    private Pattern multiplyBy = Pattern.compile(".{8,8}: what is (\\d+) multiplied by (\\d+)");
    private Pattern largest = Pattern.compile(".{8,8}: which of the following numbers is the largest: (.*)");
    private Pattern squareCube = Pattern.compile(".{8,8}: which of the following numbers is both a square and a cube: (.*)");

    public String process(String query) {
        if (query.contains("SPA2012")) {
            return "SPA is a conference where we do stuff";
        }
        if (query.contentEquals("SPA")) {
            return "wet stuff";
        }
        Matcher result = plus.matcher(query);
        if (result.matches()) {
            Integer first = Integer.parseInt(result.group(1));
            Integer second = Integer.parseInt(result.group(2));
            return String.valueOf(first+second);
        }

        result = multiplyBy.matcher(query);
        if (result.matches()) {
            Integer first = Integer.parseInt(result.group(1));
            Integer second = Integer.parseInt(result.group(2));
            return String.valueOf(first*second);
        }

        result = largest.matcher(query);
        if (result.matches()) {
            String list[] = result.group(1).split(", ");
            int largestSoFar = 0;
            for(String number: list)
            {
                int current = Integer.parseInt(number);
                if (current > largestSoFar) largestSoFar = current;
            }
            return String.valueOf(largestSoFar);
        }

        result = squareCube.matcher(query);
        if (result.matches()) {
            String list[] = result.group(1).split(", ");
            int answer = 0;
            for(String number: list)
            {
                double current = Double.parseDouble(number);
                if (
                    wholeNumber(Math.sqrt(current) )
                    && wholeNumber(Math.cbrt(current)))
                {
                    answer = Integer.parseInt(number);
                    break;
                }
            }
            return String.valueOf(answer);
        }




        return "";
    }

    private boolean wholeNumber(double x)
    {
        return (Math.floor(x) == x);
    }
}
