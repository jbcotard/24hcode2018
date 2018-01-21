package org.mixiteam.daycode.antseed.model.json;

import java.util.List;

public class Steps {
	private List<Intersections> intersections;
	private Double duration;

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public List<Intersections> getIntersections() {
		return intersections;
	}

	public void setIntersections(List<Intersections> intersections) {
		this.intersections = intersections;
	}
}
