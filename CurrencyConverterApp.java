import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JComboBox<String> baseCurrencyComboBox, targetCurrencyComboBox;
    private JTextField amountField, resultField;
    private JButton convertButton;
    private JCheckBox realTimeCheckBox;

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel baseLabel = new JLabel("Base Currency:");
        baseLabel.setBounds(20, 20, 100, 20);
        add(baseLabel);

        baseCurrencyComboBox = new JComboBox<>(new String[]{"INR", "USD"});
        baseCurrencyComboBox.setBounds(150, 20, 100, 20);
        add(baseCurrencyComboBox);

        JLabel targetLabel = new JLabel("Target Currency:");
        targetLabel.setBounds(20, 50, 100, 20);
        add(targetLabel);

        targetCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "CAD", "JPY", "CNY", "BTC"});
        targetCurrencyComboBox.setBounds(150, 50, 100, 20);
        add(targetCurrencyComboBox);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 80, 100, 20);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(150, 80, 100, 20);
        add(amountField);

        convertButton = new JButton("Convert");
        convertButton.setBounds(20, 110, 100, 20);
        add(convertButton);

        resultField = new JTextField();
        resultField.setBounds(20, 140, 250, 20);
        resultField.setEditable(false);
        add(resultField);

        realTimeCheckBox = new JCheckBox("Real-Time Rates");
        realTimeCheckBox.setBounds(20, 170, 150, 20);
        add(realTimeCheckBox);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convert();
            }
        });

        realTimeCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement fetching real-time rates if needed
            }
        });
    }

    private void convert() {
        // Implement currency conversion logic here
        // Fetch exchange rates if real-time checkbox is selected
        // Calculate converted amount and update resultField
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverter().setVisible(true);
            }
        });
    }
}
