# RateLimiter

## Description

The RateLimiter is a Java-based application that implements a token bucket algorithm to control the rate of requests processed over time.

## Features Expected

- **Token Bucket Algorithm**: Limits the number of requests that can be processed in a given time frame.
- **Dynamic Token Refill**: Automatically refills tokens based on a specified rate.
- **Thread Safety**: Supports concurrent requests safely.
- **Customizable Parameters**: Allows users to set maximum tokens and refill rates.

## Problems Faced

1. **Concurrency Issues**: Ensuring thread safety while modifying token counts led to challenges in synchronization.
2. **Error Handling**: Managing potential errors during request handling required careful design.
3. **Configuration Management**: Deciding how to expose configurable parameters for user customization was initially unclear.

## Tech Stack Used

- **Java 11**: Chosen for its robustness, performance, and modern features that simplify development.
- **Maven**: Used for dependency management and building the project, facilitating easy integration of libraries.
- **Docker**: Provides containerization, making the application portable and easy to deploy across different environments.

### Why These Technologies?

- **Java**: A widely-used language with strong community support and libraries for concurrent programming.
- **Maven**: Streamlines the build process and dependency management, enhancing development efficiency.
- **Docker**: Ensures consistent environments across development, testing, and production, reducing "it works on my machine" issues.

## Troubleshooting

- **Dependency Issues**: Resolved by ensuring that the correct versions of libraries were specified in the `pom.xml`.
- **Build Failures**: Addressed by checking the Maven output logs for errors and ensuring that the JDK was properly configured.
- **Runtime Errors**: Implemented extensive logging to identify issues during execution, which aided in debugging.

## Future Improvements

- **Enhanced Rate Limiting Strategies**: Explore additional algorithms, such as leaky bucket or fixed window counters.
- **Configurable Logging Levels**: Allow users to set logging verbosity to aid in troubleshooting and monitoring.
- **Web Interface**: Develop a simple web UI for easier interaction with the rate limiter.
- **Integration Tests**: Add comprehensive tests to ensure reliability under various load conditions.

