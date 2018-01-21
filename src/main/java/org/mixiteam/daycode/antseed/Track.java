package org.mixiteam.daycode.antseed;

import java.time.Instant;
import java.time.ZonedDateTime;

public class Track {

    String _id;
    String name;
    String info;
    String userId;
    String startSeedId;
    String endSeedId;
    String __v;
    String startDate;
    String endDate;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getUserId() {
        return userId;
    }

    public String getStartSeedId() {
        return startSeedId;
    }

    public String getEndSeedId() {
        return endSeedId;
    }

    public String get__v() {
        return __v;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Track{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", userId='" + userId + '\'' +
                ", startSeedId='" + startSeedId + '\'' +
                ", endSeedId='" + endSeedId + '\'' +
                ", __v='" + __v + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
