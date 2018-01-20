package org.mixiteam.daycode.antseed.model;

import org.mixiteam.daycode.antseed.Position;

public class CalculsTemps {

	public static Vitesse_instantanee caluTemps(Position depart, Position arrivee, long vitesse_initial,
			long vitesse_max, int temps_attente_arrivee) {

		Vitesse_instantanee result = new Vitesse_instantanee();

		// //Cas facile vitesse constante de depart -> arrivee
		// if((vitesse_initial==vitesse_max) && (temps_attente_arrivee==0)){

		double distance = getDistanceFromLatLonInKm(Double.valueOf(depart.getLat()), Double.valueOf(depart.getLon()),
				Double.valueOf(arrivee.getLat()), Double.valueOf(arrivee.getLon()));
		System.out.println("distance "+distance);
		Double val = (distance * 3600) / vitesse_max;

		result.setTemps(val.intValue() + temps_attente_arrivee);
		result.setVitesse(vitesse_max);

		return result;

	}

	public static double getDistanceFromLatLonInKm(double lat1, double lon1, double lat2, double lon2) {
		double R = 6371; // Radius of the earth in km
		double dLat = Math.toRadians(lat2 - lat1); // deg2rad below
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c; // Distance in km
		return d;
	}

}
