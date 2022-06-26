package io.vertx.starter;

import io.vertx.core.AbstractVerticle;

public class SecondVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {
    System.out.println("SecondVerticle started");
  }

  @Override
  public void stop() throws Exception {
    System.out.println("SecondVerticle stopped");
  }

}
