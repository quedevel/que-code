package com.quecode.springrecipes.calculator;

public interface Operation {

    /**
     * 연산
     * @param lhs
     * @param rhs
     * @return int
     */
    int apply(int lhs, int rhs);

    /**
     * 연산 구분
     * @param op
     * @return boolean
     */
    boolean handles(char op);
}
