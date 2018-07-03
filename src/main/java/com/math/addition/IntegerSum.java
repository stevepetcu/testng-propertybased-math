package com.math.addition;

public final class IntegerSum implements SumInterface {
    private final Integer result;

    public IntegerSum(Integer... terms) {
        Integer sum = 0;

        for (Integer term : terms) {
            sum += term;
        }

        result = sum;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
