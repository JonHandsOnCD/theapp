package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.StringContains.containsString;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutSpa() throws Exception {
        assertThat(queryProcessor.process("SPA2012"), containsString("conference"));
    }

    @Test
    public void knowsAboutPlus() throws Exception {
        assertThat(queryProcessor.process("f7b1b440: what is 124 plus 201"), is("325"));
    }

    @Test
    public void findTheLargestNumber()
    {
        assertThat(queryProcessor.process("c9bcecd0: which of the following numbers is the largest: 60, 65, 978, 695"),
                containsString("978"));
    }
}
