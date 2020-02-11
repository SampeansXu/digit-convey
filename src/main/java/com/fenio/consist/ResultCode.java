package com.fenio.consist;

/**
 * result code *
 *
 * @author Administrator
 * @create 2020/2/8 0008
 * @since 1.0.0
 */
public enum ResultCode {

    ConveyerUnable(3, "The Conveyer set unable"),
    InputInvalid(2, "Input string is invalid.The array or number must consists of Numbers from 0 to 99"),
    ConveyerNonsupport(1, "The Conveyer is nonsupport"),
    Success(0, "Done successfully");


    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
