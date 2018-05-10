package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class BasicVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    System.out.println("BasicVerticle started");
  }

  @Override
  public void stop() throws Exception {
    System.out.println("BasicVerticle stopped");
  }

}
