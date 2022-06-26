package io.vertx.starter.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  private long oneTimeTimerID, periodicTimerID;

  @Override
  public void start() throws Exception {
    oneTimeTimerID = vertx.setTimer(2000, new Handler<Long>() {
      @Override
      public void handle(Long aLong) {
        System.out.println("One-time timer fired");
      }
    });
    periodicTimerID = vertx.setPeriodic(3000, new Handler<Long>() {
      @Override
      public void handle(Long aLong) {
        System.out.println("Periodic timer fired");
      }
    });
  }

  @Override
  public void stop() throws Exception {
    vertx.cancelTimer(oneTimeTimerID);
    vertx.cancelTimer(periodicTimerID);
  }

}

