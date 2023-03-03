import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> zipCodes = ZipCodeBuilder.getZipCodes("src/list_of_zip_codes");
        System.out.println(zipCodes);
        System.out.println(zipCodes.size());


    }
}
