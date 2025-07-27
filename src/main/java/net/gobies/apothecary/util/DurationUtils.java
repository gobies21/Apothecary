package net.gobies.apothecary.util;

import java.util.Random;

public class DurationUtils {
    private static final Random RANDOM = new Random();

    public static int getRandomVeryShortDuration() {
        return 40 + RANDOM.nextInt(40); // Duration between 2 and 4 seconds (40-80 ticks)
    }

    public static int getRandomShortDuration() {
        return 80 + RANDOM.nextInt(120); // Duration between 4 and 10 seconds (80-200 ticks)
    }

    public static int getRandomMediumDuration() {
        return 200 + RANDOM.nextInt(200); // Duration between 10 and 20 seconds (200-420 ticks)
    }

    public static int getRandomLongDuration() {
        return 400 + RANDOM.nextInt(400); // Duration between 20 and 40 seconds (400-820 ticks)
    }

    public static int getRandomVeryLongDuration() {
        return 1000 + RANDOM.nextInt(1000); // Duration between 50 and 100 seconds (1000-2020 ticks)
    }
}