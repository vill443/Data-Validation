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
