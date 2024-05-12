package com.driver;

import java.util.Objects;

public class Email {

    private final String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (isValid(oldPassword, newPassword)) {
            this.password = newPassword;
        }
    }

    // Change password only if the oldPassword is equal to current password and the
    // new password meets all of the following:
    // 1. It contains at least 8 characters
    // 2. It contains at least one uppercase letter
    // 3. It contains at least one lowercase letter
    // 4. It contains at least one digit
    // 5. It contains at least one special character. Any character apart from
    // alphabets and digits is a special character
    // Change password only if the oldPassword is equal to current password and the
    // new password meets all of the following:
    // 1. It contains at least 8 characters
    // 2. It contains at least one uppercase letter
    // 3. It contains at least one lowercase letter
    // 4. It contains at least one digit
    // 5. It contains at least one special character. Any character apart from
    // alphabets and digits is a special character
    private boolean isValid(String oldPassword, String newPassword) {
        boolean isValiad = !Objects.equals(this.password, oldPassword);
        isValiad = isValiad && (newPassword.length() >= 8);

        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        boolean specialCar = false;

        for (int i = 0; i < newPassword.length(); i++) {
            int c = newPassword.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                uppercase = true;
            } else if (c >= 'a' && c <= 'z') {
                lowercase = true;
            } else if (c >= '0' && c <= '1') {
                digit = true;
            } else {
                specialCar = true;
            }
        }

        isValiad = isValiad & uppercase & lowercase & digit & specialCar;
        return isValiad;
    }
}
