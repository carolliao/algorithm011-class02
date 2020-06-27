package com.carol.practice.geekbang;

public class MergeOrderLinkedList {

    /**
     * 时间复杂度：O(m + n) 空间复杂度：O(m + n)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode list = new ListNode();
        ListNode tmp = list;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                list.val = l1.val;
                l1 = l1.next;
            }else {
                list.val = l2.val;
                l2 = l2.next;
            }
            if(l1 != null && l2 != null) {
                list.next = new ListNode(-1);
                list = list.next;
            }
        }

        if(l1 != null) {
            list.next = l1;
        }else {
            list.next = l2;
        }

        return tmp;
    }

    /**
     * 迭代解法
     * 时间复杂度：O(m + n) 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode list = new ListNode();
        ListNode tmp = list;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            }else {
                list.next = l2;
                l2 = l2.next;
            }

            list = list.next;
        }

        if(l1 != null) {
            list.next = l1;
        }else {
            list.next = l2;
        }

        return tmp.next;
    }

    /**
     * 递归解法
     * 1、退出条件：l1或l2为null
     * 2、当前处理逻辑：判断l1和l2节点值的大小，值小的节点，就是使用它的下一个节点值和值大的节点继续比较
     *
     * 3、下一层逻辑：
     *
     * 4、返回状态：返回值小的节点
     *
     * 时间复杂度：O(m + n) 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }



    public static final class ListNode{
        public int val;
        public ListNode next;

        public ListNode(){

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode node) {
            this.val = val;
            this.next = node;
        }
    }
}
