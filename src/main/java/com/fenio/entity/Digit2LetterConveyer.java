package com.fenio.entity;

import com.fenio.consist.ResultCode;
import com.fenio.interf.BaseConveyer;
import com.fenio.utils.NumberInputRegex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * the conveyer digits to letters *
 *
 * @author Administrator
 * @create 2020/2/8 0008
 * @since 1.0.0
 */
public class Digit2LetterConveyer implements BaseConveyer {
    public static Digit2LetterConveyer getInstance() {
        if (instance == null) {
            synchronized (Digit2LetterConveyer.class) {
                if (instance == null) {
                    instance = new Digit2LetterConveyer();
                }
            }
        }

        return instance;
    }

    private volatile static Digit2LetterConveyer instance;

    private Digit2LetterConveyer() {
    }


    private boolean isEnabled = true;
    private Map<String, String> codeMap;

    @Override
    public boolean initialize() {
        this.codeMap = new HashMap<String, String>() {{
            put("0", " ");
            put("1", " ");
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        this.isEnabled = true;

        return true;
    }

    /**
     * convey digits to letters
     * @param source: input digits
     * @param conveying: the conveying string which digits to letters
     * @param target: convey result
     */
    private void convey(String source, String conveying, List<String> target) {
        if (source.length() == 0) {
            target.add(conveying);
        } else {
            String digit = source.substring(0, 1);
            String letterTab = this.codeMap.get(digit);
            for (int i = 0; i < letterTab.length(); i++) {
                String letter = letterTab.substring(i, i + 1);
                convey(source.substring(1), conveying + letter.trim(), target);
            }
        }
    }

    @Override
    public ConveyerResult doConvey(String source) {
        ConveyerResult result = new ConveyerResult();
        if (!this.isEnabled || this.codeMap.isEmpty()) {
            result.resultCode = ResultCode.ConveyerUnable;
            return result;
        }
        if (!NumberInputRegex.isNumInput(source)) {
            result.resultCode = ResultCode.InputInvalid;
            return result;
        }

        //convey digits to letters
        String strDigits = source.replace(",", "");
        convey(strDigits, "", result.conveyLetters);

        return result;
    }

    @Override
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
