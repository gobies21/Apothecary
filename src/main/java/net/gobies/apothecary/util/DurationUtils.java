package net.gobies.apothecary.util;

import java.util.Random;

public class DurationUtils {
    private static final Random RANDOM = new Random();

    public static int getRandomVeryShortDuration() {
        return 20 + RANDOM.nextInt(40); // Duration between 1 and 2 seconds (20-60 ticks)
    }

    public static int getRandomShortDuration() {
        return 60 + RANDOM.nextInt(120); // Duration between 3 and 9 seconds (60-180 ticks)
    }

    public static int getRandomMediumDuration() {
        return 200 + RANDOM.nextInt(220); // Duration between 10 and 20 seconds (200-420 ticks)
    }

    public static int getRandomLongDuration() {
        return 400 + RANDOM.nextInt(420); // Duration between 20 and 40 seconds (400-820 ticks)
    }

    public static int getRandomVeryLongDuration() {
        return 1000 + RANDOM.nextInt(1020); // Duration between 50 and 100 seconds (1000-2020 ticks)
    }
}