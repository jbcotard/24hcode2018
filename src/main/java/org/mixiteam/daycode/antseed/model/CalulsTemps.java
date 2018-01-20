package org.mixiteam.daycode.antseed.model;

import org.mixiteam.daycode.antseed.Position;

public class CalulsTemps {

	public static Vitesse_instantanee caluTemps(Position depart, Position arrivee, long vitesse_initial,
			long vitesse_max, int temps_attente_arrivee) {

		Vitesse_instantanee result = new Vitesse_instantanee();

		if((vitesse_initial==vitesse_max) && (temps_attente_arrivee==0)){
		
			
			
		}
		
		
		
		
		
		
		
		
		return result;

	}
	
	public float calculDistance(Position depart,Position arrivée) {

		int R = 6371; // Radius of the earth in km 
		float dLat = Math.toRadians(lat2-lat1); // deg2rad below 
		float dLon = Math.toRadians(lon2-lon1); 
	
		float a = Math.sin(dLat/2) * Math.sin(dLat/2)
		return Math.cos(Math.toRadians()) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2) ; 
		var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		var d = R * c; // Distance in km return d; 
		
		
	}
	


}
