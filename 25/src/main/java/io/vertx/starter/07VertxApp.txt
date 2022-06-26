package io.vertx.starter;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class VertxApp {

  public static void main(String[] args) throws InterruptedException {

    System.out.println("## 1. Create a Vertx instance");

    Vertx vertx = Vertx.vertx();
    System.out.println("1.1. Created a Vertx instance");

    System.out.println("## 2. Various ways of deploying BasicVerticle instances");

    vertx.deployVerticle(new BasicVerticle());
    System.out.println("2.1. Deployed BasicVerticle by passing verticle instance");

    vertx.deployVerticle("io.vertx.starter.BasicVerticle");
    System.out.println("2.2. Deployed BasicVerticle by passing fully qualified class name");

    vertx.deployVerticle(new BasicVerticle(), new Handler<AsyncResult<String>>() {
      @Override
      public void handle(AsyncResult<String> stringAsyncResult) {
        System.out.println("2.3. BasicVerticle deployment complete");
      }
    });
    System.out.println("2.3. Deployed BasicVerticle as 1., but also passing Handler implementation");
    System.out.println("     Verticles are deployed async, handler will be called when deployment is complete");

    vertx.deployVerticle(new BasicVerticle(), stringAsyncResult -> {
      System.out.println("2.4. BasicVerticle deployment complete");
    });
    System.out.println("2.4. Deployed BasicVerticle as 3., but using a lambda");

    System.out.println("## 3. Deploying FirstVerticle, deploying SecondVerticle in turn");

    vertx.deployVerticle(new FirstVerticle(), stringAsyncResult -> {
      System.out.println("3.1. FirstVerticle deployment complete");
    });
    System.out.println("3.1. Deployed FirstVerticle");

    System.out.println("## 4. Deploying HttpServerVerticle");

    vertx.deployVerticle(new HttpServerVerticle(), stringAsyncResult -> {
      System.out.println("4.1. HttpServerVerticle deployment complete");
    });
    System.out.println("4.1. Deployed HttpServerVerticle");

  }

}
