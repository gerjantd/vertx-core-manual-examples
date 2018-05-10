package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class HttpServerVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.createHttpServer()
      .requestHandler(req -> {
        System.out.println("Thread name: "+Thread.currentThread().getName());
        System.out.println("Thread id: "+Thread.currentThread().getId());
        System.out.println("HttpServerVerticle::start requestHandler");
        System.out.println("Request received");
        req.response().end("Hello Vert.x!");
        System.out.println("Response sent");
      })
      .listen(8080);
  }

}
