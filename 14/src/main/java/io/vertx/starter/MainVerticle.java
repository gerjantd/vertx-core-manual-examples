package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  private HttpClient httpClient = null;

  @Override
  public void start() throws Exception {

    httpClient = vertx.createHttpClient();

/* https://stackoverflow.com/questions/68570273/why-the-getnow-method-is-undefined-for-the-type-httpclient
    //httpClient.getNow(80, "tutorials.jenkov.com", "/", new Handler<HttpClientResponse>() {
    httpClient.getNow("jsonplaceholder.typicode.com/posts", "/1", new Handler<HttpClientResponse>() {

      @Override
      public void handle(HttpClientResponse response) {
        System.out.println("response received");

        response.bodyHandler(new Handler<Buffer>() {

          @Override
          public void handle(Buffer buffer) {
            System.out.println("response ("+buffer.length()+"): ");
            //System.out.println(buffer.getString(0, buffer.length()));
          }

        });

      }

    });

  }
*/
    httpClient.request(HttpMethod.GET, "http://jsonplaceholder.typicode.com/posts/1", ar1 -> {
      if (ar1.succeeded()) {
        HttpClientRequest request = ar1.result();
        request.send(ar2 -> {
          if (ar2.succeeded()) {
            HttpClientResponse response = ar2.result();
	    System.out.println("response received");
	    response.bodyHandler(new Handler<Buffer>() {
              @Override
              public void handle(Buffer buffer) {
                System.out.println("response ("+buffer.length()+"): ");
                //System.out.println(buffer.getString(0, buffer.length()));
              }
            //context.assertEquals(200, response.statusCode());
            //async.complete();  // <-- signal this test can now terminate
	    });
          }
        });
      }
    });

  }

}
