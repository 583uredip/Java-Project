
package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Transaction;
import controllers.TransactionController;

public class TransactionOperationFrame extends JFrame 
{
    private JTextField transactionIdField, userIdField, typeField, priceField;
    private JButton updateButton, buyButton;
    private JLabel messageLabel;
    private TransactionController transactionController;

    public TransactionOperationFrame() {
        transactionController = new TransactionController();

        // Set up the frame
        setTitle("Transaction Operations");
        setSize(1000, 1000); // Adjusted for better UI
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setLayout(null);

        // Labels and Fields
        JLabel transactionIdLabel = new JLabel("Transaction ID:");
        transactionIdLabel.setBounds(50, 50, 120, 25);
        add(transactionIdLabel);

        transactionIdField = new JTextField();
        transactionIdField.setBounds(180, 50, 250, 25);
        add(transactionIdField);

        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setBounds(50, 90, 120, 25);
        add(userIdLabel);

        userIdField = new JTextField();
        userIdField.setBounds(180, 90, 250, 25);
        add(userIdField);

        JLabel typeLabel = new JLabel("Type (Buy/Sell):");
        typeLabel.setBounds(50, 130, 120, 25);
        add(typeLabel);

        typeField = new JTextField();
        typeField.setBounds(180, 130, 250, 25);
        add(typeField);

        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setBounds(50, 170, 120, 25);
        add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(180, 170, 250, 25);
        add(priceField);

        updateButton = new JButton("Update Transaction");
        updateButton.setBounds(50, 220, 180, 30);
        add(updateButton);

        buyButton = new JButton("Buy Coin");
        buyButton.setBounds(250, 220, 180, 30);
        add(buyButton);

        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 270, 400, 25);
        add(messageLabel);

        // Add action listeners
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTransaction();
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyCoin();
            }
        });
    }

    private void updateTransaction() {
        try {
            String transactionId = transactionIdField.getText().trim();
            String userId = userIdField.getText().trim();
            String type = typeField.getText().trim();
            String priceText = priceField.getText().trim();

            // Input validation
            if (transactionId.isEmpty() || userId.isEmpty() || type.isEmpty() || priceText.isEmpty()) {
                messageLabel.setText("All fields are required!");
                return;
            }

            double price = Double.parseDouble(priceText);
            Transaction transaction = new Transaction(transactionId, userId, type, price);
            transactionController.updateTransaction(transaction);

            messageLabel.setText("Transaction updated successfully!");
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid price format!");
        } catch (Exception e) {
            messageLabel.setText("Error updating transaction.");
            e.printStackTrace();
        }
    }

    private void buyCoin() {
        try {
            String transactionId = transactionIdField.getText().trim();
            String userId = userIdField.getText().trim();
            String priceText = priceField.getText().trim();

            // Input validation
            if (transactionId.isEmpty() || userId.isEmpty() || priceText.isEmpty()) {
                messageLabel.setText("All fields are required!");
                return;
            }

            double price = Double.parseDouble(priceText);
            Transaction transaction = new Transaction(transactionId, userId, "Buy", price);
            transactionController.insertTransaction(transaction);

            increaseWalletBalance(userId, price);
            messageLabel.setText("Coin purchased successfully! Wallet balance updated.");
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid price format!");
        } catch (Exception e) {
            messageLabel.setText("Error processing purchase.");
            e.printStackTrace();
        }
    }

    private void increaseWalletBalance(String userId, double amount) {
        // Placeholder method for wallet balance update
        System.out.println("Wallet balance increased for user " + userId + " by " + amount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TransactionOperationFrame().setVisible(true);
            }
        });
    }
}
