package org.mixiteam.daycode.antseed;

public class Seed {

    String _id;
    String name;
    String info;
    boolean active;
    String type;
    Location location;
    String provider;
    String email;
    String teamName;
    String __v;
    String lon;
    String lat;
    String role;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public boolean isActive() {
        return active;
    }

    public String getType() {
        return type;
    }

    public Location getLocation() {
        return location;
    }

    public String getProvider() {
        return provider;
    }

    public String getEmail() {
        return email;
    }

    public String getTeamName() {
        return teamName;
    }

    public String get__v() {
        return __v;
    }

    public String getLon() {
        return lon;
    }

    public String getLat() {
        return lat;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", active=" + active +
                ", type='" + type + '\'' +
                ", location=" + location +
                ", provider='" + provider + '\'' +
                ", email='" + email + '\'' +
                ", teamName='" + teamName + '\'' +
                ", __v='" + __v + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
