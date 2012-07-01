package com.develogical.web;

import com.develogical.QueryProcessor;

import java.io.PrintWriter;

public class ResultsPage extends HtmlPage {

    private final String query;

    public ResultsPage(String query) {
        this.query = query;
    }

    @Override
    protected void writeContentTo(PrintWriter writer) {
        String result = new QueryProcessor().process(query);
        if (result == null) {
            writer.println("<p>Nothing known about " + query + "</p>");
        } else {
            writer.println("<h1>" + query + "</h1>");
            writer.println("<p>" + result + "</p>");
        }

        writer.println("<p><a href=\"/\">Back to Search Page</a></p>");
    }
}
