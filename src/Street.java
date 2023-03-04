import java.util.ArrayList;

public class Street {
    private String state;
    private ArrayList<String> streetNames;

    public Street(String state, ArrayList streetNames) {
        this.state = state;
        this.streetNames = streetNames;
    }

    public String getState() {
        return state;
    }

    public ArrayList<String> getStreetNames() {
        return streetNames;
    }

    public String toString() {
        String str = state + "---";

        for(String s : streetNames) {
            str += s + ":::";
        }

        return str;
    }
}
