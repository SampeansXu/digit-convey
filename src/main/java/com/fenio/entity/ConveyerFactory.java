package com.fenio.entity;

import com.fenio.consist.ResultCode;

/**
 * Conveyer factory *
 *
 * @author Administrator
 * @create 2020/2/8 0008
 * @since 1.0.0
 */
public class ConveyerFactory {
    public static ConveyerFactory getInstance() {
        if (instance == null) {
            synchronized (ConveyerFactory.class) {
                if (instance == null) {
                    instance = new ConveyerFactory();
                }
            }
        }

        return instance;
    }

    private volatile static ConveyerFactory instance;

    private ConveyerFactory() {
    }

    /**
     * Conveyer type
     */
    public enum ConveyerType {
        /**
         * The conveyer type is normal.Just do nothing
         */
        Normal,

        /**
         * The conveyer type is digits to letters
         */
        Digit2Letter
    }

    /**
     * the factory support conveyers initialize
     * @return
     */
    public boolean initialize() {
        //Convey digits to letters initialize
        if (!Digit2LetterConveyer.getInstance().initialize()) {
            return false;
        }

        return true;
    }

    public ConveyerResult doConvey(ConveyerType conveyType, String input) {
        ConveyerResult result = new ConveyerResult();
        switch (conveyType) {
            case Digit2Letter: {
                //digits to letters
                result = Digit2LetterConveyer.getInstance().doConvey(input);
            }
            break;

            case Normal:
            default: {
                //Nonsupport, do nothing
                result.resultCode = ResultCode.ConveyerNonsupport;
            }
            break;
        }

        return result;
    }
}
