package com.math.addition;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

public class IntegerSumTest {
    private IntegerSum sum;
    private int a;
    private int b;
    private int c;

    @BeforeGroups("random-integers")
    public void setup() {
        a = ThreadLocalRandom.current().nextInt(0, 100);
        b = ThreadLocalRandom.current().nextInt(0, 100);
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

    @Test(groups = "random-integers")
    public void getResult_WillConformToAdditionsCommutativityProperty_GivenSomeRandomNumbersAsInput() {
        // Given
        IntegerSum sum = new IntegerSum(a, b);
        IntegerSum otherSum = new IntegerSum(b, a);

        // Then
        Assert.assertEquals(sum, otherSum);
    }

    @Test(groups = "random-integers")
    public void getResult_WillConformToAdditionsAssociativityProperty_GivenSomeRandomNumbersAsInput() {
        // Given
        IntegerSum sum = new IntegerSum(a, b).plus(c);
        IntegerSum otherSum = new IntegerSum(b, c).plus(a);

        // Then
        Assert.assertEquals(sum, otherSum);
    }

    @Test(groups = "random-integers")
    public void getResult_WillConformToAdditionsDistributivityProperty_GivenSomeRandomNumbersAsInput() {
        // Given
        IntegerSum sum = new IntegerSum(a, b);

        // When
        Integer result = sum.getResult() * 3;
        IntegerSum otherSum = new IntegerSum(3 * a, 3 * b);

        // Then
        Assert.assertTrue(otherSum.equals(result));
    }
}
