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

    @Test
    public void knowsAboutMultiply() throws Exception {
        assertThat(queryProcessor.process("f7b1b440: what is 42 multiplied by 11"), is("462"));
    }

    @Test
    public void squareAndCude()
    {
        String query = "1eef1d50: which of the following numbers is both a square and a cube: 519, 16, 476, 117649";
        assertThat(queryProcessor.process(query), is("117649"));
    }

    @Test
    public void squareAndCube2()
    {
        String query = "f528e040: which of the following numbers is both a square and a cube: 569, 1000000";
        assertThat(queryProcessor.process(query), is("1000000"));
    }

    @Test
    public void squareAndCube3()
    {
        String query = "f528e040: which of the following numbers is both a square and a cube: 1089, 988";
        assertThat(queryProcessor.process(query), is(""));
    }


}
