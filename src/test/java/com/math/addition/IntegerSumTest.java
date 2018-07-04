package com.math.addition;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class IntegerSumTest {
    private IntegerSum sum;

    @BeforeGroups("random-integers")
    public void setup() {
        int a = ThreadLocalRandom.current().nextInt(0, 100),
                b = ThreadLocalRandom.current().nextInt(0, 100),
                c = ThreadLocalRandom.current().nextInt(0, 100);

        sum = new IntegerSum(a, b, c);
    }

    @Test
    public void getResult_WillReturnZero_GivenInstanceInitialisedWithEmptyArgumentList() {
        // Given
        sum = new IntegerSum();

        // Then
        Assert.assertEquals(sum.getResult().intValue(), 0);
    }

    @Test(groups = "random-integers")
    public void getResult_WillConformToAdditionsIdentityProperty_GivenSomeRandomNumbersAndZeroesAsInput() {
        // When
        IntegerSum newSum = sum.plus(0, 0, 0);

        // Then
        Assert.assertEquals(newSum, sum);
    }
}
