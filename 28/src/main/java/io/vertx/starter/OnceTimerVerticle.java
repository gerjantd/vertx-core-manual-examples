package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;

public class OnceTimerVerticle extends AbstractVerticle {

  private long id;

  @Override
  public void start() throws Exception {
    id = vertx.setTimer(4000, new Handler<Long>() {
      @Override
      public void handle(Long aLong) {
        System.out.println(LocalDateTime.now() + " Once timer fired");
      }
    });
    System.out.println(LocalDateTime.now() + " OnceTimerVerticle::start: Done");
  }

  @Override
  public void stop() throws Exception {
    vertx.cancelTimer(id);
    System.out.println(LocalDateTime.now() + " OnceTimerVerticle::stop: Done");
  }

}

