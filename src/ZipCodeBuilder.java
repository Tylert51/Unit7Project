import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class ZipCodeBuilder {

    public static ArrayList<ZipCode> getZipCodes(String fileName) {
        ArrayList<ZipCode> zipCodes = new ArrayList<>();

        try {
            File zipData = new File(fileName);
            Scanner reader = new Scanner(zipData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] temp;
                temp = line.split("---");

                zipCodes.add(new ZipCode(temp[0], temp[1], temp[2]));
            }
        } catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return zipCodes;
    }

    public static ArrayList<Street> getStreets(String fileName) {
        ArrayList<Street> streets = new ArrayList<>();

        try {
            File zipData = new File(fileName);
            Scanner reader = new Scanner(zipData);
            String[] temp;
            String[] temp2;
            String state = "";
            ArrayList<String> sNames = new ArrayList<>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                temp = line.split("---");

                state = temp[0];
                temp2 = temp[1].split(":::");

                for (int i = 0; i < temp2.length; i++) {
                    sNames.add(temp2[i]);
                }

                streets.add(new Street(state, (ArrayList<String>) sNames.clone()));
                sNames.clear();
            }

        } catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return streets;
    }
}
