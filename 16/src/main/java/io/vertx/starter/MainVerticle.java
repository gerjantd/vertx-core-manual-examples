package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;


public class MainVerticle extends AbstractVerticle {

  private NetServer tcpServer = null;

  @Override
  public void start() throws Exception {
    tcpServer = vertx.createNetServer();
    tcpServer.connectHandler(new Handler<NetSocket>() {
      @Override
      public void handle(NetSocket netSocket) {
        System.out.println("Incoming connection!");
        netSocket.handler(new Handler<Buffer>() {
          @Override
          public void handle(Buffer inBuffer) {
            System.out.println("Incoming data: "+inBuffer.length());
            String data = inBuffer.getString(0,inBuffer.length());
            Buffer outBuffer = Buffer.buffer();
            outBuffer.appendString("response...");
            netSocket.write(outBuffer);
          }
        });
      }
    });
    tcpServer.listen(10000);
  }

  @Override
  public void stop() throws Exception {
    tcpServer.close();
  }

}

