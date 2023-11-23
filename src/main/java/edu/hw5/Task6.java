package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public final class Task6 {
    private Task6() {}

    @SuppressWarnings("checkstyle:ParameterAssignment")
    public static boolean checkOnSubString(@NotNull String sub, @NotNull String string) {
        sub = "\\Q" + sub + "\\E";
        Pattern pattern = Pattern.compile(sub);
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }
}
