package com.ahluo.learning.entity;

/**
 * <pre>
 *      Ahluo Compute
 * </pre>
 *
 * @author Ahluo on 2016-8-29.
 */
public class AhluoCompute implements Compute<Ahluo, Long> {
    private int times;

    public AhluoCompute(int times) {
        this.times = times;
    }

    @Override
    public Ahluo compute() {
        long begin = System.currentTimeMillis();
        try {
            if (times > 0)
                Thread.sleep(50 * times);
        } catch (Exception e) {
            //do nothing
        }
        long end = System.currentTimeMillis();
        return Ahluo.getNewInstance()
                .setCurrentName(Thread.currentThread().getName())
                .setDuration(end - begin)
                .setId(Thread.currentThread().getId());
    }
}
