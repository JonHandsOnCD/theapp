package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.contains("SPA2012")) {
            return "SPA is a conference";
        } else if (query.contentEquals("SPA")) {
            return "watery stuff";
        }
        return "I have no knowledge of that subject";
    }
}
