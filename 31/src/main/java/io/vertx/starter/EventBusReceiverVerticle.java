package io.vertx.starter;

import java.time.LocalDateTime;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class EventBusReceiverVerticle extends AbstractVerticle {

  private String name;

  public EventBusReceiverVerticle(String name) {
    this.name = name;
  }

  @Override
  public void start() {
    vertx.eventBus().consumer("Адрес", message -> {
      log(new Throwable(), "'" + this.name + "' received message, handler called with message: " + message.body());
    });
    log(new Throwable(), "Event bus receiver verticle '" + this.name + "' started and registered as consumer for 'Адрес'");
    log(new Throwable(), "Done");
  }

  @Override
  public void stop() throws Exception {
    log(new Throwable(), "Done");
  }

  private void log(Throwable thr, String msg) {
    String cn = this.getClass().getSimpleName();
    String mn = thr.getStackTrace()[0].getMethodName();
    String tn = Thread.currentThread().getName();
    System.out.println(LocalDateTime.now() + " " + tn + " " + cn + "::" + mn + " " + msg);
  }

}
