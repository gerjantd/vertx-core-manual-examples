package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {

    Buffer buffer = Buffer.buffer();
    System.out.println("buffer length: "+buffer.length());

  }

}
