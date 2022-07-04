package deque;

import java.lang.constant.Constable;

public class ArrayDeque<XXX> implements Deque<XXX> {
    /* Invariants
    1. size : the numbers of items
    2. head : the index of the first element; when a ArrayDeque is fulfilled, head = tail + 1
    3. tail : the index of the last element
    4. len : the max number of elements that the current deque can contain;
    */
    final int Init_Size = 8;
    final int Init_Head = 3;
    final double ratio = 0.25;
    private XXX[] que;
    private int len, size, head, tail;
    ArrayDeque() {
        que = (XXX[]) new Object[Init_Size];
        size = 0;
        len = Init_Size;
        head = Init_Head;
        tail = Init_Head - 1;
    }

    public int get_len(){
        return this.len;
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

    public String DequetoString() {
        String ans = "";
        for (int i = 0; i < size; i ++ ){
            ans = ans + this.get(i) + " ";
        }
        return ans;
    }

    @Override
    public void printDeque(){
        String ans = DequetoString();
        System.out.println(ans);
    }

    private void narrow(){
        XXX[] new_que = (XXX[]) new Object[len / 2];

        int index = head;
        for (int i = 0; i < size; i ++ ){
            new_que[i] = que[(head + i) % len];
        }
        que = new_que;
        head = 0;
        tail = size - 1;
        len /= 2;
    }
    @Override
    public XXX removeFirst(){
        if (size == 0) {
            throw new IllegalCallerException("IllegalCaller For NULL Deque !");
        }
        size -- ;
        XXX res = que[head];
        que[head] = null;
        head = (head + 1) % len;

        if ((double)size / len < ratio && len >= 64) narrow();
        return res;
    }
    @Override
    public XXX removeLast(){
        if (size == 0) {
            throw new IllegalCallerException("IllegalCaller For NULL Deque !");
        }
        size -- ;
        XXX res = que[tail];
        que[tail] = null;
        tail = (tail - 1 + len) % len;

        if ((double)size / len < ratio && len >= 64) narrow();
        return res;
    }
    @Override
    public XXX get(int index){
        if (index > size){
            throw new IllegalArgumentException("IllegalArgumentException !");
        }
        return que[(head + index) % len];
    }
    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof ArrayDeque<?>)){
            return false;
        }

        ArrayDeque<XXX> otherobj = (ArrayDeque<XXX>) o;

        if (otherobj.size != this.size) return false;

        String s1 = this.DequetoString();
        String s2 = otherobj.DequetoString();

        return s1.equals(s2);
    }
}
