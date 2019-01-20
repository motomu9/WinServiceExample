package example;

import spark.Service;

public class App {
  // サービス
  private Service service;

  App() {
    this.service = Service.ignite();
  }

  public static void main(String[] args) {
    App app = new App();
    app.run();
  }

  public void run() {
    this.service.get("/hello", (request, response) -> "Hello World..");
  }

  public void stop() {
    this.service.stop();
  }
}
