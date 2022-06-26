package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;

public class PeriodicTimerVerticle extends AbstractVerticle {

  private long id;

  @Override
  public void start() throws Exception {
    id = vertx.setPeriodic(2000, new Handler<Long>() {
      @Override
      public void handle(Long aLong) {
        System.out.println("Periodic timer fired");
      }
    });
  }

  @Override
  public void stop() throws Exception {
    vertx.cancelTimer(id);
  }

}

