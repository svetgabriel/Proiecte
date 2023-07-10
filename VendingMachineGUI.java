package vendingmachinegui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendingMachineGUI extends JFrame implements ActionListener {
    private double balance;
    private JLabel balanceLabel;
    
    public VendingMachineGUI() {
        setTitle("Vending Machine");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        balance = 0;
        
        createComponents();
        
        setVisible(true);
    }
    
    private void createComponents() {
        balanceLabel = new JLabel("Balance: $0");
        add(balanceLabel);
        
        JButton quarterButton = new JButton("$0.25");
        quarterButton.addActionListener(this);
        add(quarterButton);
        
        JButton halfDollarButton = new JButton("$0.50");
        halfDollarButton.addActionListener(this);
        add(halfDollarButton);
        
        JButton dollarButton = new JButton("$1.00");
        dollarButton.addActionListener(this);
        add(dollarButton);
        
        JButton cokeButton = new JButton("Coke ($1.00)");
        cokeButton.addActionListener(this);
        add(cokeButton);
        
        JButton chipsButton = new JButton("Chips ($1.00)");
        chipsButton.addActionListener(this);
        add(chipsButton);
        
        JButton croissantButton = new JButton("Croissant ($1.00)");
        croissantButton.addActionListener(this);
        add(croissantButton);
    }
    
    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: $" + balance);
    }
    
    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    private void buyItem(String item, double price) {
        if (balance >= price) {
            balance -= price;
            updateBalanceLabel();
            showMessageDialog("Enjoy your " + item + "!");
        } else {
            showMessageDialog("Insufficient Funds. Insert more coins.");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch (command) {
            case "$0.25" -> balance += 0.25;
            case "$0.50" -> balance += 0.50;
            case "$1.00" -> balance += 1.00;
            case "Coke ($1.00)" -> buyItem("Coke", 1.00);
            case "Chips ($1.00)" -> buyItem("Chips", 1.00);
            case "Croissant ($1.00)" -> buyItem("Croissant", 1.00);
        }
        
        updateBalanceLabel();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VendingMachineGUI vendingMachineGUI = new VendingMachineGUI();
        });
    }
}