package org.mixiteam.daycode.antseed;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mixiteam.daycode.antseed.model.CalculsTemps;
import org.mixiteam.daycode.antseed.model.Node;
import org.mixiteam.daycode.antseed.model.Vitesse_instantanee;

public class TrajetCalculateur {


    public static List<Position> calculerPositionsTrajet(Position positionFourmis, Position positionGraine) {

        // definition zone Ã  partir position graine


        // recuperation des zones


        // calcul du graphe des prositions


        // calcul de la ponderation des chemins


        // creation des positions
    	List<Node> liste = creerTrajet();

        // creation du parcours


        return new ArrayList<Position>();
    }
    
    public static List<Position> creerPositions(List<Node> listeNode)
    {
    	ZonedDateTime base = ZonedDateTime.now();
    	base.plusSeconds(2);
    	List<Position> liste = new ArrayList<Position>();
    	for (int i=0; i<listeNode.size() -1; i++)
    	{
    		base.plusSeconds(listeNode.get(i).getTempsPasse());
    		base.plusSeconds(listeNode.get(i).getTempsAttente());
    		Position p = listeNode.get(i).getPosition();
    		p.timestamp = base;
    		liste.add(p);
    	}
    	
    	return liste;
    }
    
    public static List<Node> creerTrajet()
    {
    	List<Node> graine1Aller = recupererDonnees.graine1Aller();
    	List<Node> liste = new ArrayList<Node>();
    	
    	for(int i=1; i<graine1Aller.size();i++)
    	{
    		Node noeud1 = graine1Aller.get(i-1);
    		Node noeud2 = graine1Aller.get(i);
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
    			//Si le temps est inférieur a 1s, on cumule jusqua trouver 1s
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
