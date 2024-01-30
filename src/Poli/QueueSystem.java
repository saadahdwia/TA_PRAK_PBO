package Poli;

// Class for Queue System
public class QueueSystem {
    static int queueNumber = 1;

    // Method to generate queue number
    public static int generateQueueNumber() {
        return queueNumber++;
    }
}
