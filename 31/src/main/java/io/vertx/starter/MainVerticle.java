package io.vertx.starter;

import java.time.LocalDateTime;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

    vertx.deployVerticle(new HttpServerVerticle(), ar -> {
      log(new Throwable(), "HttpServerVerticle deployed, handler called with async result: " + ar.toString());
    });
    log(new Throwable(), "Deploying HttpServerVerticle, will call handler when deployed");

    vertx.deployVerticle(new EventBusReceiverVerticle("Получатель 1"), ar -> {
      log(new Throwable(), "EventBusReceiverVerticle 'Получатель 1' deployed, handler called with async result: " + ar.toString());
    });
    log(new Throwable(), "Deploying EventBusReceiverVerticle 'Получатель 1', will call handler when deployed");

    vertx.deployVerticle(new EventBusReceiverVerticle("Получатель 2"), ar -> {
      log(new Throwable(), "EventBusReceiverVerticle 'Получатель 2' deployed, handler called with async result: " + ar.toString());
    });
    log(new Throwable(), "Deploying EventBusReceiverVerticle 'Получатель 2', will call handler when deployed");

    /*
    log(new Throwable(), "Sleeping 2000 ms");
    Thread.sleep(2000);
    */

    vertx.deployVerticle(new EventBusSenderVerticle(), ar -> {
      log(new Throwable(), "EventBusSenderVerticle deployed, handler called with async result: " + ar.toString());
    });
    log(new Throwable(), "Deploying EventBusSenderVerticle, will call handler when deployed");

    log(new Throwable(), "Done");

  }

  @Override
  public void stop() throws Exception {
    log(new Throwable(), "Done");
  }

  private void log(Throwable thr, String msg) {
    String cn = this.getClass().getSimpleName();
    String mn = thr.getStackTrace()[0].getMethodName();
    String tn = Thread.currentThread().getName();
    System.out.println(LocalDateTime.now() + " " + tn + " " + cn + "::" + mn + " " + msg);
  }

}
