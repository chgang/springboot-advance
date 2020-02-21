package com.qskx.interviewer.arithmetic;

import java.util.*;

/**
 * @ProjectName: springboot-advance
 * @ClassName: JudgeSelect
 * @Author: cg
 * @CreateDate: 2020-02-14 21:47
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class JudgeSelect {

    public static void main(String[] args) {
        int N = 4;
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        System.out.println(findJudge(N, trust));
    }

    /**
     * @Descprition
     * <p>
     *     在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
     *
     * 如果小镇的法官真的存在，那么：
     *
     * 小镇的法官不相信任何人。
     * 每个人（除了小镇法官外）都信任小镇的法官。
     * 只有一个人同时满足属性 1 和属性 2 。
     * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
     *
     * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
     *
     *
     *
     * 示例 1：
     *
     * 输入：N = 2, trust = [[1,2]]
     * 输出：2
     * 示例 2：
     *
     * 输入：N = 3, trust = [[1,3],[2,3]]
     * 输出：3
     * 示例 3：
     *
     * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
     * 输出：-1
     * 示例 4：
     *
     * 输入：N = 3, trust = [[1,2],[2,3]]
     * 输出：-1
     * 示例 5：
     *
     * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= N <= 1000
     * trust.length <= 10000
     * trust[i] 是完全不同的
     * trust[i][0] != trust[i][1]
     * 1 <= trust[i][0], trust[i][1] <= N
     * <p>
     * @author       cg
     * @version      1.0
     * @params:      [N, trust]
     * @return       int
     * @date         2020-02-14 21:57
     */
    public static int findJudge(int N, int[][] trust) {
        if(N < 1 || N > 1000) {
            throw new RuntimeException("N 不合法。");
        }
        if(trust.length <= 0 || trust.length > 1000) {
            throw new RuntimeException("信任组合长度不合法。");
        }
        Map<Integer, Set<Integer>> judgeMap = new HashMap<>();
        for(int i = 0; i < trust.length; i++) {
            if(judgeMap.get(trust[i][1]) == null) {
                Set<Integer> judgeSet = new HashSet<>();
                judgeSet.add(trust[i][0]);
                judgeMap.put(trust[i][1], judgeSet);
            } else {
                judgeMap.get(trust[i][1]).add(trust[i][0]);
            }
        }
        List<Integer> judgeList = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : judgeMap.entrySet()) {
            Set<Integer> valueSet = entry.getValue();
            if (valueSet.size() == N - 1 && !valueSet.contains(entry.getKey())) {
                judgeList.add(entry.getKey());
            }
        }
        return judgeList.size() == 1 ? judgeList.get(0) : -1;
    }
}
