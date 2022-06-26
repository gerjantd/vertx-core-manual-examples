package io.vertx.starter;

import io.vertx.core.Vertx;

public class VertxApp {

  public static void main(String[] args) throws InterruptedException {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new HttpServerVerticle(), stringAsyncResult -> {
      System.out.println("HttpServerVerticle deployment complete");
    });

  }

}
