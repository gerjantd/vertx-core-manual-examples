package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class EventBusReceiverVerticle extends AbstractVerticle {

  private String name;

  public EventBusReceiverVerticle(String name) {
    this.name = name;
  }

  @Override
  public void start() {
    vertx.eventBus().consumer("theAddress", message -> {
      System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " " + this.name + " received message: " + message.body());
    });
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusReceiverVerticle::start: Done");
   }

  @Override
  public void stop() throws Exception {
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusReceiverVerticle::stop: Done");
  }

}
