package com.example.shopping;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingCalculatorTest {

    @DataProvider(name = "calcData")
    public Object[][] createData() {
        return new Object[][] {
                {100.0, 2, 10.0, 5.0, 189.0},
                {50.0, 4, 0.0, 0.0, 200.0},
                {120.0, 1, 50.0, 10.0, 66.0}
        };
    }

    @Test(dataProvider = "calcData", groups = {"calculation"})
    public void testCalculateTotal(double price, int quantity, double discount, double tax, double expected) {
        double result = ShoppingCalculator.calculateTotal(price, quantity, discount, tax);
        Assert.assertEquals(result, expected, 0.01);
    }

    @Test(groups = {"validation"})
    public void testApplyDiscount() {
        Assert.assertEquals(ShoppingCalculator.applyDiscount(1000, 10), 900.0);
    }

    @Test(groups = {"validation"})
    public void testApplyTax() {
        Assert.assertEquals(ShoppingCalculator.applyTax(100, 10), 110.0);
    }

    @Test(groups = {"average"})
    public void testAveragePrice() {
        double total = 200;
        int quantity = 4;
        Assert.assertEquals(ShoppingCalculator.averagePrice(total, quantity), 50.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions"})
    public void testNegativeValues() {
        ShoppingCalculator.calculateTotal(-10, 2, 5, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions"})
    public void testInvalidPercentage() {
        ShoppingCalculator.validateInputs(100, 2, 150, 10);
    }

    @Test(groups = {"validation"})
    public void testValidateInputsCorrect() {
        ShoppingCalculator.validateInputs(10, 2, 5, 10);
    }

    @Test(groups = {"average"})
    public void testAveragePriceException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> ShoppingCalculator.averagePrice(100, 0));
    }
}

