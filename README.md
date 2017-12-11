# Play with Lagom service API example (Java)

This is an example of how to use the Lagom service API to define a router in Play.

Note: this does not follow Lagom conventions of having separate `api` and `impl` projects, but it could easily be altered to do so. The goal here is to demonstrate the simplest possible project using the Lagom service API.

For service location, this example uses the [`ConfigurationServiceLocator`](https://www.lagomframework.com/documentation/1.4.x/java/ProductionOverview.html#Using-static-values-for-services-and-Cassandra-to-simulate-a-managed-runtime), which locates services based on static configuration. The service in the example does not need to locate other services, so this is just to satisfy the dependency for Lagom.

Use `sbt run`, `gradle -t runPlayBinary` or `mvn play2:run` to run in dev mode.
