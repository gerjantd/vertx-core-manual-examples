package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  private HttpServer httpServer = null;

  @Override
  public void start() throws Exception {

    httpServer = vertx.createHttpServer();

    httpServer.requestHandler(new Handler<HttpServerRequest>() {
      @Override
      public void handle(HttpServerRequest request) {

        System.out.println("incoming request");

        System.out.println("uri: "+request.uri());
        System.out.println("path: "+request.path());
        System.out.println("param p: "+request.getParam("p"));

        Buffer fullRequestBody = Buffer.buffer();
        if(request.method() == HttpMethod.POST){

            request.handler(new Handler<Buffer>() {
                @Override
                public void handle(Buffer buffer) {
                    fullRequestBody.appendBuffer(buffer);
                    System.out.println("POST request handler: fullRequestBody: "+fullRequestBody);
                }
            });

            request.endHandler(new Handler<Void>() {
                @Override
                public void handle(Void event) {
                  // here you can access the 
                  // fullRequestBody Buffer instance.
                  System.out.println("POST request end handler: fullRequestBody: "+fullRequestBody);
                }
            });
        }
        HttpServerResponse response = request.response();
        response.setStatusCode(200);
        response.headers()
          //.add("Content-Length", String.valueOf(57))
          //.add("Content-Length", String.valueOf(8))
          //.add("Content-Length", String.valueOf(16))
          .add("Content-Length", String.valueOf("Vert.x is alive!".length()))
          .add("Content-Type", "text/html");
        response.write("Vert.x is alive!");
        response.end();
        System.out.println("response sent: "+response);
        // alternatively:
        //response.end("Vert.x is alive!");

      }
    });

    httpServer.listen(8080);
       
  }

  @Override
  public void stop() throws Exception {
    httpServer.close();
  }

}
