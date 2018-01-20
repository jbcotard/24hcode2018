package org.mixiteam.daycode.antseed.model;



import org.junit.jupiter.api.Test;
import org.mixiteam.daycode.antseed.Position;

class CalulsTempsTest {

	@Test
	void test() {
		Position depart=new Position("47.9844782", "0.2415538");
	
		Position arrivee=new Position( "47.99026", "0.23991" );
		
		System.out.println(CalculsTemps.caluTemps(depart, arrivee, 50, 50, 2));
		System.out.println(CalculsTemps.caluTemps(depart, arrivee, 50, 50, 0));
		System.out.println(CalculsTemps.caluTemps(depart, arrivee, 10, 10, 0));
		
	}

}
