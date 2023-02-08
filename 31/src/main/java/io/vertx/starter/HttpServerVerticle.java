package io.vertx.starter;

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.time.LocalDateTime;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class HttpServerVerticle extends AbstractVerticle {

  private static final Map<String, String> miscGoodTimes;
  static {
    Map<String, String> map = new HashMap<>();
    map.put("1324", "not really, just a test");
    map.put("1327", "просто так (тест)");
    map.put("1234", "sequence");
    map.put("1248", "4 consecutive powers of 2");
    map.put("1729", "Ramanujan's taxicab number");
    miscGoodTimes = Collections.unmodifiableMap(map);
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    vertx.createHttpServer().requestHandler(req -> {
      req.response()
        .putHeader("content-type", "text/plain")
        //.end("Hello from Vert.x!");
        .end(getVerboseTime(true));
      log(new Throwable(), "Request received, handler called with request: " + req.toString());
    }).listen(8888, http -> {
      if (http.succeeded()) {
        startPromise.complete();
        log(new Throwable(), "HTTP server verticle started and listening on port 8888, handler called with 'succeeded' async result: " + http.toString());
      } else {
        startPromise.fail(http.cause());
        log(new Throwable(), "HTTP server verticle failed to start, handler called with 'failed' async result: " + http.toString());
      }
    });
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

  private String getVerboseTime(boolean explain) {
    LocalDateTime now = LocalDateTime.now();
    String hh = String.format("%02d", now.getHour());
    String mm = String.format("%02d", now.getMinute());
    String msg = hh + mm;
    if (hh.equals(mm)) {
      msg = msg + " - good time!" + (explain?" (minute equals hour)":"");
    } else if (hh.equals(new StringBuilder(mm).reverse().toString())) {
      msg = msg + " - good time!" + (explain?" (palindrome)":"");
    } else if (miscGoodTimes.get(msg) != null) {
      msg = msg + " - good time!" + (explain?" (" + miscGoodTimes.get(msg) + ")":"");
    }
    return msg;
  }

}
