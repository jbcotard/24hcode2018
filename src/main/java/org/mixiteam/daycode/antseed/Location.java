package org.mixiteam.daycode.antseed;

import java.util.Arrays;

public class Location {
    String type;
    String[] coordinates;

    public String getType() {
        return type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "type='" + type + '\'' +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
