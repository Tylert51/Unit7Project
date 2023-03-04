import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        int counter = 0;

        for (int i = 0; i < 10000; i++) {
            double rand = (Math.random() * 19.6) + 2;

            if (rand > 21.5) {
                System.out.println(rand);
            }
        }

    }
}
