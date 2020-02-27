package com.qskx.interviewer.jvm;

/**
 * @ProjectName: springboot-advance
 * @ClassName: Guarantee
 * @Author: cg
 * @CreateDate: 2020-02-24 17:26
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class Guarantee {

    /**
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */

    /**
     * -XX:+UseSerialGC 串行
     * -XX:+UseParallelGC  -XX:+UseParallelOldGC 并行
     * -XX:+UseParNewGC -XX:+UseConcMarkSweepGC 并发
     */

    /**
     * <p> -XX:+UseSerialGC
     * [GC (Allocation Failure) [DefNew: 7814K->383K(9216K), 0.0037515 secs] 7814K->6527K(19456K), 0.0037710 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
     * Heap
     *  def new generation   total 9216K, used 4643K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf0290f8, 0x00000007bf400000)
     *   from space 1024K,  37% used [0x00000007bf500000, 0x00000007bf55fc90, 0x00000007bf600000)
     *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     *  tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     *    the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
     *  Metaspace       used 2976K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
     */

    /**
     * <p> -XX:+UseParallelGC
     * Heap
     *  PSYoungGen      total 9216K, used 8144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     *   eden space 8192K, 99% used [0x00000007bf600000,0x00000007bfdf4320,0x00000007bfe00000)
     *   from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
     *   to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
     *  ParOldGen       total 10240K, used 4096K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   object space 10240K, 40% used [0x00000007bec00000,0x00000007bf000010,0x00000007bf600000)
     *  Metaspace       used 3055K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 334K, capacity 388K, committed 512K, reserved 1048576K
     */

    /**
     * <p> -XX:+UseParNewGC
     * [GC (Allocation Failure) [ParNew: 7980K->447K(9216K), 0.0034596 secs] 7980K->6591K(19456K), 0.0034794 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
     * Heap
     *  par new generation   total 9216K, used 4709K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
     *   eden space 8192K,  52% used [0x00000007bec00000, 0x00000007bf0297a0, 0x00000007bf400000)
     *   from space 1024K,  43% used [0x00000007bf500000, 0x00000007bf56fda8, 0x00000007bf600000)
     *   to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
     *  tenured generation   total 10240K, used 6144K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
     *    the space 10240K,  60% used [0x00000007bf600000, 0x00000007bfc00030, 0x00000007bfc00200, 0x00000007c0000000)
     *  Metaspace       used 3003K, capacity 4496K, committed 4864K, reserved 1056768K
     *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
     */

    public static final int LEN = 1 << 20;

    public static void main(String[] args) {
        byte[]  allo1,
                allo2,
                allo3,
                allo4;
        allo1 = new byte[LEN * 2];
        allo2 = new byte[LEN * 2];
        allo3 = new byte[LEN * 2];
        allo3 = new byte[LEN * 4];
    }
}
