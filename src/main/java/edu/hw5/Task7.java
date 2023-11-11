package edu.hw5;

import java.util.regex.Pattern;

public final class Task7 {
    private static Pattern pattern1 = Pattern.compile("^[0,1]{2}0[0,1]*$");
    private static Pattern startEndWithSameSymbol = Pattern.compile("0|1|(^0[01]*0$)|(^1[01]*1$)");
    private static Pattern noMoreThan3Symbols = Pattern.compile("^[0,1]{1,3}$");

    private Task7() {}

    public static boolean atLeast3CharactersThirdCharacter0(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        return pattern1.matcher(string).matches();
    }

    public static boolean startsAndEndsWithSameCharacter(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        return startEndWithSameSymbol.matcher(string).matches();
    }

    public static boolean lengthNoLessThan1AndNoMoreThan3(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        return noMoreThan3Symbols.matcher(string).matches();
    }

}
