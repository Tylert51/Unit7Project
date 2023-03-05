import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        PackageSimulator simulator = new PackageSimulator();

        for(int i = 0; i < 100; i++) {
            System.out.println(simulator.runOneSim(1));
        }

    }
}
