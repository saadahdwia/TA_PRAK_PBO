import Poli.Polyclinic;
import Poli.QueueSystem;
import View.Admin;
import View.Pasien;

import java.util.*;

// Main class
public class PuskesmasApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pasien> pasiens = new ArrayList<>();
        List<Polyclinic> polyclinics = new ArrayList<>();
        Polyclinic polyclinic1 = new Polyclinic("umum");
        Polyclinic polyclinic2 = new Polyclinic("gigi");
        Polyclinic polyclinic3 = new Polyclinic("anak");

        polyclinics.add(polyclinic1);
        polyclinics.add(polyclinic2);
        polyclinics.add(polyclinic3);

        Map<String, List<String>> doctorSchedules = new HashMap<>();
        Admin admin = new Admin();

        while (true) {
            System.out.println("Menu Puskesmas:");
            System.out.println("1. Pasien Baru");
            System.out.println("2. Ambil Nomor Antrian");
            System.out.println("3. Login Admin");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // New Patient
                    System.out.println("Masukkan detail pasien:");
                    System.out.print("Nama: ");
                    String name = scanner.next();
                    System.out.print("Alamat: ");
                    String address = scanner.next();
                    System.out.print("Jenis Kelamin: ");
                    String gender = scanner.next();
                    System.out.print("Tanggal Lahir: ");
                    String dateOfBirth = scanner.next();
                    System.out.print("NIK: ");
                    String NIK = scanner.next();
                    System.out.print("Nomor BPJS (jika ada): ");
                    String bpjsNumber = scanner.next();

                    Pasien patient = new Pasien(name, address, gender, dateOfBirth, NIK, bpjsNumber);
                    pasiens.add(patient);

                    System.out.println("Pasien berhasil ditambahkan!");
                    break;

                case 2:
                    // Take Queue Number
                    System.out.print("Masukkan NIK atau Nomor BPJS: ");
                    String patientIdentifier = scanner.next();
                    System.out.println("Pilih Poliklinik:");
                    for (int i = 0; i < polyclinics.size(); i++) {
                        System.out.println((i + 1) + ". " + polyclinics.get(i).getName());
                    }
                    System.out.print("Masukkan Pilihan: ");
                    int polyclinicChoice = scanner.nextInt();

                    String polyclinicName = polyclinics.get(polyclinicChoice - 1).getName();
                    int queueNumber = QueueSystem.generateQueueNumber();

                    System.out.println("Nomor Antrian: " + queueNumber);
                    admin.printTransactionDetails(queueNumber, polyclinicName, "Belum Ditentukan");
                    break;

                case 3:
                    // View.View.Admin Login
                    System.out.print("Masukkan kata sandi admin: ");
                    String password = scanner.next();
                    if (password.equals("admin123")) {
                        adminMenu(admin, polyclinics, doctorSchedules);
                    } else {
                        System.out.println("Kata sandi tidak valid. Coba lagi!");
                    }
                    break;

                case 4:
                    // Exit
                    System.out.println("Terima kasih telah menggunakan Aplikasi Puskesmas. Selamat tinggal!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opsi tidak valid. Harap pilih lagi.");
            }
        }
    }

    // View.View.Admin Menu
    private static void adminMenu(Admin admin, List<Polyclinic> polyclinics, Map<String, List<String>> doctorSchedules) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Admin:");
            System.out.println("1. Tambah Poliklinik");
            System.out.println("2. Cetak Detail Transaksi");
            System.out.println("3. Tambah Jadwal Dokter");
            System.out.println("4. Perbarui Jadwal Dokter");
            System.out.println("5. Logout");
            System.out.print("Pilih opsi: ");
            int adminOption = scanner.nextInt();

            switch (adminOption) {
                case 1:
                    // Add Poli.Polyclinic
                    System.out.print("Masukkan Nama Poliklinik: ");
                    String polyclinicName = scanner.next();
                    Polyclinic polyclinic = new Polyclinic(polyclinicName);
                    admin.addPolyclinic(polyclinics, polyclinic);
                    break;

                case 2:
                    // Print Transaction Details
                    System.out.print("Masukkan Nomor Antrian: ");
                    int queueNumber = scanner.nextInt();
                    System.out.print("Masukkan Nama Poliklinik: ");
                    String clinicName = scanner.next();
                    System.out.print("Masukkan Nama Dokter: ");
                    String doctorName = scanner.next();
                    admin.printTransactionDetails(queueNumber, clinicName, doctorName);
                    break;

                case 3:
                    // Add View.Doctor Schedule
                    System.out.print("Masukkan Nama Dokter: ");
                    String newDoctorName = scanner.next();
                    System.out.print("Masukkan Jadwal (dipisahkan koma): ");
                    scanner.nextLine();  // Consume newline
                    String scheduleInput = scanner.nextLine();
                    List<String> scheduleList = Arrays.asList(scheduleInput.split(","));
                    admin.addDoctorSchedule(doctorSchedules, newDoctorName, scheduleList);
                    break;

                case 4:
                    // Update View.Doctor Schedule
                    System.out.print("Masukkan Nama Dokter: ");
                    String existingDoctorName = scanner.next();
                    System.out.print("Masukkan Jadwal Baru (dipisahkan koma): ");
                    scanner.nextLine();  // Consume newline
                    String newScheduleInput = scanner.nextLine();
                    List<String> newScheduleList = Arrays.asList(newScheduleInput.split(","));
                    admin.updateDoctorSchedule(doctorSchedules, existingDoctorName, newScheduleList);
                    break;

                case 5:
                    // Logout
                    System.out.println("Admin keluar.");
                    return;

                default:
                    System.out.println("Opsi tidak valid. Harap pilih lagi.");
            }
        }
    }
}
