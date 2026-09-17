import doctor.Doctor;
import patient.Patient;

public class HospitalManagement {
    public static void main(String[] args) {

        Doctor d = new Doctor(101, "Dr. Sharma", "Cardiologist", 1000);
        Patient p = new Patient(201, "Anvi", 19, "Fever");

        System.out.println("Doctor Details:");
        d.display();

        System.out.println("\nPatient Details:");
        p.display();
    }
}
