public class Drug {
    private final String drugId;
    private final String drugName;
    private final double drugCost;
    private final String dosage;

    public Drug(String drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    public String getDrugId() { return drugId; }
    public String getDrugName() { return drugName; }
    public double getDrugCost() { return drugCost; }
    public String getDosage() { return dosage; }

    @Override
    public String toString() {
        return "Drug ID: " + drugId + ", Name: " + drugName +
               ", Cost: $" + drugCost + ", Dosage: " + dosage;
    }
}
