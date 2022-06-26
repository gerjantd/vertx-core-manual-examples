package io.vertx.starter;

import io.vertx.core.Vertx;

public class VertxApp {

  public static void main(String[] args) throws InterruptedException {

    Vertx vertx = Vertx.vertx();

    vertx.deployVerticle(new EventBusReceiverVerticle("R1"), stringAsyncResult -> {
      System.out.println("EventBusReceiverVerticle R1 deployment complete");
    });

    vertx.deployVerticle(new EventBusReceiverVerticle("R2"), stringAsyncResult -> {
      System.out.println("EventBusReceiverVerticle R2 deployment complete");
    });

    Thread.sleep(2000);

    vertx.deployVerticle(new EventBusSenderVerticle(), stringAsyncResult -> {
      System.out.println("EventBusSenderVerticle deployment complete");
    });

  }

}
