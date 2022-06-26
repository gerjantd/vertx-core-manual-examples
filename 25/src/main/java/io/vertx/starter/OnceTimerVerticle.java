package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;

public class OnceTimerVerticle extends AbstractVerticle {

  private long id;

  @Override
  public void start() throws Exception {
    id = vertx.setTimer(1000, new Handler<Long>() {
      @Override
      public void handle(Long aLong) {
        System.out.println("Once timer fired");
      }
    });
    System.out.println("OnceTimerVerticle started");
  }

  @Override
  public void stop() throws Exception {
    vertx.cancelTimer(id);
    System.out.println("OnceTimerVerticle stopped");
  }

}

