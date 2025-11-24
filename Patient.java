public class Patient {
    private final String patientId;  // changed from int to String
    private final String patientFirstName;
    private final String patientLastName;
    private final String patientDOB;

    public Patient(String patientId, String patientFirstName, String patientLastName, String patientDOB) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDOB = patientDOB;
    }

    public String getPatientId() { return patientId; }
    public String getPatientFirstName() { return patientFirstName; }
    public String getPatientLastName() { return patientLastName; }
    public String getPatientDOB() { return patientDOB; }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + patientFirstName + " " +
               patientLastName + ", DOB: " + patientDOB;
    }
}
