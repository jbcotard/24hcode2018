package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {


    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MainVerticle());
    }

    @Override
    public void start() throws Exception {

        System.out.println("Demarrage appli Ant-Seed");

        // demarrage fourmis
		vertx.deployVerticle(new AntVerticle());

		// demarrage cigale
        vertx.deployVerticle(new CicadaVerticle());

    }
}
