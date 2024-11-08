package org.example;

import lombok.Getter;

@Getter
public class SMS {
    private String phoneNumber;
    private String message;

    public SMS(String phoneNumber, String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public String toString() {
        return "SMS to " + phoneNumber + ": " + message;
    }
}
