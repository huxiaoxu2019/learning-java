// https://ke.qq.com/webcourse/index.html#cid=399017&term_id=100475965&taid=8942585767138985
package com.ihuxu.learning.java.msb20200424;

public class T01_CacheLinePadding {
    public static volatile long[] arr = new long[16];
    public static void main(String args[]) throws  Exception {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 10_0000_0000L; ++i) {
                arr[0] = i;
            }
        });
        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 10_0000_0000L; ++i) {
                arr[1] = i;
            }
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println((System.nanoTime() - start) / 100_0000) ;
    }
}
