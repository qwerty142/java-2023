package edu.hw1;

public final class Task1 {
    private Task1() {
    }

    public static int get_sum(String s) {
        int result = 0;
        boolean index_of = s.matches("\\d+:\\d\\d");
        if (!index_of) {
            return -1;
        }
        String[] pos = s.split(":");
        if (Integer.parseInt(pos[1]) >= 60) {
            return -1;
        }
        result += Integer.parseInt(pos[0]) * 60;
        result += Integer.parseInt(pos[1]);
        return result;
    }
}
