package com.ahluo.learning.concurrent;

import com.ahluo.learning.entity.Ahluo;
import com.ahluo.learning.entity.Compute;

import java.util.concurrent.Callable;

/**
 * <pre>
 *      test callable job
 * </pre>
 *
 * @author Ahluo on 2016-8-29.
 */
public class AhluoJob implements Callable<Ahluo> {
    private Compute<Ahluo, Long> compute;

    public void setCompute(Compute<Ahluo, Long> compute) {
        this.compute = compute;
    }

    @Override
    public Ahluo call() throws Exception {
        return compute.compute();
    }
}
