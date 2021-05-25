package com.back.office.utils;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.Timestamp;

/**
 * @author Viju Joseph (vijujoseph@gmail.com)
 */
public class DateUtils {

    private DateUtils() {
    }

    public static Timestamp getCurrentTimeStampInUTC() {
        DateTime currentDateTime = new DateTime(DateTimeZone.UTC);
        return new Timestamp(currentDateTime.getMillis());
    }

    public static Timestamp convertToTimeStamp(String epocMilli) {
        return new Timestamp(Long.valueOf(epocMilli));
    }

}
