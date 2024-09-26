package DesignPatterns.SingletonDesignPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        List<Future<?>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Submit tasks to the executor service and store the Future objects
        for (int i = 0; i < 100000; i++) {
            Future<?> future = executorService.submit(() -> {
                Singleton instance = Singleton.getClassInstance(); // Access Singleton instance
            });
            futures.add(future); // Add the future to the list
        }

        // Ensure all threads have completed by calling get() on each future
        for (Future<?> future : futures) {
            try {
                future.get(); // This will block until the thread finishes
            } catch (Exception e) {
                e.printStackTrace(); // Handle any exceptions that occurred during execution
            }
        }

        // Shutdown the executor service
        executorService.shutdown();

        System.out.println("Number of instances created: " + Singleton.getInstanceCount());
    }
}
