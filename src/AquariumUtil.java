import java.util.Random;

public class AquariumUtil {
    public static Random random = new Random();

    public static int getRandom(int n) {
        return random.nextInt(n);
    }

    public static int getRandomBetween(int a, int b) {
        return random.nextInt(a, b);
    }

    public static boolean getRandomBool() {
        return random.nextInt(2) == 0;
    }
}
