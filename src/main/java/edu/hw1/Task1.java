package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    private static final int SECONDS_IN_MINUTE = 60;

    public static int minutesToSeconds(String s) {
        int result = 0;
        // В задании имеется пример 999:59 так что по сути
        // любое количество минут будет верно
        if (!s.matches("\\d+:\\d\\d")) {
            return -1;
        }
        String[] pos = s.split(":");
        if (Integer.parseInt(pos[1]) >= SECONDS_IN_MINUTE) {
            return -1;
        }
        result += Integer.parseInt(pos[0]) * SECONDS_IN_MINUTE;
        result += Integer.parseInt(pos[1]);
        return result;
    }
}
