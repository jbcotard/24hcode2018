package org.mixiteam.daycode.antseed;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class PositionWithFloat {

    String timestamp;
    double lat;
    double lon;


    PositionWithFloat(Position position) {
        this.timestamp = DateTimeFormatter.ISO_INSTANT.format(position.getTimestamp());
        lat = Double.parseDouble(position.getLat());
        lon = Double.parseDouble(position.getLon());

    }

    public String getTimestamp() {
        return timestamp;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "PositionWithFloat{" +
                "timestamp='" + timestamp + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
