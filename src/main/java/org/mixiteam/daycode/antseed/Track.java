package org.mixiteam.daycode.antseed;

import java.time.Instant;
import java.time.ZonedDateTime;

public class Track {

    String _id;
    String name;
    String info;
    String userId;
    String endSeedId;
    String __v;
    String startDate;

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

    public String getEndSeedId() {
        return endSeedId;
    }

    public String get__v() {
        return __v;
    }

    public String getStartDate() {
        return startDate;
    }

    @Override
    public String toString() {
        return "Track{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", userId='" + userId + '\'' +
                ", endSeedId='" + endSeedId + '\'' +
                ", __v='" + __v + '\'' +
                ", startDate=" + startDate +
                '}';
    }
}
