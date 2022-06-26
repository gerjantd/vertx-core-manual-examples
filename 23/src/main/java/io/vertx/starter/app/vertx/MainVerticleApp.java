package io.vertx.starter.app.vertx;

import io.vertx.core.Vertx;
import io.vertx.starter.verticle.MainVerticle;

public class MainVerticleApp {

  public static void main(String[] args) throws InterruptedException {

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());

  }

}
