package View;

import View.Person;

// Class for View.Doctor
public class Doctor extends Person {
    private String specialization;

    // Constructor
    public Doctor(String name, String address, String gender, String dateOfBirth, String specialization) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.specialization = specialization;
    }

    // Getter method
    public String getSpecialization() {
        return specialization;
    }
}