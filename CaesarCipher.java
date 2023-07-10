package caesarcipher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CaesarCipher extends JFrame {

    private JTextField messageTextField;
    private JTextField shiftTextField;

    public CaesarCipher() {
        setTitle("Caesar Cipher");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JLabel messageLabel = new JLabel("Message:");
        JLabel shiftLabel = new JLabel("Shift Value:");
        messageTextField = new JTextField();
        shiftTextField = new JTextField();
        JButton encryptButton = new JButton("Encrypt");
        JButton decryptButton = new JButton("Decrypt");
        
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        inputPanel.add(messageLabel);
        inputPanel.add(messageTextField);
        inputPanel.add(shiftLabel);
        inputPanel.add(shiftTextField);

        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        encryptButton.addActionListener((ActionEvent e) -> {
            String message = messageTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String encryptedMessage = encrypt(message, shift);
            showOutput("Encrypted Message", encryptedMessage);
        });

        decryptButton.addActionListener((ActionEvent e) -> {
            String encryptedMessage = messageTextField.getText();
            int shift = Integer.parseInt(shiftTextField.getText());
            String decryptedMessage = decrypt(encryptedMessage, shift);
            showOutput("Decrypted Message", decryptedMessage);
        });
    }

    public static String encrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char encryptedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
                    encrypted.append(encryptedChar);
                } else {
                    char encryptedChar = (char) ((ch - 'a' + shift) % 26 + 'a');
                    encrypted.append(encryptedChar);
                }
            } else if (Character.isDigit(ch)) {
                char encryptedChar = (char) ((ch - '0' + shift) % 10 + '0');
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(ch);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String encryptedMessage, int shift) {
        int decryptShift = 26 - (shift % 26);
        return encrypt(encryptedMessage, decryptShift);
    }

    private void showOutput(String title, String output) {
        JFrame outputFrame = new JFrame();
        outputFrame.setTitle(title);
        outputFrame.setSize(400, 200);
        outputFrame.setLocationRelativeTo(null);
        outputFrame.setLayout(new BorderLayout());

        JTextArea outputTextArea = new JTextArea(output);
        outputTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        outputFrame.add(scrollPane, BorderLayout.CENTER);
        outputFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CaesarCipher().setVisible(true);
        });
    }
}