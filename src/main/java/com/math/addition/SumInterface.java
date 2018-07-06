package com.math.addition;

public interface SumInterface {
    Number getResult();

    SumInterface plus(SumInterface... terms);

    SumInterface plus(Number... terms);
}
