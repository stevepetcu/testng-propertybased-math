package com.math.addition;

import java.util.Objects;

public interface SumInterface {
    Number getResult();

    SumInterface plus(SumInterface... terms);

    SumInterface plus(Number... terms);
}
