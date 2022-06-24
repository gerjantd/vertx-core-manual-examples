package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.buffer.Buffer;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() throws java.io.UnsupportedEncodingException {

    Buffer buffer1 = Buffer.buffer();
    System.out.println("buffer1 length: "+buffer1.length());
    System.out.println();

    byte[] initialData2 = new byte[]{1, 2, 3};
    Buffer buffer2 = Buffer.buffer(initialData2);
    System.out.println("buffer2 length: "+buffer2.length());
    System.out.println("buffer2 as string: "+buffer2.toString());
    System.out.println();

    byte[] initialData3 = new byte[]{65, 66, 67};
    Buffer buffer3 = Buffer.buffer(initialData3);
    System.out.println("buffer3 length: "+buffer3.length());
    System.out.println("buffer3 as string: "+buffer3.toString());
    System.out.println();

    //

    Buffer buffer4 = Buffer.buffer("initial data");
    System.out.println("buffer4 length: "+buffer4.length());
    System.out.println("buffer4 as string: "+buffer4.toString());
    System.out.println();

    Buffer buffer41= Buffer.buffer("initial data", "UTF-8");
    System.out.println("buffer41 (stored using UTF-8 enc) length: "+buffer41.length());
    System.out.println("buffer41 (stored using UTF-8 enc) as string: "+buffer41.toString());
    System.out.println();

    Buffer buffer42 = Buffer.buffer("initial data", "UTF-16");
    System.out.println("buffer42 (stored using UTF-16 enc) length: "+buffer42.length());
    System.out.println("buffer42 (stored using UTF-16 enc) as string: "+buffer42.toString());
    System.out.println("buffer42 (stored using UTF-16 enc) as string (using UTF-16 enc): "+buffer42.toString("UTF-16"));
    System.out.println();

    //

    Buffer buffer5 = Buffer.buffer("sûreté");
    System.out.println("buffer5 length: "+buffer5.length());
    System.out.println("buffer5 as string: "+buffer5.toString());
    System.out.println();

    Buffer buffer51 = Buffer.buffer("sûreté".getBytes("UTF-8"));
    System.out.println("buffer51 (stored using UTF-8 enc) length: "+buffer51.length());
    System.out.println("buffer51 (stored using UTF-8 enc) as string: "+buffer51.toString());
    System.out.println();

    Buffer buffer52 = Buffer.buffer("sûreté".getBytes("UTF-16"));
    System.out.println("buffer52 (stored using UTF-16 enc) length: "+buffer52.length());
    System.out.println("buffer52 (stored using UTF-16 enc) as string: "+buffer52.toString());
    System.out.println("buffer52 (stored using UTF-16 enc) as string (using UTF-16 enc): "+buffer52.toString("UTF-16"));
    System.out.println();

    //

    Buffer buffer6 = Buffer.buffer();
    System.out.println("buffer6.length() = " + buffer6.length());
    buffer6.setByte  ( 0, (byte)  127);
    System.out.println("buffer6.length() = " + buffer6.length());
    buffer6.setShort ( 2, (short) 127);
    System.out.println("buffer6.length() = " + buffer6.length());
    buffer6.setInt   ( 4,         127);
    buffer6.setLong  ( 8,         127);
    buffer6.setFloat (16,      127.0F);
    buffer6.setDouble(20,      127.0D);
    System.out.println("buffer6.length() = " + buffer6.length());
    System.out.println();

    //

    Buffer buffer7 = Buffer.buffer();
    System.out.println("buffer7.length() = " + buffer7.length());
    buffer7.appendByte  ((byte)  127);
    System.out.println("buffer7.length() = " + buffer7.length());
    buffer7.appendShort ((short) 127);
    System.out.println("buffer7.length() = " + buffer7.length());
    buffer7.appendInt   (        127);
    buffer7.appendLong  (        127);
    buffer7.appendFloat (     127.0F);
    buffer7.appendDouble(     127.0D);
    System.out.println("buffer7.length() = " + buffer7.length());
    System.out.println();

    // http://tutorials.jenkov.com/vert.x/buffers.html:
    // The append...() methods do not need an index as parameter.
    // They always append the data to the end of the Buffer.
    // The length of the Buffer will be 27 after executing this code
    // (because all data following the first byte is inserted from index 1,
    // and not index 2 as in the previous example).
 
    byte   aByte   = buffer7.getByte  ( 0);
    short  aShort  = buffer7.getShort ( 2);
    int    anInt   = buffer7.getInt   ( 4);
    long   aLong   = buffer7.getLong  ( 8);
    float  aFloat  = buffer7.getFloat (16);
/*
    double aDouble = buffer7.getDouble(20);
*/
  }

}
