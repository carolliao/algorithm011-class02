package com.carol.practice.geekbang;

/**
 * 1、这是一个循环队列
 * front:指向队列中第一个存放元素的位置
 * rear:指向队列中最后一个存放元素的下一个位置
 * 队列为空：front == rear
 * 队列已满：front == rear也能表示对列已满的情况，这和队列为空条件冲突
 *           因此可以定义成front和rear相差一个元素时就是队列已满的情况
 *           即(rear + 1) % N = front
 *
 * 2、这也是一个双端队列(特性：可以从头或尾添加或删除)
 */
public class MyCircularDeque {
    //通过数组的方式实现
    private int[] arrays = null;
    private int size = 0;
    private int front = 0;
    private int rear = 0;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arrays = new int[k + 1]; //由于在判断队列已满时会留一个空元素，所以需要增加一个数组长度
        front = 0;
        rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        //要先向左移动，始终保持front指向的是第一个实际有效元素的位置
        front = (front - 1 + arrays.length) % arrays.length;
        //再把元素插入front指向位置
        arrays[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        //rear是先存入数据再向右移动
        arrays[rear] = value;
        rear = (rear + 1) % arrays.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        //front向右移动
        front = (front + 1) % arrays.length;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }

        //rear向左移动
        rear = (rear - 1 + arrays.length) % arrays.length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }

        return arrays[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        //这么写主要是防止rear越界
        return arrays[(rear - 1 + arrays.length) % arrays.length];
       // return arrays[rear == 0 ? arrays.length - 1 : rear - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % arrays.length == front;
    }
}
