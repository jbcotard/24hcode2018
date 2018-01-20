package org.mixiteam.daycode.antseed;

import java.util.Date;

public class Insecte {

    String _id;
    String name;
    String email;
    String role;
    String provider;
    String lon;
    String lat;
    String teamName;
    String __v;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getProvider() {
        return provider;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public String getTeamName() {
        return teamName;
    }

    public String get__v() {
        return __v;
    }

    @Override
    public String toString() {
        return "Insecte{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", provider='" + provider + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", teamName='" + teamName + '\'' +
                ", __v='" + __v + '\'' +
                '}';
    }
}
