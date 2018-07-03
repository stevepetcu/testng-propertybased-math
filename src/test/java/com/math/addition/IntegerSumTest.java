package com.math.addition;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerSumTest {
    private IntegerSum sum;

    @Test
    public void getResult_WillReturnZero_GivenInstanceInitialisedWithEmptyArgumentList() {
        // Given
        sum = new IntegerSum();

        // Then
        Assert.assertEquals(sum.getResult(), 0, 0);
    }
}
