package org.mixiteam.daycode.antseed;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxException;
import io.vertx.core.file.AsyncFile;
import io.vertx.core.file.OpenOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.streams.Pump;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class MainVerticle extends AbstractVerticle {


    public static void main(String[] args) {

        try {
            Vertx vertx = Vertx.vertx();
            vertx.deployVerticle(new MainVerticle());
        } catch (VertxException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void start(Future<Void> fut) throws Exception {

        System.out.println("#########################");
        System.out.println("");
        System.out.println("Demarrage appli Ant-Seed");
        System.out.println("");
        System.out.println("#########################");

        // demarrage fourmis
        vertx.deployVerticle(new AntVerticle());

        // demarrage cigale
        vertx.deployVerticle(new CicadaVerticle());

        Router router = Router.router(vertx);
        router.route("/").handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response
                    .putHeader("content-type", "text/html")
                    .end("<h1>Hello from my first Vert.x 3 application</h1>");
        });

        router.route(HttpMethod.GET, "/api/ant1").handler(rtx -> {
            HttpServerResponse response = rtx.response();
            response.putHeader("content-type", "application/json");
            response.setChunked(true);
            vertx.fileSystem().open("target/classes/ant1.json", new OpenOptions(), file -> {
                AsyncFile asyncFile = file.result();
                Pump pump = Pump.pump(asyncFile, response);
                response.closeHandler(res -> {
                    System.out.println("completed");
                });
                response.exceptionHandler(ex ->
                {
                    System.err.println("exception");
                    ex.printStackTrace();
                });
                pump.start();
            });
        });

        // Serve static resources from the /assets directory
        router.route("/assets/*").handler(StaticHandler.create("assets"));

        vertx
                .createHttpServer()
                .requestHandler(router::accept)
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080),
                        result -> {
                            if (result.succeeded()) {
                                fut.complete();
                            } else {
                                fut.fail(result.cause());
                            }
                        }
                );


    }
}
