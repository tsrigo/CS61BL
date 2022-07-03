package deque;

import java.lang.constant.Constable;

public class ArrayDeque<XXX> implements Deque<XXX> {
    /* Invariants
    1. size : the numbers of items
    2. head : the index of the first element; when a ArrayDeque is fulfilled, head = tail + 1
    3. tail : the index of the last element
    */
    final int Init_Size = 8;
    final int Init_Head = 3;
    private XXX[] que;
    private int len, size, head, tail;
    ArrayDeque() {
        que = (XXX[]) new Object[Init_Size];
        size = 0;
        len = Init_Size;
        head = Init_Head;
        tail = Init_Head - 1;
    }

    private void resize(){
        XXX[] new_que = (XXX[]) new Object[2 * len];
        System.arraycopy(que, 0, new_que, 0, tail + 1);
        System.arraycopy(que, head, new_que, len + head, len - head);
        que = new_que;
        head = (head + len) % (2 * len);
        len *= 2;
    }

    @Override
    public void addFirst(XXX item) {
        size ++ ;
        if (que[(head - 1 + len) % len] != null) resize();
        que[(head - 1 + len) % len] = item;
        head = (head - 1 + len) % len;
    }
    @Override
    public void addLast(XXX item){
        size ++ ;
        if (que[(tail + 1 + len) % len] != null) resize();
        que[(tail + 1 + len) % len] = item;
        tail = (tail + 1 + len) % len;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        int index = head;
        for (int i = 0; i < size; i ++ ){
            System.out.print(que[index] + " ");
            index = (index + 1) % len;
        }
        System.out.println();
    }
    @Override
    public XXX removeFirst(){
        if (size == 0) {
            throw new IllegalCallerException("IllegalCaller For NULL Deque !");
        }
        size -- ;
        XXX res = que[head];
        head = (head + 1) % len;
        return res;
    }
    @Override
    public XXX removeLast(){
        if (size == 0) {
            throw new IllegalCallerException("IllegalCaller For NULL Deque !");
        }
        size -- ;
        XXX res = que[tail];
        tail = (tail - 1 + len) % len;
        return res;
    }
    @Override
    public XXX get(int index){
        XXX res = null;
        return res;
    }
    @Override
    public boolean equals(Object o){
        return false;
    }
}
