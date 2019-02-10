package io.vertx.starter;

import java.time.LocalDateTime;

public class JavaAppNowLoop {

	public static void main(String[] args) throws InterruptedException {

		while(true) {
			Thread.sleep(1000);
			System.out.println(LocalDateTime.now());
		}

	}

}
