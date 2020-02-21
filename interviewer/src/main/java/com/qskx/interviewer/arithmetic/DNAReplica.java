package com.qskx.interviewer.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: springboot-advance
 * @ClassName: DNAReplica
 * @Author: cg
 * @CreateDate: 2020-02-16 15:16
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class DNAReplica {

    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s).toString());
    }

    /**
     * @Descprition
     * <p>
     * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     *
     * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
     *
     *  
     *
     * 示例：
     *
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
     *
     * @author       cg
     * @version      1.0
     * @params:      [s]
     * @return       java.util.List<java.lang.String>
     * @date         2020-02-16 15:17
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> replicaList = new ArrayList<>();
        if(s.length() < 10) {
            return replicaList;
        }
        Map<String, Integer> replicaMap = new HashMap<>();
        int b = 0;
        int window = 10;
        while((b + window) <= s.length()) {
            String subStr = s.substring(b, b + window);
            Integer num = replicaMap.get(subStr);
            if(num == null) {
                replicaMap.put(subStr, 1);
            } else if(num == 1) {
                replicaList.add(subStr);
                replicaMap.put(subStr, num + 1);
            }
            b++;
        }
        return replicaList;
    }
}
