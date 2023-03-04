import java.util.ArrayDeque;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Collections;

public class FileW {
    public static void main(String[] args) {
        int counter = 1;

        ArrayList<Street> streets = new ArrayList<>();




        try {
            File f = new File("src/test2");
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