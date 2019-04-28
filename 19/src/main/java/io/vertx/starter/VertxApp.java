package io.vertx.starter;

import io.vertx.core.Vertx;

public class VertxApp {

  public static void main(String[] args) throws InterruptedException {

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());

  }

}
