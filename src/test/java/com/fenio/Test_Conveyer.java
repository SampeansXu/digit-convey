package com.fenio;

import com.fenio.consist.ResultCode;
import com.fenio.entity.ConveyerResult;
import com.fenio.entity.Digit2LetterConveyer;
import org.junit.Assert;
import org.junit.Test;

public class Test_Conveyer {

    private void PrintResult(String input, ConveyerResult result) {
        System.out.println("Input: " + input);
        if (result.resultCode == ResultCode.Success) {
            System.out.println("Output: " + result.toString());
        } else {
            System.out.println("Failed. Message:" + result.resultCode.getMessage());
        }
        System.out.println("");
    }

    @Test
    public void Test_Digit2LetterConveyer() {
        //test convey digits to letters
        Assert.assertTrue(Digit2LetterConveyer.getInstance().initialize());
        Digit2LetterConveyer.getInstance().setEnabled(true);

        ConveyerResult result = new ConveyerResult();
        String strTemporary = "1";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "4";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "a";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "99";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "102";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "2,99";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "0,23,3,4,57,1,99";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);

        strTemporary = "23,3,454,57,1";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);


        //set transfer unable
        Digit2LetterConveyer.getInstance().setEnabled(false);

        strTemporary = "4";
        result = Digit2LetterConveyer.getInstance().doConvey(strTemporary);
        PrintResult(strTemporary, result);
    }
}
