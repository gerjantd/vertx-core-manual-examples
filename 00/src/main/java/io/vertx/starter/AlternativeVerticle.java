package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class AlternativeVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.createHttpServer()
        .requestHandler(req -> req.response().end("Goodbye Vert.x!"))
        .listen(8080);
  }

}
