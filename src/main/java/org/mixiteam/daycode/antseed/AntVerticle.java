package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.ext.unit.Async;

public class AntVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) throws Exception {



        System.out.println("Traitement ant ");

        // recuperation donnees graine

        HttpClient client = vertx.createHttpClient();



/*        HttpClientRequest request = client.post("https://f24h2018.herokuapp.com/auth/local", response -> {
            System.out.println("Received response with status code " + response.statusCode());
        });
*/

/*

        HttpClientRequest request = client.postAbs("https://f24h2018.herokuapp.com/auth/local", response -> {
            System.out.println("Received response with status code " + response.statusCode());
            response.bodyHandler( body -> System.out.println("Got data " + body.toString("ISO-8859-1")));

        });

        request.putHeader("content-length", "1000");
        request.putHeader("content-type", "text/plain");
        request.write("email=ant1@violet.ant&password=Prune");
        request.end();
*/


        //Async async = context.async();

        //HttpClient client = vertx.createHttpClient();

        HttpClientRequest request = client.post(443, "f24h2018.herokuapp.com", "/auth/local", response -> {



            System.out.println("Some callback " + response.statusCode());

            //async.complete();



        });

        String body = "{'email':'ant1@violet.ant','password':'Prune'}";

        request.putHeader("content-length", "1000");

        request.putHeader("content-type", "application/json");

        request.write(body);

        request.end();




// Now do stuff with the request
        //request.putHeader("content-length", "1000");
        //request.putHeader("content-type", "text/plain");
        //request.write("email=ant1@violet.ant&password=Prune");

// Make sure the request is ended when you're done with it
        //request.end();


        // definition zone à partir position graine


        // recuperation des zones


        // calcul du graphe des prositions


        // calcul de la ponderation des chemins


        // creation des positions

        // creation du parcours

    }
}
