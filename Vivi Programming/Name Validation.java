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
