package com.quecode.springrecipes.calculator.operation;

import com.quecode.springrecipes.calculator.Operation;
import org.springframework.stereotype.Component;

@Component
public class Addition implements Operation {

    /**
     * 더하기
     * @param lhs
     * @param rhs
     * @return int
     */
    @Override
    public int apply(int lhs, int rhs) {
        return lhs + rhs;
    }

    /**
     * 더하기 구분
     * @param op
     * @return boolean
     */
    @Override
    public boolean handles(char op) {
        return '+' == op;
    }
}
