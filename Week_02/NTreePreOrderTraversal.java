package com.carol.practice.geekbang.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N叉数的前序遍历：取根节点的值--->左子树遍历--->右子树的变量
 */
public class NTreePreOrderTraversal {
    public List<Integer> preOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    /**
     * 递归算法
     * @param root
     * @param result
     */
    public void preOrderTraversal(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        List<Node> children = root.children;
        for(int i = 0; i < children.size(); i++){
            preOrderTraversal(children.get(i), result);
        }
    }

    /**
     * 迭代算法
     * @param root
     * @param result
     */
    public void preOrderTraversal1(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            result.add(node.val);
            if(node.children != null && node.children.size() > 0){
                for(int i = node.children.size() - 1; i >= 0; i--){
                    stack.addLast(node.children.get(i));
                }
            }
        }
    }

    public final class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
