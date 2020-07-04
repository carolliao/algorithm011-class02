package com.carol.practice.geekbang.week2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉数的层序遍历：
 */
public class NTreeLevelOrderTraversal {
    //每一层用一个List进行存放
    //怎么区分一层：当前节点判断它的字节点
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal1(root, result);
        return result;
    }

    /**
     * 基于队列的方式遍历并按层级进行分组
     * 核心点：怎么判断层级？
     * @param root
     * @param result
     */
    public void levelOrderTraversal1(Node root, List<List<Integer>> result){
        if(root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            //记下当前队列中的元素个数，这个个数代表当前层级上的节点个数
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                level.add(node.val);
                //把该节点对应的最节点一次放入队列中
                queue.addAll(node.children);
            }
            result.add(level);
        }
    }

    /**
     * 基于队列遍历出所有节点值
     * @param root
     * @param result
     */
    public void levelOrderTraversal(Node root, List<Integer> result){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            result.add(node.val);
            //把该节点对应的最节点一次放入队列中
            queue.addAll(node.children);
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
