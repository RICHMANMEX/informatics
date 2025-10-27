package com.example.shopping;

public class ShoppingCalculator {

    public static double calculateTotal(double price, int quantity, double discount, double tax) {
        validateInputs(price, quantity, discount, tax);
        double subtotal = price * quantity;
        double afterDiscount = applyDiscount(subtotal, discount);
        double totalWithTax = applyTax(afterDiscount, tax);
        return totalWithTax;
    }

    public static void validateInputs(double price, int quantity, double discount, double tax) {
        if (price < 0 || quantity < 0 || discount < 0 || tax < 0)
            throw new IllegalArgumentException("Отрицательные значения не допустимы");
        if (discount > 100 || tax > 100)
            throw new IllegalArgumentException("Проценты не могут превышать 100%");
    }

    public static double applyDiscount(double subtotal, double discount) {
        return subtotal - subtotal * (discount / 100);
    }

    public static double applyTax(double amount, double tax) {
        return amount + amount * (tax / 100);
    }

    public static double averagePrice(double total, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Количество должно быть больше 0");
        return total / quantity;
    }
}