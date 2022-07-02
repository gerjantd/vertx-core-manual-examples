package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class EventBusSenderVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.eventBus().publish("theAddress", "Message A - published");
    vertx.eventBus().send("theAddress", "Message B - sent");
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusSenderVerticle::start: Done");
   }

  @Override
  public void stop() throws Exception {
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusSenderVerticle::stop: Done");
  }

}
