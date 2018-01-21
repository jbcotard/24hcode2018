package org.mixiteam.daycode.antseed;

import java.io.IOException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mixiteam.daycode.antseed.model.CalculTrajet;
import org.mixiteam.daycode.antseed.model.CalculsTemps;
import org.mixiteam.daycode.antseed.model.GetOverPass;
import org.mixiteam.daycode.antseed.model.GetTrajetAPI;
import org.mixiteam.daycode.antseed.model.Node;
import org.mixiteam.daycode.antseed.model.Vitesse_instantanee;
import org.mixiteam.daycode.antseed.model.json.Element;
import org.mixiteam.daycode.antseed.model.json.Routes;

import io.vertx.core.json.Json;

public class TrajetCalculateur {


    public static List<Position> calculerPositionsTrajet(Position positionDepart, Position positionArrive, boolean trajetAller) {

		List<Node> listeNode = new ArrayList<Node>();
    	 // calcul du chemin a effectuer
    	try {
    		String s = GetTrajetAPI.getTrajetLePlusCourt(positionDepart,positionArrive);
			
			Routes route=CalculTrajet.getTrajet(s);
			
			String over = GetOverPass.getWayOverPass(positionDepart,positionArrive);
			
			HashMap<Long, Element> elements=CalculTrajet.getNoeuds(over);
		
			List<String> nodes = route.getLegs().get(0).getAnnotations().getNodes();

			for(int i=0;i<nodes.size();i++)
			{
				String id=nodes.get(i);
				Element node = elements.get(Long.valueOf(id));
				Element way = null;
				
				for(Entry<Long, Element> entry : elements.entrySet()) 
				{
					Element tmp = entry.getValue();
					if (tmp.getNodes() !=null)
					{
						List<String> listNodes = tmp.getNodes();
						if (listNodes.toString().contains(id))
						{
							way = tmp;
							break;
						}
					}
				}
				String vitesse = "48";
				if (way != null && way.getTags() != null)
				{
					Map<String,String> tags = way.getTags();
					String v = tags.get("maxspeed");
					if (v != null && !v.equals(""))
					{
						vitesse = v;
						if (v.equals("50"))
						{

							vitesse = "48";
						}
						if (v.equals("30"))
						{

							vitesse = "28";
						}
						if (v.equals("70"))
						{

							vitesse = "68";
						}
						if (v.equals("90"))
						{

							vitesse = "88";
						}
					}
				}
				int temps_attente = 0; 
				if (node != null && node.getTags() != null)
				{
					Map<String,String> tags = node.getTags();
					String t = tags.get("highway");
					if (t != null && ( t.equals("traffic_signals") || t.equals("stop")))
					{
						temps_attente = 2;
					}
				}
				Node myNode = new Node();
				myNode.setPosition(new Position(Double.toString(node.getLat()), Double.toString(node.getLon())));
				myNode.setVitesse(Integer.parseInt(vitesse));
				myNode.setTempsAttente(temps_attente);
				listeNode.add(myNode);
			}

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    	
    	//Cr�ation des dur�es
    	List<Node> liste = new ArrayList<Node>();
    	liste.add(listeNode.get(0));
    	for(int i=1; i<listeNode.size();i++)
    	{
    		Node noeud1 = listeNode.get(i-1);
    		Node noeud2 = listeNode.get(i);
    		Vitesse_instantanee v = CalculsTemps.caluTemps(noeud1.getPosition(), noeud2.getPosition(), noeud1.getVitesse(), noeud1.getVitesse(), noeud2.getTempsAttente());
    		noeud2.setTempsPasse(v.getTemps());
    		liste.add(noeud2);
    	}


        // creation des positions
    	List<Position> positions = creerPositions(liste);
    	//System.out.println(Json.encode(positions.toArray()));
    	/*for (int i=0;i<positions.size();i++)
    	{
    		System.out.println(positions.get(i).toString());
    	}*/

        // creation du parcours


        return positions;
    }
    
    public static List<Position> creerPositions(List<Node> listeNode)
    {
    	Instant base = Instant.now();;
    	base.plusSeconds(2);
    	List<Position> liste = new ArrayList<Position>();
    	for (int i=0; i<listeNode.size() ; i++)
    	{
    		base = base.plusMillis(listeNode.get(i).getTempsPasse());
    		Position p = listeNode.get(i).getPosition();
    		p.setDuree(listeNode.get(i).getTempsPasse());
    		
    		//System.out.println("{\n\t\"lat\" : "+p.lat+",\n\t\"lon\" : "+p.lon+",\n\t\"delai\" : "+listeNode.get(i).getTempsPasse()+"\n}");
    		p.timestamp = base;
    		liste.add(p);
    		
    		
    	}
    	
    	return liste;
    }
    
    public static List<Node> creerTrajet(Position positionGraine, boolean trajetAller)
    {
    	List<Node> graines = recupererDonnees.recuperer(positionGraine, trajetAller);
    	List<Node> liste = new ArrayList<Node>();
    	liste.add(graines.get(0));
    	for(int i=1; i<graines.size();i++)
    	{
    		Node noeud1 = graines.get(i-1);
    		Node noeud2 = graines.get(i);
    		Vitesse_instantanee v = CalculsTemps.caluTemps(noeud1.getPosition(), noeud2.getPosition(), noeud1.getVitesse(), noeud1.getVitesse(), noeud2.getTempsAttente());
    		noeud2.setTempsPasse(v.getTemps());
    		liste.add(noeud2);
    	}
    	return liste;
    }
    
    /*public static List<Node> creerTrajet()
    {
    	List<Node> graine1Aller = recupererDonnees.graine1Aller();
    	List<Node> liste = new ArrayList<Node>();
    	int indexStop = -1;
    	
    	for(int i=1; i<graine1Aller.size();i++)
    	{
    		if (i < indexStop) continue;
    		Node noeud1 = graine1Aller.get(i-1);
    		Node noeud2 = graine1Aller.get(i);
    		
    		float temps = Outils.getTemps(noeud1, noeud2);
    		if (temps > 1)
    		{
    			List<Node> noeudsIntercalaires = DecoupagePortionRoute.decoupageTrajet(noeud1, noeud2);
    			for (Node node : noeudsIntercalaires) {
					liste.add(node);	
    			}
    		}else
    		{
    			//Si le temps est inferieur a 1s, on cumule jusqua trouver 1s
    			float tempsCumule = temps;
    			int index = i;
    			float lastTemps = 0;
    			while (tempsCumule<1 && index+1<graine1Aller.size())
    			{
    	    		Node noeud3 = graine1Aller.get(index);
    	    		Node noeud4 = graine1Aller.get(index+1);
    	    		lastTemps = Outils.getTemps(noeud1, noeud2);
    				tempsCumule += lastTemps;
    				index++;
    			}
    			tempsCumule -= lastTemps;
    			indexStop = index;
    			for(int j=i; j<indexStop; j++)
    			{
    				liste.add(graine1Aller.get(j));
    			}
    			
    		}
    	}
    }*/
    
}
