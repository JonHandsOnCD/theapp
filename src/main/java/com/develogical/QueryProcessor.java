package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("SPA2012")) {
            return "SPA is a conference where we do stuff";
        } else if (query.contentEquals("SPA")) {
            return "wet stuff";
        }
        return "";
    }
}
