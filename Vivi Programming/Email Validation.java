private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

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
