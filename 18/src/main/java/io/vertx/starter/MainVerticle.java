package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetSocket;


public class MainVerticle extends AbstractVerticle {

  private NetClient tcpClient = null;

  @Override
  public void start() throws Exception {
    // You create a TCP client by creating an instance of NetClient. You create an instance of NetClient via the Vertx object's method createNetClient(). Here is how you create a NetClient instance:
    tcpClient = vertx.createNetClient();
    // You connect to a remote server by calling the connect() method. Here is how calling the connect() method looks:
    tcpClient.connect(80, "jenkov.com", new Handler<AsyncResult<NetSocket>>() {
      @Override
      public void handle(AsyncResult<NetSocket> result) {
        // You pass the TCP port of the remote server as well as the domain name, and a Handler object which is called when the connection is established. You obtain a reference to the NetSocket connected to the remote server via the AsyncResult instance passed to the handler's handle() method.
        NetSocket socket = result.result();
        // You can write data to the TCP connection via the NetSocket write() method. Here is how that looks:
        socket.write("GET / HTTP/1.1\r\nHost: jenkov.com\r\n\r\n");
        // The write() method is asynchronous and returns immediately. The data may not be sent by the time the write() method returns.
        // The Vert.x NetSocket contains more versions of the write() method which enables you to write e.g. Buffers of data to the NetSocket.
        // In order to read data from the NetSocket you need to register a Handler method on the NetSocket. Here is how you do register a Handler on the NetSocket:
        socket.handler(new Handler<Buffer>() {
          @Override
          public void handle(Buffer buffer) {
            System.out.println("Received data: " + buffer.length());
            System.out.println(buffer.getString(0, buffer.length()));
          }
          // The Handler's handle() method will get called when data is received from the remote server.
        });
      }
    });
  }

  @Override
  public void stop() throws Exception {
    // Once you are finished using the TCP client you need to close it again. You close the TCP client by calling the close() method of the NetClient instance. Here is how that looks:
    tcpClient.close();
    // Again, the NetClient's close() method is asynchronous, so the underlying TCP connection may not yet be closed by the time the close() method returns.
  }

}

