
package org.mixiteam.daycode.antseed.model;

import org.mixiteam.daycode.antseed.Position;

public class Node
{
    Position position;
    int temps_attente;
    int temps_passe;
    int vitesse;

    public Node()
    {
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