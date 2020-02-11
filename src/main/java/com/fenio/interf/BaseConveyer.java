package com.fenio.interf;

import com.fenio.entity.ConveyerResult;

/**
 * Conveyer base class *
 * @author Administrator
 * @create 2020/2/8 0008
 * @since 1.0.0
 */
public interface BaseConveyer {
    boolean initialize();
    ConveyerResult doConvey(String source);
    void setEnabled(boolean isEnabled);
}
