package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  private HttpClient httpClient = null;

  @Override
  public void start() throws Exception {

    httpClient = vertx.createHttpClient();

    httpClient.getNow(80, "tutorials.jenkov.com", "/", new Handler<HttpClientResponse>() {

      @Override
      public void handle(HttpClientResponse response) {
        System.out.println("response received");
      }

    });

  }

}
