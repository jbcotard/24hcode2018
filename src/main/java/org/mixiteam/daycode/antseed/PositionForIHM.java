package org.mixiteam.daycode.antseed;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class PositionForIHM {

    long timestamp;
    double lat;
    double lon;


    PositionForIHM(Position position, Position positionPrecedente) {
        this.timestamp = ChronoUnit.MILLIS.between(
                positionPrecedente.getTimestamp(),
                position.getTimestamp());
        lat = Double.parseDouble(position.getLat());
        lon = Double.parseDouble(position.getLon());

    }

    public long getTimestamp() {
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
