package io.vertx.starter;

import io.vertx.core.Vertx;

public class JavaAppStartingMainVerticle {

	public static void main(String[] args) throws InterruptedException {

		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new MainVerticle());

	}

}
