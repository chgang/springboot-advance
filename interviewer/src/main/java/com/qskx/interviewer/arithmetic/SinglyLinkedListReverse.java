package com.qskx.interviewer.arithmetic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        SinglyLinkedList newNode = null;
        SinglyLinkedList curNode = linkedList;
        SinglyLinkedList tempNode = null;
        while (curNode != null) {
            tempNode =curNode.next;
            curNode.next = newNode;
            newNode = curNode;
            curNode = tempNode;
        }
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class SinglyLinkedList {
    public SinglyLinkedList next;
    public String element;
}
