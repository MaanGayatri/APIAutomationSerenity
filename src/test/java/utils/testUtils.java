package utils;

import java.util.Random;

public class testUtils {
    public static String getRandomValue()
    {
        Random r = new Random();
        int randomint = r.nextInt(10000);
        return Integer.toString(randomint);
    }

}
