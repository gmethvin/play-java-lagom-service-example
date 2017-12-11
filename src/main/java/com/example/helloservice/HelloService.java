package com.example.helloservice;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;

/**
 * API for the HelloService. This could be separated into another subproject.
 */
public interface HelloService extends Service {
  ServiceCall<NotUsed, WelcomeMessage> hello(String id);
  ServiceCall<NotUsed, WelcomeMessage> welcome();
  ServiceCall<NotUsed, CountMessage> count();

  class WelcomeMessage {
    final String message;
    WelcomeMessage(String message) {
      this.message = message;
    }
  }

  class CountMessage {
    final int count;
    CountMessage(int count) {
      this.count = count;
    }
  }

  @Override
  default Descriptor descriptor() {
    return named("hello")
        .withCalls(
            pathCall("/hello/:id", this::hello),
            pathCall("/", this::welcome),
            pathCall("/count", this::count)
        )
        .withAutoAcl(true);
  }
}
