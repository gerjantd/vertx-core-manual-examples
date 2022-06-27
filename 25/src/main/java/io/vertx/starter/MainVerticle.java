package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws Exception {

	    vertx.deployVerticle(new PeriodicTimerVerticle());
	    System.out.println(LocalDateTime.now() + " MainVerticle::start: Deployed PeriodicTimerVerticle synchronously, passing a verticle");

	    vertx.deployVerticle(new OnceTimerVerticle(), new Handler<AsyncResult<String>>() {
	    	@Override
	    	public void handle(AsyncResult<String> stringAsyncResult) {
	    		System.out.println(LocalDateTime.now() + " (Handler)::handle: OnceTimerVerticle deployment complete, handler called with async result: " + stringAsyncResult.toString());
	    	}
	    });
	    System.out.println(LocalDateTime.now() + " MainVerticle::start: Deploying OnceTimerVerticle from MainVerticle asynchronously, passing a verticle and a handler - handler will be called when deployment is complete");

	    vertx.deployVerticle(new HttpServerVerticle(), stringAsyncResult -> {
	    	System.out.println(LocalDateTime.now() + " (Handler::handle): HttpServerVerticle deployment complete, handler called with async result: " + stringAsyncResult.toString());
	    });
	    System.out.println(LocalDateTime.now() + " MainVerticle::start: Deploying HttpServerVerticle from MainVerticle asynchronously, passing a verticle and a lambda - handler will be called when deployment is complete");

    System.out.println(LocalDateTime.now() + " MainVerticle::start: Done");

  }

  @Override
  public void stop() throws Exception {
    System.out.println(LocalDateTime.now() + " MainVerticle::stop: Done");
  }
}
