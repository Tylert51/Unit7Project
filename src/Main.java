import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("----------------------------------------------------------");
        System.out.println("1. Calculate Cost of a Package");
        System.out.println("2. Simulate Packages");
        System.out.println("3. Learn How Packages' Costs are Calculated");
        System.out.println("4. Exit");
        System.out.print("Input: ");

        String choice = s.nextLine();
        while (!choice.equals("4")) {

            while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
                System.out.print("Enter a valid choice: ");
                choice = s.nextLine();
            }
            System.out.println("----------------------------------------------------------");

            if (choice.equals("1")) {  // calculate cost
                System.out.print("Enter the zip code of the origin location: ");
                String zipO = s.nextLine();
                System.out.print("Enter the zip code of the destination location: ");
                String zipD = s.nextLine();

                System.out.print("Enter the weight of the package: ");
                double weight = Double.parseDouble(s.nextLine());
                while (weight < 0.1) {
                    System.out.print("Weight can't be less than a tenth of a pound\nEnter a valid weight: ");
                    weight = Double.parseDouble(s.nextLine());
                }

                System.out.print("Enter the height of the package: ");
                double height = Double.parseDouble(s.nextLine());
                while (height < 2) {
                    System.out.print("Height can't be less than 2 inches\nEnter a valid height: ");
                    height = Double.parseDouble(s.nextLine());
                }

                System.out.print("Enter the length of the package: ");
                double length = Double.parseDouble(s.nextLine());
                while (length < 2) {
                    System.out.print("Length can't be less than 2 inches\nEnter a valid length: ");
                    length = Double.parseDouble(s.nextLine());
                }

                System.out.print("Enter the width of the package: ");
                double width = Double.parseDouble(s.nextLine());
                while (width < 2) {
                    System.out.print("Width can't be less than 2 inches\nEnter a valid width: ");
                    width = Double.parseDouble(s.nextLine());
                }

                System.out.println("Cost: $" + roundToTwo(PostageCalculator.calculateCost(zipO, zipD, weight, length, width, height)));

            } else if (choice.equals("3")) {   // learn costs
                System.out.println("1. Start with a bast cost of $3.75");
                System.out.println("2. Take your origin and destination location and retrieve the zip codes (e.g. 11546 & 03678)");
                System.out.println("     a. Take the first three numbers (in this case 115 & 36) and find the positive difference");
                System.out.println("     b. Divide this positive difference by 100 and add this to the base cost (in this case 0.79)");
                System.out.println("3. Take the dimensions of the package (length, width, and height) and add them all up");
                System.out.println("     a. If the total exceeds 36, it will cost an additional 10 cents per inch over 36");
                System.out.println("          i. If total is 50 inches, that is an extra $1.40");
                System.out.println("          ii. If total doesn't exceed 36, don't do anything");
                System.out.println("4. Take the weight of your package");
                System.out.println("     a. If the weight exceeds 40 lbs");
                System.out.println("          i. It will cost 5 cents per tenth of a pound for the first 40 lbs (or just $20)");
                System.out.println("          ii. For the rest of the weight over 40, it will cost 10 cents per tenth of a pound (or just the excess weight)");
                System.out.println("          iii. e.g. weight = 45  -->  20 + 5 = 25  -->   add 25 to the cost");
                System.out.println("     b. If the weight doesn't exceeds 40 lbs");
                System.out.println("          i. It will cost 5 cents per tenth of a pound");
                System.out.println("          ii. e.g. weight = 21  -->  0.05(21/0.1) = 10.5  -->   add 10.5 to the cost\n");

                System.out.print("Press enter when you understand");
                s.nextLine();

            } else {    // run sim
                PackageSimulator sim = new PackageSimulator();

                System.out.print("How many packages would you like to simulate? ");
                int numTrials = Integer.parseInt(s.nextLine());

                System.out.println(sim.getSimulationInfo(numTrials));
            }


            System.out.println("----------------------------------------------------------");
            System.out.println("1. Calculate Cost of a Package");
            System.out.println("2. Simulate Packages");
            System.out.println("3. Learn How Packages' Costs are Calculated");
            System.out.println("4. Exit");
            System.out.print("Input: ");

            choice = s.nextLine();
        }

    }

    private static String roundToTwo(double num) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(num);
    }
}
