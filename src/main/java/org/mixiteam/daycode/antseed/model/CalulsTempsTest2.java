package org.mixiteam.daycode.antseed.model;



import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.mixiteam.daycode.antseed.Position;
import org.mixiteam.daycode.antseed.TrajetCalculateur;

public class CalulsTempsTest2 {

	
	
	@Test
	public void test() {
		System.out.println("test");
		Position depart=new Position("47.9844782", "0.2415538", null);
		Position arrivee=new Position( "47.99026", "0.23991", null);

		System.out.println( CalculsTemps.calculVitesseMoyenne(depart, arrivee, 40));
		System.out.println("test");
		
		
		
		
		
	}
}
