package com.carol.practice.geekbang.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class BinaryTreePreorderTraversal {
    /**
     * 递归算法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            preorderTraversal(root, result);
        }
        return result;
    }

    public void preorderTraversal(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        //先取跟节点值
        result.add(root.val);
        //遍历左子树
        preorderTraversal(root.left, result);
        //遍历右子树
        preorderTraversal(root.right, result);
    }

    /**
     * 基于栈的迭代算法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root != null){
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode currentNode = root;
            while(currentNode != null || !stack.isEmpty()) {
               while(currentNode != null){
                   //1、取根节点的值
                   result.add(currentNode.val);
                   //2、遍历左节点
                   currentNode = currentNode.left;
               }
               //3、左节点为空，遍历右节点
                if(!stack.isEmpty()){
                    TreeNode node = stack.pollLast();
                    currentNode = node.right;
                }
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
