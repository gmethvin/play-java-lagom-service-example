package com.example.helloservice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Singleton;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.ServiceCall;

/**
 * Implementation of the HelloService.
 */
@Singleton
public class HelloServiceImpl implements HelloService {

  private final AtomicInteger counter = new AtomicInteger();

  @Override
  public ServiceCall<NotUsed, WelcomeMessage> hello(String id) {
    return request -> CompletableFuture.completedFuture(new WelcomeMessage("Hello " + id));
  }

  @Override
  public ServiceCall<NotUsed, WelcomeMessage> welcome() {
    return request -> CompletableFuture.completedFuture(new WelcomeMessage("Hello!"));
  }

  @Override
  public ServiceCall<NotUsed, CountMessage> count() {
    return request -> CompletableFuture.completedFuture(new CountMessage(counter.incrementAndGet()));
  }
}
