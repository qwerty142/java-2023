package edu.project3.Entities;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("checkstyle:LineLength")
public class Log {
    private static final Map<String, String> CHANGE_DATE_FOR_PARSER = new HashMap<>();

    static {
        CHANGE_DATE_FOR_PARSER.put("Jan", "01");
        CHANGE_DATE_FOR_PARSER.put("Feb", "02");
        CHANGE_DATE_FOR_PARSER.put("Mar", "03");
        CHANGE_DATE_FOR_PARSER.put("Apr", "04");
        CHANGE_DATE_FOR_PARSER.put("May", "05");
        CHANGE_DATE_FOR_PARSER.put("Jun", "06");
        CHANGE_DATE_FOR_PARSER.put("Jul", "07");
        CHANGE_DATE_FOR_PARSER.put("Aug", "08");
        CHANGE_DATE_FOR_PARSER.put("Sep", "09");
        CHANGE_DATE_FOR_PARSER.put("Oct", "10");
        CHANGE_DATE_FOR_PARSER.put("Nov", "11");
        CHANGE_DATE_FOR_PARSER.put("Dec", "12");
    }

    private final static Pattern LOG_PATTERN = Pattern.compile("(.+?) - (.+?) \\[(.+?)] \"(.+?)\" (\\d+) (\\d+) \"(.+?)\" \"(.+?)\"");
    public String address;
    public String user;
    public String request;
    public String resource;
    public String reference;
    public String httpUser;
    public OffsetDateTime time;
    public String command;
    public int status;
    public long bytesSend;

    @SuppressWarnings({"checkstyle:MagicNumber", "checkstyle:HiddenField"})
    public static Log createLog(String log) {
        Matcher matcher = LOG_PATTERN.matcher(log);
        Log currentLog = new Log();

        if (matcher.matches()) {
            currentLog.address = matcher.group(1);
            currentLog.user = matcher.group(2);
            currentLog.time = dateParser(matcher.group(3));
            currentLog.request = matcher.group(4);
            String[] request = matcher.group(4).split(" ");
            currentLog.command = request[0];
            currentLog.resource = request[1];
            currentLog.status = Integer.parseInt(matcher.group(5));
            currentLog.bytesSend = Long.parseLong(matcher.group(6));
            currentLog.reference = matcher.group(7);
            currentLog.httpUser = matcher.group(8);
            return currentLog;
        }
        throw new IllegalArgumentException();
    }

    @SuppressWarnings("checkstyle:ParameterAssignment")
    private static OffsetDateTime dateParser(String date) {

        for (Map.Entry<String, String> itr : CHANGE_DATE_FOR_PARSER.entrySet()) {
            date = date.replaceFirst(itr.getKey(), itr.getValue());
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss ");
        DateTimeFormatter offsetFrom = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(dateTimeFormatter)
            .appendOffset("+HHMM", "+0000")
            .toFormatter();
        return OffsetDateTime.parse(date, offsetFrom);
    }
}
