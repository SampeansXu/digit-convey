package com.fenio.entity;

import com.fenio.consist.ResultCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Conveyer result *
 *
 * @author Administrator
 * @create 2020/2/8 0008
 * @since 1.0.0
 */
public class ConveyerResult {
    /**
     * Convey result code
     */
    public ResultCode resultCode = ResultCode.Success;

    /**
     * the result which convey digits to letters
     */
    public List<String> conveyLetters = new ArrayList<>();

    /**
     * make conveyLetters to string
     * @return
     */
    public String toString() {
        String strTemporary = "";
        if (conveyLetters != null) {
            for (String str : conveyLetters) {
                if (strTemporary.isEmpty()) {
                    strTemporary = str;
                } else {
                    strTemporary += " " + str;
                }
            }
        }

        return strTemporary;
    }
}
