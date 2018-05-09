import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class App {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    System.out.println("vertx: "+vertx);
    Vertx vertx2 = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
    System.out.println("vertx2: "+vertx2);
  }
}
