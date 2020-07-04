package com.carol.practice.geekbang.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树中序遍历
 */
public class BinaryTreeInorderTraversal {
    /**
     * 递归算法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<Integer> left = inorderTraversal(root.left);
        result.addAll(left);
        result.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        result.addAll(right);


        return result;
    }

    /**
     * 基于栈的迭代算法：
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            //左子树遍历
            while(curNode.left != null){
                stack.addLast(curNode);
                curNode = curNode.left;
            }
            //出栈
            if(!stack.isEmpty()){
                TreeNode node = stack.pollLast();
                result.add(node.val);
                curNode = node.right;
            }
        }

        return result;
    }

    public final class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
