package io.vertx.starter.app.java;

import java.time.LocalDateTime;

public class NowLoopApp {

	public static void main(String[] args) throws InterruptedException {

		while(true) {
			Thread.sleep(1000);
			System.out.println(LocalDateTime.now());
		}

	}

}
