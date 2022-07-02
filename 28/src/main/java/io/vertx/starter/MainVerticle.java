package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    vertx.deployVerticle(new EventBusReceiverVerticle("R1"), stringAsyncResult -> {
      System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " (Handler::handle): EventBusReceiverVerticle R1 deployed, handler called with async result");
    });
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " MainVerticle::start: Deploying EventBusReceiverVerticle R1 async, will call handler when deployed");

    vertx.deployVerticle(new EventBusReceiverVerticle("R2"), stringAsyncResult -> {
      System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " (Handler::handle): EventBusReceiverVerticle R2 deployed, handler called with async result");
    });
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " MainVerticle::start: Deploying EventBusReceiverVerticle R2 async, will call handler when deployed");

    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " MainVerticle::start: Sleeping 2000 ms");
    Thread.sleep(2000);

    vertx.deployVerticle(new EventBusSenderVerticle(), stringAsyncResult -> {
      System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " (Handler::handle): EventBusSenderVerticle deployed, handler called with async result");
    });
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " MainVerticle::start: Deploying EventBusSenderVerticle async, will call handler when deployed");

    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " MainVerticle::start: Done");

  }

  @Override
  public void stop() throws Exception {
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " MainVerticle::stop: Done");
  }
}
