package com.example;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RateLimiter {

    private final int maxTokens;       // Maximum bucket capacity (number of requests allowed in a time window)
    private int tokens;                // Current number of tokens in the bucket
    private final long refillRate;     // Token refill rate (in milliseconds)
    private final ScheduledExecutorService scheduler;

    // Constructor
    public RateLimiter(int maxTokens, long refillRate) {
        this.maxTokens = maxTokens;
        this.tokens = maxTokens;        // Initialize the bucket as full
        this.refillRate = refillRate;
        this.scheduler = Executors.newScheduledThreadPool(1);
        startRefilling();
    }

    // Start the token refilling process
    private void startRefilling() {
        scheduler.scheduleAtFixedRate(() -> {
            synchronized (this) {
                if (tokens < maxTokens) {
                    tokens++;   // Add one token per refill interval
                    System.out.println("Refilled one token. Current tokens: " + tokens);
                }
            }
        }, 0, refillRate, TimeUnit.MILLISECONDS); // Refill after every interval
    }

    // Method to check if a request can be processed
    public synchronized boolean allowRequest() {
        if (tokens > 0) {
            tokens--;  // Decrement token count if request is allowed
            System.out.println("Request allowed. Tokens left: " + tokens);
            return true;
        } else {
            System.out.println("Request denied. Not enough tokens.");
            return false;
        }
    }

    // Shutdown the scheduler gracefully
    public void shutdown() {
        scheduler.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1000);  // 5 requests allowed, refilling every second

        // Simulate multiple requests over time
        for (int i = 0; i < 10; i++) {
            boolean allowed = rateLimiter.allowRequest();
            if (allowed) {
                // Simulate request handling
                System.out.println("Handling request " + (i + 1));
            } else {
                System.out.println("Request " + (i + 1) + " was denied.");
            }
            Thread.sleep(500);  // 500ms between requests
        }

        // Shutdown the rate limiter
        rateLimiter.shutdown();
    }
}
