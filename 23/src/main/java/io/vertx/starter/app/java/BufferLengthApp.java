package io.vertx.starter.app.java;

import io.vertx.core.buffer.Buffer;

public class BufferLengthApp {

  public static void main(String[] args) throws InterruptedException {

    Buffer buffer = Buffer.buffer();
    System.out.println("buffer length: "+buffer.length());

  }

}
