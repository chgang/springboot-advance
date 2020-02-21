package com.qskx.interviewer.arithmetic;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ProjectName: springboot-advance
 * @ClassName: LinkedListReplica
 * @Author: cg
 * @CreateDate: 2020-02-16 20:22
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class ListNode {
    Integer val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            throw new RuntimeException();
        }
        Map<Integer,Integer> elementMap = new LinkedHashMap<>();
        ListNode curNode = head;
        while(curNode != null) {
            Integer num = elementMap.get(curNode.val);
            if(num == null) {
                elementMap.put(curNode.val, 1);
            } else {
                elementMap.put(curNode.val, 1 + num);
            }
            curNode = curNode.next;
        }
        ListNode newList = null;
        ListNode tempList = null;
        for(Map.Entry<Integer, Integer> entry : elementMap.entrySet()) {
            if(entry.getValue() == 1) {
                ListNode curList = new ListNode(entry.getKey(), null);
                if(newList == null) {
                    newList = curList;
                } else {
                    tempList.next = curList;
                }
                tempList = curList;
            }
        }
        return newList;
    }
}
