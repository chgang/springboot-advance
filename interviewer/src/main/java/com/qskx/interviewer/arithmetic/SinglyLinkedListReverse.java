package com.qskx.interviewer.arithmetic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @ProjectName: springboot-advance
 * @ClassName: SinglyLinkedListReverse
 * @Author: cg
 * @CreateDate: 2019-09-08 19:52
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class SinglyLinkedListReverse {

    public static void main(String[] args) {

    }

    public static void reverse(SinglyLinkedList linkedList) {
        SinglyLinkedList nextNode = null;
        SinglyLinkedList curNode = linkedList;
        SinglyLinkedList newNode = null;
        while (curNode != null) {
            newNode =curNode.getNext();
            curNode.setNext(nextNode);
            nextNode = curNode;
            curNode = newNode;
        }
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class SinglyLinkedList {
    private SinglyLinkedList next;
    private String element;
}
