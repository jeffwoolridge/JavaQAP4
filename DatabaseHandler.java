import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/pharmacydb";  // DB URI
    private static final String USER = "jeffwoolridge"; // DB user
    private static final String PASSWORD = "yourpassword"; // DB password
    public static void savePatient(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";

        // Save patient to the database
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, patient.getPatientId()); 
            stmt.setString(2, patient.getPatientFirstName());
            stmt.setString(3, patient.getPatientLastName());

            // Convert DOB string to java.sql.Date
            LocalDate localDate = LocalDate.parse(patient.getPatientDOB(), DateTimeFormatter.ISO_LOCAL_DATE);
            Date sqlDate = Date.valueOf(localDate);
            stmt.setDate(4, sqlDate);

            stmt.executeUpdate();
            System.out.println("Patient saved successfully!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Read all patients from the database
    public static List<Patient> readPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT patient_id, first_name, last_name, dob FROM patients";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String id = rs.getString("patient_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date dobDate = rs.getDate("dob");
                String dob = dobDate.toLocalDate().toString();

                Patient patient = new Patient(id, firstName, lastName, dob);
                patients.add(patient);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return patients;
    }
}
