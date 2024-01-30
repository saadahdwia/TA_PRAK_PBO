package View;

import View.Person;

// Class for Patient extending View.Person
public class Pasien extends Person {
    String NIK;
    String bpjsNumber;

    // Constructor
    public Pasien(String name, String address, String gender, String dateOfBirth, String NIK, String bpjsNumber) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.NIK = NIK;
        this.bpjsNumber = bpjsNumber;
    }

    // Getter methods
    public String getNIK() {
        return NIK;
    }

    public String getBpjsNumber() {
        return bpjsNumber;
    }
}