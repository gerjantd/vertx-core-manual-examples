package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class HttpServerVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.createHttpServer()
      .requestHandler(req -> req.response().end("Hello Vert.x!"))
      .listen(8080);
  }

}
