import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;
    private ArrayList<String> zipCodes = ZipCodeBuilder.getZipCodes("src/list_of_zip_codes");

    public PackageSimulator() {
        packages = new ArrayList<Package>();
    }
    public double generateTotalCost() {
        double totalCost = 0;

        for(Package p : packages) {
            totalCost += PostageCalculator.calculateCost(p);
        }

        return totalCost;
    }

    public String getSimulationInfo() {
        return "";
    }

    public void resetSimulation() {
        packages.clear();
    }
}
