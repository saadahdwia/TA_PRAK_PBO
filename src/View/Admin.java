package View;

import Poli.Polyclinic;

import java.util.List;
import java.util.Map;

// Class for View.Admin
public class Admin {
    // Method to add polyclinic
    public void addPolyclinic(List<Polyclinic> polyclinics, Polyclinic polyclinic) {
        polyclinics.add(polyclinic);
        System.out.println("Polyclinic added: " + polyclinic.getName());
    }

    // Method to print transaction details
    public void printTransactionDetails(int queueNumber, String polyclinicName, String doctorName) {
        System.out.println("Transaction Details:");
        System.out.println("No: " + queueNumber);
        System.out.println("Polyclinic: " + polyclinicName);
        System.out.println("lihat dokter: " + doctorName);
    }

    // Method to add doctor schedule
    public void addDoctorSchedule(Map<String, List<String>> doctorSchedules, String doctorName, List<String> schedule) {
        doctorSchedules.put(doctorName, schedule);
        System.out.println("View.Doctor schedule added for " + doctorName);
    }

    // Method to update doctor schedule
    public void updateDoctorSchedule(Map<String, List<String>> doctorSchedules, String doctorName, List<String> newSchedule) {
        doctorSchedules.put(doctorName, newSchedule);
        System.out.println("View.Doctor schedule updated for " + doctorName);
    }
}