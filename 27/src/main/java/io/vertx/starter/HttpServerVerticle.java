package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class HttpServerVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        .end("Hello from Vert.x!");
      System.out.println(LocalDateTime.now() + " (Handler::handle): Request received, handler called with request");
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        System.out.println(LocalDateTime.now() + " (Handler::handle): HTTP server verticle started and listening on port 8888, handler called with 'succeeded' async result: " + http.toString());
      } else {
        startPromise.fail(http.cause());
        System.out.println(LocalDateTime.now() + " (Handler::handle): HTTP server verticle did not start, handler called with 'failed' async result: " + http.toString());
      }
    });
    System.out.println(LocalDateTime.now() + " HTTPServerVerticle::start: Done");
  }

  @Override
  public void stop() throws Exception {
    System.out.println(LocalDateTime.now() + " HTTPServerVerticle::stop: Done");
  }

}
