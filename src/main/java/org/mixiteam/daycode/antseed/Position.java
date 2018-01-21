package org.mixiteam.daycode.antseed;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Position {

    String _id;
    String lat;
    String lon;
    Instant timestamp;
    String __v;
    String trackId;
    int duree;
    
    public Position(String la, String lo, Instant t)
    {
    	this.lat = la;
    	this.lon = lo;
    	this.timestamp = t;
    }
    
    public Position(String la, String lo)
    {
    	this.lat = la;
    	this.lon = lo;
    }

    public Position() {

    }

    // works with Instant
//Instant instant = Instant.now();
//System.out.println(instant.format(DateTimeFormatter.ISO_INSTANT));

// works with ZonedDateTime
//ZonedDateTime zdt = ZonedDateTime.now();
//System.out.println(zdt.format(DateTimeFormatter.ISO_INSTANT));


    public String get_id() {
        return _id;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @JsonSetter
    public void setTimestamp(String timestamp) {
        this.timestamp = Instant.from(DateTimeFormatter.ISO_INSTANT.parse(timestamp));
    }


    public String get__v() {
        return __v;
    }

    public String getTrackId() {
        return trackId;
    }

    @Override
    public String toString() {
        return "Position{" +
                "_id='" + _id + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", timestamp=" + timestamp +
                ", __v='" + __v + '\'' +
                ", trackId='" + trackId + '\'' +
                ", duree=" + duree +
                '}';
    }
}
