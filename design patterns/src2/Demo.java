package refactoring_guru.observer.example;

import refactoring_guru.observer.example.editor.Editor;
import refactoring_guru.observer.example.listeners.EmailNotificationListener;
import refactoring_guru.observer.example.listeners.LogOpenListener;
import refactoring_guru.observer.example.listeners.SMSSupportListener;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();

        // Subscribe LogOpenListener and EmailNotificationListener
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        // Subscribe SMSSupportListener with a valid SMS message (under 160 characters)
        editor.events.subscribe("save", new SMSSupportListener("+1234567890", "This is a test SMS message under 160 characters."));

        // Subscribe SMSSupportListener with a long SMS message (over 160 characters)
        editor.events.subscribe("save", new SMSSupportListener("+1234567890", 
                "This is a test SMS message that is intentionally made longer than 160 characters to trigger the warning " + 
                "that asks the user to define a valid default SMS message. This message will not be sent."));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
