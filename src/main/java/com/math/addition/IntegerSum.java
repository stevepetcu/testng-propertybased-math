package com.math.addition;

public final class IntegerSum implements SumInterface {
    private final int result;

    public IntegerSum(int... terms) {
        int sum = 0;

        for (int term : terms) {
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
        int partialResult = 0;

        for (SumInterface sum : terms) {
            partialResult += sum.getResult().intValue();
        }

        return new IntegerSum(this.result, partialResult);
    }

    @Override
    public IntegerSum plus(Number... terms) {
        int tempSum = result;

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

        if (!(obj instanceof SumInterface) && !(obj instanceof Number)) {
            return false;
        }

        if (obj instanceof SumInterface) {
            return result == ((SumInterface) obj).getResult().intValue();
        }

        return result == ((Number) obj).intValue();
    }
}
