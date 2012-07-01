package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {
    private Pattern plus = Pattern.compile(".{8,8}: what is (\\d+) plus (\\d+)");

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

        return "";
    }
}
