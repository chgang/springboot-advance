package com.qskx.interviewer.arithmetic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * @ProjectName: springboot-advance
 * @ClassName: BinaryTraverse
 * @Author: cg
 * @CreateDate: 2019-09-08 15:11
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
public class BinaryTraverse {

    public static void main(String[] args) {

    }

    public static List<String> preSort(Node node) {
        List<String> letterList = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (nodeStack.isEmpty()) {
            Node parentNode = nodeStack.pop();
            letterList.add(parentNode.getLetter());
            if (parentNode.getRightNode() != null) {
                nodeStack.push(parentNode.getRightNode());
            }
            if (parentNode.getLeftNode() != null) {
                nodeStack.push(parentNode.getRightNode());
            }
        }
        return letterList;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Node {
    private String letter;
    private String name;
    private Node leftNode;
    private Node rightNode;
}
