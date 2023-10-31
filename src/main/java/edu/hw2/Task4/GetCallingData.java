package edu.hw2.Task4;

public final class GetCallingData {
    private GetCallingData() {}

    public static Information callingInfo(Throwable throwable) {
        var info = throwable.getStackTrace()[0];

        return new Information(info.getClassName(), info.getMethodName());
    }
}
