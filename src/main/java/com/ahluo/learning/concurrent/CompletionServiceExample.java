package com.ahluo.learning.concurrent;

import com.ahluo.learning.entity.Ahluo;
import com.ahluo.learning.entity.AhluoCompute;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <pre>
 *      Get result with BlockQueue
 * </pre>
 *
 * @author Ahluo on 2016-8-29.
 */
public class CompletionServiceExample {
    private static ExecutorService executorService = Executors.newFixedThreadPool(4);
    private static CompletionService<Ahluo> completionService = new ExecutorCompletionService(executorService);
    private static Random random = new Random();

    public static void main(String[] args) {
        List<Future<Ahluo>> results = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int b = (i + 1) * 5;
            results.add(completionService.submit(() -> new AhluoCompute(b).compute()));
        }

        CyclicBarrier resultBarrier = new CyclicBarrier(1);

        //first method get result
        for (int i = 0; i < 4; i++) {
            try {
                Ahluo ahluo = completionService.take().get();
                System.out.println(ahluo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        try {
            resultBarrier.await();
            System.out.println("First Compute is All Over.");
        } catch (Exception e) {
        }
        //second method get result
        results.parallelStream().forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
