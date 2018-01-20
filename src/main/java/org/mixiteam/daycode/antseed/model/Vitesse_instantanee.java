package org.mixiteam.daycode.antseed.model;

public class Vitesse_instantanee {

	 

	private int temps;
	private float vitesse;
	
	
	
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	public float getVitesse() {
		return vitesse;
	}
	public void setVitesse(float vitesse) {
		this.vitesse = vitesse;
	}
	@Override
	public String toString() {
		return "Vitesse_instantanee [temps=" + temps + ", vitesse=" + vitesse + "]";
	}
	
	
}
