package org.mixiteam.daycode.antseed;

import java.util.ArrayList;
import java.util.List;

import org.mixiteam.daycode.antseed.model.Node;

public class recupererDonnees {
	
	public static List<Node> recuperer(Position graine, boolean trajetAller)
	{
    	if (trajetAller)
    	{
    		List<Node> g1 = graine1Aller();
    		if (graine.lat.equals(g1.get(g1.size()-1).getPosition().lat) && graine.lon.equals(g1.get(g1.size()-1).getPosition().lon))
    		{
    			return g1;
    		}
    	}else
    	{
    		List<Node> g1 = graine1Retour();
    		if (graine.lat.equals(g1.get(0).getPosition().lat) && graine.lon.equals(g1.get(0).getPosition().lon))
    		{
    			return g1;
    		}
    	}
    	return null;
	}

	public static List<Node> graine1Retour()
	{
		List<Node> liste = new ArrayList<>();
		liste.add(0,new Node(new Position("47.9844782", "0.2415538", null), 2, 0, 48));
		liste.add(0,new Node(new Position("47.9844498", "0.2418012", null), 2, 0, 48));
		liste.add(0,new Node(new Position("47.9843731", "0.2426022", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9844975","0.2425992", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9848961","0.2426151", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.985483","0.2425883", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9856336","0.2425849", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9857435","0.2425778", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9858002","0.2425916", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9862915","0.2426754", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9863558","0.242688", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9868836","0.2427915", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9869415","0.2428158", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9870592","0.2428837", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9871275","0.2429409", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9872086","0.2430087", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9872806","0.2430863", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9873671","0.2431911", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9874065","0.2432862", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9875207","0.2434898", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9875897","0.2436449", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9876847","0.2437609", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9877556","0.2438196", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9878464","0.2438766", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.987995","0.2439605", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9880515","0.2439707", null), 0, 0, 48)); //ROND POINT
		liste.add(0,new Node(new Position("47.9880626","0.2439321", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9880818","0.2439014", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9881134","0.24388", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9881415","0.2438784", null), 2, 0, 48)); //OUT
		liste.add(0,new Node(new Position("47.9881697","0.2434461", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9881977","0.2432125", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9882557","0.2428869", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.988374","0.2425524", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9883821","0.2425296", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9884296","0.2424319", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9885381","0.2422088", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9885562","0.2421669", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9890286","0.2415499", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9891697","0.2413603", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9893744","0.2411279", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9895798","0.2408946", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.9900658","0.2402675", null), 0, 0, 48));
		liste.add(0,new Node(new Position("47.99026","0.23991", null), 0, 0, 48));
		return liste;
	}
	
	public static List<Node> graine1Aller()
	{
		List<Node> liste = new ArrayList<>();
		liste.add(new Node(new Position("47.9844782", "0.2415538", null), 2, 0, 48));
		liste.add(new Node(new Position("47.9844498", "0.2418012", null), 2, 0, 48));
		liste.add(new Node(new Position("47.9843731", "0.2426022", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9844975","0.2425992", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9848961","0.2426151", null), 0, 0, 48));
		liste.add(new Node(new Position("47.985483","0.2425883", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9856336","0.2425849", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9857435","0.2425778", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9858002","0.2425916", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9862915","0.2426754", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9863558","0.242688", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9868836","0.2427915", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9869415","0.2428158", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9870592","0.2428837", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9871275","0.2429409", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9872086","0.2430087", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9872806","0.2430863", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9873671","0.2431911", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9874065","0.2432862", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9875207","0.2434898", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9875897","0.2436449", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9876847","0.2437609", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9877556","0.2438196", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9878464","0.2438766", null), 0, 0, 48));
		liste.add(new Node(new Position("47.987995","0.2439605", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9880515","0.2439707", null), 2, 0, 48)); //ROND POINT
		liste.add(new Node(new Position("47.98805","0.2440126", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9880581","0.2440528", null), 0, 0, 48));
		liste.add(new Node(new Position("47.988075","0.2440864", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9880985","0.2441094", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881157","0.2441171", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881438","0.2441174", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881703","0.2441033", null), 0, 0, 48));
		liste.add(new Node(new Position("47.988192","0.2440766", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9882002","0.2440591", null), 0, 0, 48));
		liste.add(new Node(new Position("47.98821","0.2440198", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9882101","0.2439778", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9882006","0.2439382", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881826","0.2439059", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881584","0.2438848", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881415","0.2438784", null), 0, 0, 48)); //OUT
		liste.add(new Node(new Position("47.9881697","0.2434461", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9881977","0.2432125", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9882557","0.2428869", null), 0, 0, 48));
		liste.add(new Node(new Position("47.988374","0.2425524 ", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9883821","0.2425296", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9884296","0.2424319", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9885381","0.2422088", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9885562","0.2421669", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9890286","0.2415499", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9891697","0.2413603", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9893744","0.2411279", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9895798","0.2408946", null), 0, 0, 48));
		liste.add(new Node(new Position("47.9900658","0.2402675", null), 0, 0, 48));
		liste.add(new Node(new Position("47.99026","0.23991", null), 0, 0, 48));
		
		return liste;
	}
	

}
