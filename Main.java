import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/*
 * Main.java
 * ATM Interface
 * Coder: Namrata Ingle
 * Copyright (c) [2023] Namrata Ingle. All rights reserved.
 */

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds. Withdrawal failed.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}

class ATMGUI extends JFrame {
    private BankAccount userAccount;

    public ATMGUI(BankAccount account) {
        this.userAccount = account;
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ATM Interface (Indian Rupees)");

        JPanel mainPanel = new JPanel(new BorderLayout());

        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        outputArea.setBackground(new Color(255, 255, 204)); // Light yellow background color
        outputArea.setForeground(Color.BLUE); // Text color
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14)); // Font style

        outputArea.append("Welcome to the ATM!\n");
        JScrollPane scrollPane = new JScrollPane(outputArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        JComboBox<String> optionsDropdown = new JComboBox<>(new String[]{"Withdraw", "Deposit", "Check Balance", "Exit"});
        JTextField amountField = new JTextField(10);
        JButton executeButton = new JButton("Execute");

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) optionsDropdown.getSelectedItem();
                switch (selectedOption) {
                    case "Withdraw":
                        handleWithdraw(amountField.getText());
                        break;
                    case "Deposit":
                        handleDeposit(amountField.getText());
                        break;
                    case "Check Balance":
                        handleCheckBalance();
                        break;
                    case "Exit":
                        handleExit();
                        break;
                    default:
                        break;
                }
            }
        });

        inputPanel.add(new JLabel("Select Option:"));
        inputPanel.add(optionsDropdown);
        inputPanel.add(new JLabel("Amount:"));
        inputPanel.add(amountField);
        inputPanel.add(executeButton);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void handleWithdraw(String amountText) {
        try {
            double amount = Double.parseDouble(amountText);
            if (amount > 0) {
                if (userAccount.withdraw(amount)) {
                    JOptionPane.showMessageDialog(null, "Withdrawal successful. Remaining balance: ₹" + formatCurrency(userAccount.getBalance()), "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleDeposit(String amountText) {
        try {
            double amount = Double.parseDouble(amountText);
            if (amount > 0) {
                userAccount.deposit(amount);
                JOptionPane.showMessageDialog(null, "Deposit successful. New balance: ₹" + formatCurrency(userAccount.getBalance()), "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive value.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCheckBalance() {
        JOptionPane.showMessageDialog(null, "Current balance: ₹" + formatCurrency(userAccount.getBalance()), "Balance", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleExit() {
        JOptionPane.showMessageDialog(null, "Exiting. Thank you!", "Exit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private String formatCurrency(double amount) {
        DecimalFormat currencyFormat = new DecimalFormat("#,###.00");
        return currencyFormat.format(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(3000.0);
        SwingUtilities.invokeLater(() -> {
            new ATMGUI(userAccount).setVisible(true);
        });
    }
}
