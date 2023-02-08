package io.vertx.starter;

import java.time.LocalDateTime;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class EventBusSenderVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.eventBus().publish("Адрес", "Сообщене А (published)");
    log(new Throwable(), "Message published to event bus address 'Адрес'");
    vertx.eventBus().send("Адрес", "Сообщене Б (sent)");
    log(new Throwable(), "Message sent to event bus address 'Адрес'");
    log(new Throwable(), "Event bus sender verticle started");
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
