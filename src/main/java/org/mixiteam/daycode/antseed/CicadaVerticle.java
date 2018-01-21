package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;

import java.util.List;

public class CicadaVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        System.out.println("Traitement cigale ");

        // authent cigada
        String token = ServeurAntSeed.auth("cicada@violet.ant", "Prune");
        System.out.println("token : " + token);

        // recuperation liste des track des autres équipes
        List<Track> listeTracksOtherTeams = ServeurAntSeed.getTracksOtherTeams(token);

        // pour chaque track, on analyse les positions invalides
        // et celles qui le sont, declaration d'une analyse sur le serveur
        //listeTracksOtherTeams.stream().map(t -> )

    }
}
