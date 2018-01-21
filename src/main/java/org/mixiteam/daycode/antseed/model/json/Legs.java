package org.mixiteam.daycode.antseed.model.json;

import java.util.List;

public class Legs {
	private Annotations annotations;
	private List<Steps> steps;

	public Annotations getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Annotations annotations) {
		this.annotations = annotations;
	}

	public List<Steps> getSteps() {
		return steps;
	}

	public void setSteps(List<Steps> steps) {
		this.steps = steps;
	}

}
