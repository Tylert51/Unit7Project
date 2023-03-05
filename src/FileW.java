import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<Street> streets = ZipCodeBuilder.getStreets("src/streetNames");

        for(Street s : streets) {
            ArrayList<String> streetN = s.getStreetNames();

            for(int i = 0; i < streetN.size(); i++) {
                String name = streetN.get(i);
                int indOfComma = name.indexOf(",");

                if(indOfComma != -1) {
                    streetN.set(i, name.substring(0, indOfComma));
                }
            }
        }




        try {
            File f = new File("src/streetNames");
            f.createNewFile();
            FileWriter fw = new FileWriter(f);

            for (Street s : streets) {
                fw.write(s + "\n");
                //System.out.println(counter + " / " + streets.size());
                counter++;
            }
            fw.close();
        }
        catch (IOException ioe) {
            System.out.println("Writing file failed");
            System.out.println(ioe);
        }
    }
}