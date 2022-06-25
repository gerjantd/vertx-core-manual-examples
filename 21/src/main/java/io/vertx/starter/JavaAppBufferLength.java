package io.vertx.starter;

import io.vertx.core.buffer.Buffer;

public class JavaAppBufferLength {

  public static void main(String[] args) throws InterruptedException {

    Buffer buffer = Buffer.buffer();
    System.out.println("buffer length: "+buffer.length());

  }

}
