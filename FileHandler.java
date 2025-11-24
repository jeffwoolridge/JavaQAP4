import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String DRUG_FILE = "drugs.txt";

    public static void saveDrug(Drug drug) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DRUG_FILE, true))) {
            bw.write(drug.getDrugId() + "," + drug.getDrugName() + "," + drug.getDrugCost() + "," + drug.getDosage());
            bw.newLine();
            System.out.println("Drug saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<Drug> readDrugs() {
        List<Drug> drugs = new ArrayList<>();
        File file = new File(DRUG_FILE);
        if (!file.exists()) {
            System.out.println("No drugs found. File does not exist.");
            return drugs;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(DRUG_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        Drug drug = new Drug(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
                        drugs.add(drug);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid line: " + line);
                    }
                } else {
                    System.out.println("Skipping malformed line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return drugs;
    }
}
