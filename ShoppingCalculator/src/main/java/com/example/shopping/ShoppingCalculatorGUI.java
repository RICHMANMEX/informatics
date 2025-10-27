package com.example.shopping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ShoppingCalculatorGUI extends JFrame {
    private JTextField priceField, quantityField, discountField, taxField;
    private JLabel resultLabel;

    public ShoppingCalculatorGUI() {
        setTitle("Калькулятор покупок");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));

        priceField = new JTextField();
        quantityField = new JTextField();
        discountField = new JTextField();
        taxField = new JTextField();
        resultLabel = new JLabel("Итог:");

        add(new JLabel("Цена товара:")); add(priceField);
        add(new JLabel("Количество:")); add(quantityField);
        add(new JLabel("Скидка (%):")); add(discountField);
        add(new JLabel("Налог (%):")); add(taxField);

        JButton calcButton = new JButton("Рассчитать");
        add(calcButton); add(resultLabel);

        calcButton.addActionListener(this::calculateAction);
    }

    private void calculateAction(ActionEvent e) {
        try {
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());
            double discount = Double.parseDouble(discountField.getText());
            double tax = Double.parseDouble(taxField.getText());

            double total = ShoppingCalculator.calculateTotal(price, quantity, discount, tax);
            resultLabel.setText(String.format("Итог: %.2f ₽", total));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingCalculatorGUI().setVisible(true));
    }
}

