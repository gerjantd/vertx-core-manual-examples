/*
 * JBoss, Home of Professional Open Source
 * Copyright 2021, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertx.starter;

import java.time.LocalDateTime;

import io.vertx.core.AbstractVerticle;

public class EventBusLoggerVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.eventBus().consumer("message-event", message -> {
      System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusLoggerVerticle received message: " + message.body());
    });
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusLoggerVerticle::start: Done");
   }

  @Override
  public void stop() throws Exception {
    System.out.println(LocalDateTime.now() + " " + Thread.currentThread().getName() + " EventBusLoggerVerticle::stop: Done");
  }

}
