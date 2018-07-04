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

    @Override
    public IntegerSum plus(SumInterface... terms) {
        Integer tempSum = result;

        for (SumInterface sum : terms) {
            tempSum += sum.getResult().intValue();
        }

        return new IntegerSum(tempSum);
    }

    @Override
    public IntegerSum plus(Number... terms) {
        Integer tempSum = result;

        for (Number term : terms) {
            tempSum += term.intValue();
        }

        return new IntegerSum(tempSum);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SumInterface)) {
            return false;
        }

        return result.equals(((SumInterface) obj).getResult().intValue());
    }
}
