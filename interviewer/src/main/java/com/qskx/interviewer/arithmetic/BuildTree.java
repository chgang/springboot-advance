package com.qskx.interviewer.arithmetic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: springboot-advance
 * @ClassName: BuildTree
 * @Author: cg
 * @CreateDate: 2020-03-15 21:11
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int preLen = preorder.length;
        int inLen = inorder.length;

        TreeNode parent = new TreeNode(preorder[0], null, null);
        recursionTree(preorder, inorder, 0, preLen - 1, 0, inLen -1, parent);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(parent);
        List<Integer> numList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode == null) {
                numList.add(null);
            }
            if (curNode != null && curNode.left != null) {
                queue.add(curNode.left);
            } else if (curNode != null && curNode.left == null) {
                queue.add(null);
            }
            if (curNode != null && curNode.right != null) {
                queue.add(curNode.right);
            } else if (curNode != null && curNode.right == null) {
                queue.add(null);
            }
            numList.add(curNode == null ? null : curNode.val);
        }
        System.out.println(numList.toString());
    }

    /**
     * <p>前序数组首位开始，下标向左移动一步，中序数组末尾开始，下标向右移动，但数组长度始终保持一致
     * <p>前序集合向左移动，每移动一步，拿该元素在中序数组匹配，该元素是中序集合的第几个元素，那么对应
     * 前序集合也是第几个元素，那么该元素的左边就是左树，右边就是右树，右边的第一位必是右节点下标。左元素
     * 通过拿中序集合第一位元素（但是不一定下标为0，中序和前序集合移动之后都会成为一个相对集合）在前序集合
     * 找到对应的下标，如果前序集合的首位下标小于该下标，说明不存在左子树，否则首位元素的下一个元素必是
     * 左子树下标。
     */
    public static void recursionTree(int[] preorder, int[] inorder, int preLow, int preHigh, int inLow, int inHigh, TreeNode parent) {
        // 左右树的父节点，用来分割左右树
        int midIndex = -1;
        // 查询根节点在中序遍历数组的下标;preorder[low]表示父节点
        for(int i = inLow; i <= inHigh; i++) {
            if (inorder[i] == parent.val) {
                midIndex = i;
                break;
            }
        }
        if(midIndex == -1) return;
        // 左叶子节点在前序排列中的下标
        int leftLeafIndex = -1;
        // 查找左节点下标；inorder[inLow]表示左叶子节点
        for (int i = preLow; i <= preHigh; i++) {
            if(inorder[inLow] == preorder[i]) {
                leftLeafIndex = i;
                break;
            }
        }
        if(leftLeafIndex == -1) return;
        // 左节点下标(leftIndex)
        int leftIndex;
        if(preLow < leftLeafIndex && (leftIndex = preLow + 1) <= preHigh){
            TreeNode left = new TreeNode(preorder[leftIndex], null, null);
            parent.left = left;
            /**
             * midIndex必为左右树的中位线，也就是中序集合的高位下标为（midIndex - 1） == inLow + (tempHigh - leftIndex)，
             * 而前序集合的高位下标则为midIndex + preLow - inLow。
             */
            int tempHigh = midIndex + preLow - inLow;
            // 左树
            recursionTree(preorder, inorder, leftIndex, tempHigh, inLow, inLow + (tempHigh - leftIndex), left);
        }
        // 右节点下标
        int rightIndex = preLow == inLow ? midIndex + 1 : preLow + (midIndex - inLow) + 1;
        int tempLow = preLow == inLow ? rightIndex : inLow + rightIndex - preLow;
        if(rightIndex <= preHigh) {
            TreeNode right = new TreeNode(preorder[rightIndex], null, null);
            parent.right = right;
            // 右树
            recursionTree(preorder, inorder, rightIndex, preHigh, tempLow, tempLow + (preHigh - rightIndex), right);
        }

    }

}

