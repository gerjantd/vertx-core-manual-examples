package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class MainVerticle extends AbstractVerticle {

/*
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
      System.out.println("Request received");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println("HTTP server started on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }
*/

  @Override
  public void start() throws Exception {

    vertx.deployVerticle(new HttpServerVerticle());
    System.out.println("Deployed HttpServerVerticle from MainVerticle");

    vertx.deployVerticle(new OnceTimerVerticle());
    System.out.println("Deployed OnceTimerVerticle from MainVerticle");

    vertx.deployVerticle(new PeriodicTimerVerticle());
    System.out.println("Deployed PeriodicTimerVerticle from MainVerticle");

    System.out.println("MainVerticle started");

  }

  @Override
  public void stop() throws Exception {
    System.out.println("MainVerticle stopped");
  }
}
