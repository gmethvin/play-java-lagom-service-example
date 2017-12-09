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
  ServiceCall<NotUsed, String> hello(String id);

  @Override
  default Descriptor descriptor() {
    return named("hello")
        .withCalls(
            pathCall("/hello/:id", this::hello)
        )
        .withAutoAcl(true);
  }
}
