import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class DataValidationApp {
    // Regular expressions for validation
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

    private JFrame frame;
    private JTextField nameField, emailField, phoneField;
    private JPasswordField passwordField;
    private JLabel nameLabel, emailLabel, phoneLabel, passwordLabel;

    public DataValidationApp() {
        // Initialize the frame
        frame = new JFrame("Data Validation Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        // Name input field
        frame.add(new JLabel("Name (min 3 chars):"));
        nameField = new JTextField(20);
        nameLabel = new JLabel();
        frame.add(nameField);
        frame.add(nameLabel);

        // Email input field
        frame.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        emailLabel = new JLabel();
        frame.add(emailField);
        frame.add(emailLabel);

        // Phone number input field
        frame.add(new JLabel("Phone (10 digits):"));
        phoneField = new JTextField(20);
        phoneLabel = new JLabel();
        frame.add(phoneField);
        frame.add(phoneLabel);

        // Password input field
        frame.add(new JLabel("Password (min 8 chars, 1 uppercase, 1 lowercase, 1 digit):"));
        passwordField = new JPasswordField(20);
        passwordLabel = new JLabel();
        frame.add(passwordField);
        frame.add(passwordLabel);

        // Submit button
        JButton submitButton = new JButton("Submit");
        frame.add(submitButton);
        submitButton.addActionListener(e -> validateData());

        // Add real-time feedback
        nameField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validateName();
            }
        });
        emailField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validateEmail();
            }
        });
        phoneField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validatePhone();
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validatePassword();
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void validateData() {
        if (validateName() && validateEmail() && validatePhone() && validatePassword()) {
            JOptionPane.showMessageDialog(frame, "All fields are valid!");
        } else {
            JOptionPane.showMessageDialog(frame, "Please fix the errors!");
        }
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name.length() >= 3) {
            nameLabel.setText("Valid");
            nameLabel.setForeground(Color.GREEN);
            return true;
        } else {
            nameLabel.setText("Invalid (min 3 characters)");
            nameLabel.setForeground(Color.RED);
            return false;
        }
    }

    private boolean validateEmail() {
        String email = emailField.getText();
        if (EMAIL_PATTERN.matcher(email).matches()) {
            emailLabel.setText("Valid");
            emailLabel.setForeground(Color.GREEN);
            return true;
        } else {
            emailLabel.setText("Invalid Email Format");
            emailLabel.setForeground(Color.RED);
            return false;
        }
    }

    private boolean validatePhone() {
        String phone = phoneField.getText();
        if (PHONE_PATTERN.matcher(phone).matches()) {
            phoneLabel.setText("Valid");
            phoneLabel.setForeground(Color.GREEN);
            return true;
        } else {
            phoneLabel.setText("Invalid Phone Number");
            phoneLabel.setForeground(Color.RED);
            return false;
        }
    }

    private boolean validatePassword() {
        String password = new String(passwordField.getPassword());
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            passwordLabel.setText("Valid");
            passwordLabel.setForeground(Color.GREEN);
            return true;
        } else {
            passwordLabel.setText("Invalid (must be at least 8 chars with uppercase, lowercase, digit)");
            passwordLabel.setForeground(Color.RED);
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DataValidationApp::new);
    }
}
