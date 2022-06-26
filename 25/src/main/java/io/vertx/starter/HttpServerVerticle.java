package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class HttpServerVerticle extends AbstractVerticle {

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
        System.out.println("HTTP server verticle started; listening on port 8888");
      } else {
        startPromise.fail(http.cause());
      }
    });
  }

  @Override
  public void stop() throws Exception {
    System.out.println("HTTP server verticle stopped");
  }

}
