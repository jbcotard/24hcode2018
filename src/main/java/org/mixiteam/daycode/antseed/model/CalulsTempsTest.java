package org.mixiteam.daycode.antseed.model;



import java.util.List;

import org.junit.Test;
import org.mixiteam.daycode.antseed.Position;
import org.mixiteam.daycode.antseed.TrajetCalculateur;

public class CalulsTempsTest {

	@Test
	public void test() {
		/*Position depart=new Position("47.9844782", "0.2415538", null);
	
		Position arrivee=new Position( "47.99026", "0.23991", null);
		
		System.out.println(CalculsTemps.caluTemps(depart, arrivee, 50, 50, 2));
		System.out.println(CalculsTemps.caluTemps(depart, arrivee, 50, 50, 0));
		System.out.println(CalculsTemps.caluTemps(depart, arrivee, 10, 10, 0));
		*/

		List<Position> listePositionsTrajet = TrajetCalculateur.calculerPositionsTrajet(new Position("47.9827689", "0.2328369", null), new Position("47.9827689", "0.2328369", null), true);

    	for (int i=0;i<listePositionsTrajet.size();i++)
    	{
    		System.out.println(listePositionsTrajet.get(i).toString());
    	}
    	
    	System.out.println("RETOUR");
    	listePositionsTrajet = TrajetCalculateur.calculerPositionsTrajet(new Position("47.9827689", "0.2328369", null), new Position("47.9827689", "0.2328369", null), false);

    	for (int i=0;i<listePositionsTrajet.size();i++)
    	{
    		System.out.println(listePositionsTrajet.get(i).toString());
    	}
	}
	
	

}
