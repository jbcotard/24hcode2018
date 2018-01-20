package org.mixiteam.daycode.antseed;

import java.time.ZonedDateTime;

public class Position {

    String lat;
    String lon;
    ZonedDateTime timestamp;

    /*
    * // works with Instant
Instant instant = Instant.now();
System.out.println(instant.format(DateTimeFormatter.ISO_INSTANT));

// works with ZonedDateTime
ZonedDateTime zdt = ZonedDateTime.now();
System.out.println(zdt.format(DateTimeFormatter.ISO_INSTANT));
    *
    * */

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Position{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
