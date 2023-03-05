public class PostageCalculator {
    private static final double BASE_COST = 3.75;

    public static double calculateCost(String zip1, String zip2, double weight, double length, double width, double height) {
        double cost = BASE_COST;

        int countryCode1 = Integer.parseInt(zip1.substring(0,3));
        int countryCode2 = Integer.parseInt(zip2.substring(0,3));

        double diffInCountryCodes = Math.abs(countryCode1 - countryCode2);
        cost += (diffInCountryCodes / 100);

        double totalDim = length + width + height;
        if (totalDim > 36) {
            cost += ((totalDim - 36) * 0.1);
        }

        if (weight > 40) {
            cost += (0.05 * (40 / 0.1));
            cost += (0.1 * ((weight - 40) / 0.1));
        } else {
            cost += (0.05 * (weight / 0.1));
        }

        return cost;
    }

    public static double calculateCost(Address address1, Address address2, double weight, double length, double width, double height) {
        double cost = BASE_COST;


        int countryCode1 = Integer.parseInt(address1.getZipCode().substring(0,3));
        int countryCode2 = Integer.parseInt(address2.getZipCode().substring(0,3));

        double diffInCountryCodes = Math.abs(countryCode1 - countryCode2);
        cost += (diffInCountryCodes / 100);

        double totalDim = length + width + height;
        if (totalDim > 36) {
            cost += ((totalDim - 36) * 0.1);
        }

        if (weight > 40) {
            cost += (0.05 * (40 / 0.1));
            cost += (0.1 * ((weight - 40) / 0.1));
        } else {
            cost += (0.05 * (weight / 0.1));
        }

        return cost;
    }

    public static double calculateCost(Package pkg) {
        double cost = BASE_COST;

        double weight = pkg.getWeight();
        double length = pkg.getLength();
        double width = pkg.getWidth();
        double height = pkg.getHeight();
        int countryCode1 = Integer.parseInt(pkg.getOrigin().getZipCode().substring(0,3));
        int countryCode2 = Integer.parseInt(pkg.getDestination().getZipCode().substring(0,3));

        double diffInCountryCodes = Math.abs(countryCode1 - countryCode2);
        cost += (diffInCountryCodes / 100);

        double totalDim = length + width + height;
        if (totalDim > 36) {
            cost += ((totalDim - 36) * 0.1);
        }

        if (weight > 40) {
            cost += (0.05 * (40 / 0.1));
            cost += (0.1 * ((weight - 40) / 0.1));
        } else {
            cost += (0.05 * (weight / 0.1));
        }

        return cost;
    }
}
