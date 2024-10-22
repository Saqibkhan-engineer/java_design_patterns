/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Saqib Khan
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        // Creating observers
        HexaObserver hexaObserver = new HexaObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        BinaryObserver binaryObserver = new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);

        // Detaching the HexaObserver
        System.out.println("\nDetaching HexaObserver...");
        subject.detach(hexaObserver);

        System.out.println("Second state change: 10");
        subject.setState(10);  // Now only OctalObserver and BinaryObserver will be notified
    }
}

