package com.carol.practice.geekbang.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N叉数的后序遍历：左子树遍历--->右子树的变量--->取根节点的值
 */
public class NTreePostOrderTraversal {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    /**
     * 递归算法
     * @param root
     * @param result
     */
    public void postOrderTraversal(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        List<Node> children = root.children;
        for(int i = 0; i < children.size(); i++){
            postOrderTraversal(children.get(i), result);
        }
        result.add(root.val);
    }

    /**
     * 迭代算法
     * @param root
     * @param result
     */
    public void postOrderTraversal1(Node root, List<Integer> result){
        if(root == null){
            return;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            result.add(0, node.val);
            for (Node item:
                 node.children) {
                if(item != null){
                    stack.addLast(item);
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
