package io.vertx.starter;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;

public class VertxApp {

  public static void main(String[] args) throws InterruptedException {

    // Create Vertx instance
    Vertx vertx = Vertx.vertx();

    // 1. Deploy verticle by passing verticle instance
    vertx.deployVerticle(new BasicVerticle());

    // 2. Deploy verticle by passing fully qualified class name
    vertx.deployVerticle("io.vertx.starter.BasicVerticle");

    // 3. Deploy verticle as 1., but also passing Handler implementation
    // Verticles are deployed async, handler will be called when deployment is complete
    vertx.deployVerticle(new BasicVerticle(), new Handler<AsyncResult<String>>() {
      @Override
      public void handle(AsyncResult<String> stringAsyncResult) {
        System.out.println("BasicVerticle deployment complete");
      }
    });

    // 4. Deploy verticle as 3., using a lambda
    vertx.deployVerticle(new BasicVerticle(), stringAsyncResult -> {
      System.out.println("BasicVerticle deployment complete");
    });

  }

}
