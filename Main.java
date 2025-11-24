import java.util.List;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n Pharmacy Management Menu ");
            System.out.println("1. Save Drug to file");
            System.out.println("2. Read Drugs from file");
            System.out.println("3. Save Patient to database");
            System.out.println("4. Read Patients from database");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> saveDrug();
                case 2 -> readDrugs();
                case 3 -> savePatient();
                case 4 -> readPatients();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void saveDrug() {
        System.out.print("Enter Drug ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Drug Name: ");
        String name = scanner.nextLine();

        double cost = 0;
        while (true) {
            System.out.print("Enter Drug Cost: ");
            String input = scanner.nextLine();
            try {
                cost = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        System.out.print("Enter Dosage: ");
        String dosage = scanner.nextLine();

        Drug drug = new Drug(id, name, cost, dosage);
        FileHandler.saveDrug(drug);
    }

    private static void readDrugs() {
        List<Drug> drugs = FileHandler.readDrugs();
        System.out.println("\n--- Drug List ---");
        for (Drug d : drugs) {
            System.out.println(d);
        }
    }

    private static void savePatient() {
    System.out.print("Enter Patient ID: ");
    String id = scanner.nextLine();  // changed from nextInt() to nextLine()
    System.out.print("Enter First Name: ");
    String firstName = scanner.nextLine();
    System.out.print("Enter Last Name: ");
    String lastName = scanner.nextLine();
    System.out.print("Enter DOB (YYYY-MM-DD): ");
    String dob = scanner.nextLine();

    Patient patient = new Patient(id, firstName, lastName, dob);
    DatabaseHandler.savePatient(patient);
}

    private static void readPatients() {
        List<Patient> patients = DatabaseHandler.readPatients();
        System.out.println("\n--- Patient List ---");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}
