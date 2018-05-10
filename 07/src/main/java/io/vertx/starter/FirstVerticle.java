package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class FirstVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    vertx.deployVerticle(new SecondVerticle());
    System.out.println("Deployed SecondVerticle from FirstVerticle");
    System.out.println("FirstVerticle started");
  }

  @Override
  public void stop() throws Exception {
    System.out.println("FirstVerticle stopped");
  }

}
