package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.json.Json;
import io.vertx.ext.unit.Async;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AntVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> fut) throws Exception {


        // Check existence and delete
        /*vertx.fileSystem().exists("target/classes/ant1.json", result -> {
            if (result.succeeded() && result.result()) {
                vertx.fileSystem().delete("target/classes/ant1.json", r -> {
                    System.out.println("File deleted");
                });
            } else {
                System.err.println("Oh oh ... - cannot delete the file: " + result.cause());
            }
        });*/


        //int numeroGraine = 1;
        int numeroFourmis = 1;

        System.out.println(" @@@ Ant " + numeroFourmis + " en action @@@ ");

        /* recuperation data pour calcul trajectoire */


        // authent fourmis
        String token = ServeurAntSeed.auth("ant" + numeroFourmis + "@violet.ant", "Prune");
        //System.out.println("token : " + token);

        // recuperation data fourmis
        Position positionFourmis = ServeurAntSeed.getUserMe(token);
        //System.out.println(positionFourmis.toString());

        // recuperation data graine
        List<Seed> listeSeeds = ServeurAntSeed.searchSeed(token/*, numeroGraine*/);

        for (int i=1; i < listeSeeds.size(); i++) {

            int numeroGraine = i;
            Seed seed = listeSeeds.get(numeroGraine);
            //System.out.println(" # ant " + numeroFourmis + " -> graine " + numeroGraine + " [ " + seed.getName() + " ] ");


            Position positionGraine = new Position(seed.getLocation().getCoordinates()[0], seed.getLocation().getCoordinates()[1]);
            //System.out.println(positionGraine.toString());



            /*  trajectoire  aller */

            System.out.println(" @@@ Ant " + numeroFourmis + " ## fourmiliere >> graine " + numeroGraine + " [ " + seed.getName() + " ] ");


            // calcul trajectoire aller
            List<Position> listePositionsTrajet = TrajetCalculateur.calculerPositionsTrajet(positionFourmis, positionGraine, true);

            // init trajectoire aller
            Track trackAller = ServeurAntSeed.createTrack(token, listeSeeds.get(0).get_id(), listeSeeds.get(numeroGraine).get_id(), numeroFourmis);


            // enregistrement position du track
            String trackAllerId = trackAller.get_id();
            //System.out.println("trackId aller : " + trackAllerId);
            ServeurAntSeed.bulkCreatePositions(token, trackAllerId, listePositionsTrajet);

            // enregistrement final de la trajectoire aller
            Track trackAllerFinal = ServeurAntSeed.endTrack(token, trackAllerId, numeroFourmis);


            /* trajectoire retour */

            System.out.println(" @@@ Ant " + numeroFourmis +" ##  graine " + numeroGraine + " >> fourmiliere " + listeSeeds.get(0).get_id() + " [ " + listeSeeds.get(0).getName() + " ] ");


            // calcul trajectoire retour
            List<Position> listePositionsTrajetRetour = TrajetCalculateur.calculerPositionsTrajet(positionFourmis, positionGraine, false);

            // init trajectoire aller
            Track trackRetour = ServeurAntSeed.createTrack(token, listeSeeds.get(numeroGraine).get_id(), listeSeeds.get(0).get_id(), numeroFourmis);

            // enregistrement position du track
            String trackRetourId = trackRetour.get_id();
            //System.out.println("trackId aller : " + trackRetourId);
            ServeurAntSeed.bulkCreatePositions(token, trackRetourId, listePositionsTrajetRetour);

            // enregistrement final de la trajectoire aller
            Track trackRetourFinal = ServeurAntSeed.endTrack(token, trackRetourId, numeroFourmis);


// enregistrement pour derniere graine
            //if (i == listeSeeds.size() -1) {


                // Write a file
            /*List<PositionWithFloat> listePositionsAller = listePositionsTrajet.stream().map(p ->
                    {
                        new PositionWithFloat(p);

                    }
            ).collect(Collectors.toList());*/

            /*List<PositionForIHM> listePositionsAller = new ArrayList<PositionForIHM>();
            Position positionPrecedente = listePositionsTrajet.get(0);
            for (int ind=1; ind < listePositionsTrajet.size(); i++) {
                PositionForIHM position = new PositionForIHM(listePositionsTrajet.get(ind), positionPrecedente);
                listePositionsAller.add(position);
                positionPrecedente = listePositionsTrajet.get(ind);
            }*/


            /*List<PositionWithFloat> listePositionsRetour = listePositionsTrajetRetour.stream().map(p ->
                    new PositionWithFloat(p)
            ).collect(Collectors.toList());
            */

            /*List<PositionForIHM> listePositionsRetour = new ArrayList<PositionForIHM>();
            positionPrecedente = listePositionsTrajetRetour.get(0);
            for (int ind=1; ind < listePositionsTrajetRetour.size(); i++) {
                PositionForIHM position = new PositionForIHM(listePositionsTrajetRetour.get(ind), positionPrecedente);
                listePositionsRetour.add(position);
                positionPrecedente = listePositionsTrajetRetour.get(ind);
            }*/

            //    String arrayPositionsAller = Json.encode(listePositionsTrajet.toArray());
              //  String arrayPositionsRetour = Json.encode(listePositionsTrajetRetour.toArray());
/*
            Buffer buffer = Buffer.buffer("[ { \"aller\": " + arrayPositionsAller + ", \"retour\": " + arrayPositionsRetour  +  " } ] ");
            vertx.fileSystem().writeFile("target/classes/ant1.json", buffer, result -> {
                if (result.succeeded()) {

                    System.out.println("File written");
                } else {
                    System.err.println("Oh oh ..." + result.cause());
                }
            });



            /*vertx.fileSystem().open("target/classes/ant1.json", new OpenOptions().setAppend(true), ar -> {
                if (ar.succeeded()) {
                    AsyncFile ws = ar.result();

                        Buffer chunk = Buffer.buffer("[ { \"aller\": " + arrayPositionsAller + ", \"retour\": " + arrayPositionsRetour  +  " } ] ");
                        ws.write(chunk);

                } else {
                    System.err.println("Could not open file");
                }
            });*/
            //}*/


        }

        fut.complete();
    }
}
