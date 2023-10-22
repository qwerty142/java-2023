package edu.hw2.Task4;

public final class GetCallingData {
    private GetCallingData() {}

    public static Information callingInfo() {
        var info = new Throwable().getStackTrace()[1];

        return new Information(info.getClassName(), info.getMethodName());
    }
}
