private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

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
