package refactoring_guru.observer.example.listeners;

import java.io.File;

public class SMSSupportListener implements EventListener {
    private String phoneNumber;
    private String defaultMessage;

    public SMSSupportListener(String phoneNumber, String defaultMessage) {
        this.phoneNumber = phoneNumber;
        this.defaultMessage = defaultMessage;
    }

    @Override
    public void update(String eventType, File file) {
        if (defaultMessage.length() > 160) {
            System.out.println("Warning: The SMS message exceeds 160 characters. Please define a valid default SMS.");
        } else {
            System.out.println("Sending SMS to " + phoneNumber + ": " + defaultMessage);
        }
    }
}
