submitButton.addActionListener(e -> validateData());

private void validateData() {
    if (validateName() && validateEmail() && validatePhone() && validatePassword()) {
        JOptionPane.showMessageDialog(frame, "All fields are valid!");
    } else {
        JOptionPane.showMessageDialog(frame, "Please fix the errors!");
    }
}
