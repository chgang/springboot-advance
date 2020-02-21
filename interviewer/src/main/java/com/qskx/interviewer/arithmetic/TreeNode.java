package com.qskx.interviewer.arithmetic;

import java.util.*;

/**
 * @ProjectName: springboot-advance
 * @ClassName: BinaryTree
 * @Author: cg
 * @CreateDate: 2020-02-14 18:29
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        TreeNode f3r = new TreeNode(7, null, null);
        TreeNode f3l = new TreeNode(15, null, null);
        TreeNode f2r = new TreeNode(20, f3l, f3r);
        TreeNode f2l = new TreeNode(9, null, null);
        TreeNode f1 = new TreeNode(3, f2l, f2r);
        List<List<Integer>> standardList = levelOrderBottom(f1);
        System.out.println(standardList.toString());
    }

    /**
     * @Descprition
     * <p>给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其自底向上的层次遍历为：
     *
     * [
     *   [15,7],
     *   [9,20],
     *   [3]
     * ]
     * <p>
     * @author       cg
     * @version      1.0
     * @params:      [root]
     * @return       java.util.List<java.util.List<java.lang.Integer>>
     * @date         2020-02-14 20:44
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        resultList.add(rootList);
        List<Integer> spiltList = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            List<Integer> floorList = new ArrayList<>();
            if(node.left != null) {
                floorList.add(node.left.val);
                queue.add(node.left);
            }
            if(node.right != null) {
                floorList.add(node.right.val);
                queue.add(node.right);
            }
            resultList.add(floorList);
        }
        return reverseList(resultList);
    }
    public static  List<List<Integer>> reverseList(List<List<Integer>> sourceList) {
        List<List<Integer>> patternList = new ArrayList<>();
        for (int i = sourceList.size() - 1; i >= 0; i--) {
            if (sourceList.get(i) != null && sourceList.get(i).size() != 0) {
                patternList.add(sourceList.get(i));
            }
        }
        return patternList;
    }

    public Map<String, Integer> serialMap = new HashMap<>();
    public List<TreeNode> nodeList = new ArrayList<>();

    /**
     * @Descprition
     * <p>
     *     给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     *
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     *
     * 示例 1：
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   2   4
     *        /
     *       4
     * 下面是两个重复的子树：
     *
     *       2
     *      /
     *     4
     * 和
     *
     *     4
     * @author       cg
     * @version      1.0
     * @params:      [node]
     * @return       java.lang.String
     * @date         2020-02-15 19:36
     */
    public String serial(TreeNode node) {
        String seriNode = "";
        if(node == null) {
            return seriNode;
        }
        seriNode += node.val;
        if(node.left != null) {
            seriNode += serial(node.left);
        }
        if(node.right != null) {
            seriNode += serial(node.right);
        }
        Integer num = serialMap.get(seriNode);
        if(null == num) {
            serialMap.put(seriNode, 1);
        } else if(num == 1) {
            nodeList.add(node);
            serialMap.put(seriNode, ++num);
        }
        return seriNode;
    }
}
