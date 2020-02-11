package com.fenio;

import com.fenio.utils.NumberInputRegex;
import org.junit.Assert;
import org.junit.Test;

public class Test_Regex {

    @Test
    public void Test_NumberInputRegex() {
        //test the regex for number input
        Assert.assertTrue(NumberInputRegex.isNumInput("0"));
        Assert.assertTrue(NumberInputRegex.isNumInput("5"));
        Assert.assertTrue(NumberInputRegex.isNumInput("9"));
        Assert.assertTrue(NumberInputRegex.isNumInput("a"));
        Assert.assertTrue(NumberInputRegex.isNumInput("01"));
        Assert.assertTrue(NumberInputRegex.isNumInput("99"));
        Assert.assertTrue(NumberInputRegex.isNumInput("023"));
        Assert.assertTrue(NumberInputRegex.isNumInput("1,"));
        Assert.assertTrue(NumberInputRegex.isNumInput("1,4"));
        Assert.assertTrue(NumberInputRegex.isNumInput("1,a,9"));
        Assert.assertTrue(NumberInputRegex.isNumInput("1,23,53,99"));
        Assert.assertTrue(NumberInputRegex.isNumInput("1,233,34"));
    }
}
