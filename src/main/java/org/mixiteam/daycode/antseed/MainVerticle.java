package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.ext.unit.Async;
import org.mixiteam.daycode.antseed.AntVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        System.out.println("Demarrage appli Ant-Seed");

        // demarrage fourmis
		vertx.deployVerticle(new AntVerticle());


    }
}
