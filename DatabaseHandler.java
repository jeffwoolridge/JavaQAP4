import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    private static final String URL = "jdbc:postgresql://localhost:5432/yourdbname";
    private static final String USER = "jeffwoolridge";
    private static final String PASSWORD = "yourpassword";

    public static void savePatient(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, patient.getPatientId());
            stmt.setString(2, patient.getPatientFirstName());
            stmt.setString(3, patient.getPatientLastName());
            stmt.setString(4, patient.getPatientDOB());

            stmt.executeUpdate();
            System.out.println("Patient saved successfully!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static List<Patient> readPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT patient_id, first_name, last_name, dob FROM patients";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Patient patient = new Patient(
                    rs.getString("patient_id"), 
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("dob")
                );

                patients.add(patient);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return patients;
    }
}
