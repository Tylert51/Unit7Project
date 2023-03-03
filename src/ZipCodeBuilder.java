import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class ZipCodeBuilder {

    public static ArrayList<String> getZipCodes(String fileName) {
        ArrayList<String> zipCodes = new ArrayList<String>();
        try {
            File zipData = new File(fileName);
            Scanner reader = new Scanner(zipData);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                zipCodes.add(line);
            }
        } catch (FileNotFoundException noFile) {
            System.out.println("File not found!");
            return null;
        }
        return zipCodes;
    }
}
