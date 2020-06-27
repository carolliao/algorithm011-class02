package com.carol.practice.geekbang;

import java.util.Deque;
import java.util.LinkedList;

/**
 * push和addFirst实现的是相同功能,实际上push就是通过addFirst实现的
 * addFirst是将元素放入队列的头部(链表头部)
 * addLast是将元素放入队列的尾部(链表尾部)
 */
public class DequeTest {
    public static void oldVersion(){
        Deque<String> deque = new LinkedList<>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while(deque.size() > 0) {
            System.out.println(deque.pop());
        }

        System.out.println(deque);
    }

    public static void newInterface1Version(){
        Deque<String> deque = new LinkedList<>();
        deque.addLast("a");
        deque.addLast("b");
        deque.addLast("c");
        System.out.println(deque);
        String str = deque.peekLast();
        System.out.println(str);
        System.out.println(deque);
        while(deque.size() > 0){
            System.out.println(deque.pollLast());
        }

        System.out.println(deque);
    }


    public static void newInterface2Version(){
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while(deque.size() > 0){
            System.out.println(deque.pollFirst());
        }

        System.out.println(deque);
    }
}
