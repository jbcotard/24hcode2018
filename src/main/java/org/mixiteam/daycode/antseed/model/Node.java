package org.mixiteam.daycode.antseed.model;

import org.mixiteam.daycode.antseed.Position;
// Commentaire
public class Node
{
    Position position;
    int temps_attente;
    int temps_passe;
    int vitesse;

    public Node(Position p, int ta, int tp, int v)
    {
    	this.position = p;
    	this.temps_attente = ta;
    	this.temps_passe = tp;
    	this.vitesse = v;
    }

    public void setPosition(Position p)
    {
        this.position = p;
    }

    public void setTempsAttente(int v)
    {
        this.temps_attente = v;
    }

    public void setTempsPasse(int v)
    {
        this.temps_passe = v;
    }

    public void setVitesse(int v)
    {
        this.vitesse = v;
    }

    public Position getPosition()
    {
        return position;
    }

    public int getTempsAttente()
    {
        return temps_attente;
    }

    public int getTempsPasse()
    {
        return temps_passe;
    }

    public int getVitesse()
    {
        return vitesse;
    }
}