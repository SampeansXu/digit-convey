package com.fenio.utils;

import java.util.regex.Pattern;

/**
 * number regex *
 * @author Administrator
 * @create 2020/2/8 0008
 * @since 1.0.0
 */
public class NumberInputRegex {

    /**
     * the regex for number input.Just array or number consists of Numbers from 0 to 99 is true
     * @param str: input string
     * @return
     */
    public static boolean isNumInput(String str){
        Pattern pattern = Pattern.compile("^\\d{1,2}(,\\d{1,2})*");
        return pattern.matcher(str).matches();
    }
}
