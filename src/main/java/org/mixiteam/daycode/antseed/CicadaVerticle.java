package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Verticle;
import org.mixiteam.daycode.antseed.model.CalculsTemps;
import org.mixiteam.daycode.antseed.model.Vitesse_instantanee;

import javax.xml.bind.SchemaOutputResolver;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class CicadaVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) throws Exception {


        System.out.println(" @@@ Cigale en action @@@ ");

        // authent cigada
        String token = ServeurAntSeed.auth("cicada@violet.ant", "Prune");
        System.out.println("token : " + token);

        // recuperation liste des track des autres équipes
        List<Track> listeTracksOtherTeams = ServeurAntSeed.getTracksOtherTeams(token);

        // pour chaque track, on analyse les positions invalides
        // et celles qui le sont, declaration d'une analyse sur le serveur

        listeTracksOtherTeams.forEach(t -> {
            analyseTrackOtherTeam(token, t);
        });



        fut.complete();

    }

    /**
     * analyse track d'une autre equipe
     * @param token
     * @param t
     */
    private void analyseTrackOtherTeam(String token, Track t) {
        try {
            boolean isTrackValid = true;
            List<Position> positionsOfTrack = ServeurAntSeed.getPositionsOfTrack(token, t.get_id());
            if (positionsOfTrack.size() > 1) {

                Position positionPrecedente = positionsOfTrack.get(0);
                for (int i=1; i < positionsOfTrack.size(); i++) {

                    Vitesse_instantanee vitesse_instantanee =
                            CalculsTemps.calculVitesseMoyenne(
                                    positionPrecedente,
                                    positionsOfTrack.get(i),
                                    ChronoUnit.MILLIS.between(
                                            positionPrecedente.getTimestamp(),
                                            positionsOfTrack.get(i).getTimestamp()));
                    if (vitesse_instantanee.getVitesse() > 50 && isTrackValid) {
                        System.out.println(" ## CIGALE :: detection exces de vitesse [ " + t.get_id() + " ], position " + positionsOfTrack.get(i).get_id());
                        ServeurAntSeed.createCicadaAnalyse(token,t.get_id(), positionsOfTrack.get(i).get_id());
                        isTrackValid = false;
                    }
                    positionPrecedente = positionsOfTrack.get(i);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
