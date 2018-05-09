import io.vertx.core.Vertx;

public class App {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    System.out.println("Hello vertx object! "+vertx);
  }
}
