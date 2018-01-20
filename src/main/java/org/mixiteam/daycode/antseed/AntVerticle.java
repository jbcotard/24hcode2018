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
    public void start(Future<Void> future) throws Exception {



        System.out.println("Traitement ant ");

        /* recuperation donnees graine */

        // authent fourmis
        String token = ServeurAntSeed.auth("ant1@violet.ant", "Prune");
        System.out.println("token : " + token);

        // recuperation data fourmis
        Position positionFourmis = ServeurAntSeed.getUserMe(token);
        System.out.println(positionFourmis.toString());



        /* calcul trajectoire */


        Position positionGraine = null;
        List<Position> listePositionsTrajet = TrajetCalculateur.calculerPositionsTrajet(positionFourmis, positionGraine);



    }
}
