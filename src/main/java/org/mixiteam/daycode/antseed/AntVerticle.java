package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.ext.unit.Async;

import java.util.List;

public class AntVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {


        int numeroGraine = 1;
        int numeroFourmis = 1;

        System.out.println("Traitement ant " + numeroFourmis);

        /* recuperation data pour calcul trajectoire */


        // authent fourmis
        String token = ServeurAntSeed.auth("ant1@violet.ant", "Prune");
        System.out.println("token : " + token);

        // recuperation data fourmis
        Position positionFourmis = ServeurAntSeed.getUserMe(token);
        System.out.println(positionFourmis.toString());

        // recuperation data graine
        List<Seed> listeSeeds = ServeurAntSeed.searchSeed(token, numeroGraine);
        Seed seed = listeSeeds.get(1);
        Position positionGraine = new Position(seed.getLocation().getCoordinates()[0], seed.getLocation().getCoordinates()[1]);
        System.out.println(positionGraine.toString());


        /*  trajectoire  aller */

        // calcul trajectoire aller
        List<Position> listePositionsTrajet = TrajetCalculateur.calculerPositionsTrajet(positionFourmis, positionGraine, true);

        // init trajectoire aller
        Track trackAller = ServeurAntSeed.createTrack(token, listeSeeds.get(0).get_id(), listeSeeds.get(1).get_id(), numeroFourmis);

        // enregistrement position du track
        String trackAllerId = trackAller.get_id();
        ServeurAntSeed.bulkCreatePositions(token, trackAllerId, listePositionsTrajet);

        // enregistrement final de la trajectoire aller
        Track trackAllerFinal = ServeurAntSeed.endTrack(token, trackAllerId, numeroFourmis);


        /* trajectoire retour */

        // calcul trajectoire retour
        List<Position> listePositionsTrajetRetour = TrajetCalculateur.calculerPositionsTrajet(positionFourmis, positionGraine,  false);

        // init trajectoire aller
        Track trackRetour = ServeurAntSeed.createTrack(token, listeSeeds.get(1).get_id(), listeSeeds.get(0).get_id(), numeroFourmis);

        // enregistrement position du track
        String trackRetourId = trackRetour.get_id();
        ServeurAntSeed.bulkCreatePositions(token, trackRetourId, listePositionsTrajetRetour);

        // enregistrement final de la trajectoire aller
        Track trackRetourFinal = ServeurAntSeed.endTrack(token, trackRetourId, numeroFourmis);

    }
}
