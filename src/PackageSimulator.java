import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;
    private ArrayList<ZipCode> zipCodes;
    private ArrayList<Street> streets;

    public PackageSimulator() {
        packages = new ArrayList<Package>();
        zipCodes = ZipCodeBuilder.getZipCodes("src/zip_codes.txt");
        streets = ZipCodeBuilder.getStreets("src/streetNames");
    }
    public double generateTotalCost() {
        double totalCost = 0;

        for(Package p : packages) {
            totalCost += PostageCalculator.calculateCost(p);
        }

        return totalCost;
    }

    public String getSimulationInfo(int numTrials) {
        String str = "";

        for(int i = 0; i < numTrials; i++) {
            str += runOneSim(i + 1) + "\n";
        }

        str += "----------------------------------------\n";
        str += "Total cost of all packages: " + roundToTwo(generateTotalCost());

        resetSimulation();

        return str;
    }

    public void resetSimulation() {
        packages.clear();
    }

    private double getRandDimension() {
        return (Math.random() * 19.6) + 2;
    }
    private double getRandWeight() {
        return Math.random() * 48 + 2;
    }
    private ZipCode getZipCode(String state) {
        ArrayList<ZipCode> zip = new ArrayList<>();

        for(ZipCode z : zipCodes) {
            if(z.getState().equals(state)) {
                zip.add(z);
            }
        }
        int rand = (int) (Math.random() * zip.size());
        return zip.get(rand);
    }

    private Street getRandStreet() {
        int rand = (int) (Math.random() * streets.size());

        return streets.get(rand);
    }

    private String getRandAptNum() {
        String nums = "123456789";
        String alpabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int rand1 = (int) (Math.random() * 9);
        int rand2 = (int) (Math.random() * 26);

        String randNum = nums.charAt(rand1) + "";
        String randAlpha = alpabet.charAt(rand2) + "";

        return randNum + randAlpha;
    }

    private String genRandThreeNum() {
        int rand = (int) (Math.random() * 900) + 100;

        return rand + "";
    }

    public String runOneSim(int num) {
        String str = "Package " + num + ": ----------------------------------------\n";
        int rand = (int) (Math.random() * 10);
        Street randStreet = getRandStreet();
        ZipCode randZip = getZipCode(randStreet.getState());
        Address origin = new Address(genRandThreeNum() + " " + randStreet.getStreetNames().get(rand) + " Apt " + getRandAptNum() + ", " + randZip.getState() + ", " + randZip.getCity() + " " + randZip.getZipCode());
        rand = (int) (Math.random() * 10);
        Street randStreet2 = getRandStreet();
        ZipCode randZip2 = getZipCode(randStreet2.getState());
        Address destination = new Address(genRandThreeNum() + " " + randStreet2.getStreetNames().get(rand) + " Apt " + getRandAptNum() + ", " + randZip2.getState() + ", " + randZip2.getCity() + " " + randZip2.getZipCode());
        Package pack = new Package(origin, destination, getRandWeight(), getRandDimension(), getRandDimension(), getRandDimension());

        str += pack;
        str += "\nCost: " + roundToTwo(PostageCalculator.calculateCost(pack));

        packages.add(pack);

        return str;
    }


    private static double roundToTwo(double num) {
        return Math.round(num * 100) / 100.0;
    }


}
