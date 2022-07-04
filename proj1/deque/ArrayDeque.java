package deque;

public class ArrayDeque<XXX> implements Deque<XXX> {
    /* Invariants
    1. size : the numbers of items
    2. head : the index of the first element; when a ArrayDeque is fulfilled, head = tail + 1
    3. tail : the index of the last element
    4. len : the max number of elements that the current deque can contain;
    */
    final double ratio = 0.25;
    private XXX[] que;
    private int len, size, head, tail;

    public ArrayDeque() {
        que = (XXX[]) new Object[8];
        size = 0;
        len = 8;
        head = 3;
        tail = 3 - 1;
    }

    public int getLen() {
        return this.len;
    }

    private void resize() {
        XXX[] newQue = (XXX[]) new Object[2 * len];
        System.arraycopy(que, 0, newQue, 0, tail + 1);
        System.arraycopy(que, head, newQue, len + head, len - head);
        que = newQue;
        head = (head + len) % (2 * len);
        len *= 2;
    }

    @Override
    public void addFirst(XXX item) {
        size++;
        if (que[(head - 1 + len) % len] != null) {
            resize();
        }
        que[(head - 1 + len) % len] = item;
        head = (head - 1 + len) % len;
    }

    @Override
    public void addLast(XXX item) {
        size++;
        if (que[(tail + 1 + len) % len] != null) {
            resize();
        }
        que[(tail + 1 + len) % len] = item;
        tail = (tail + 1 + len) % len;
    }

    @Override
    public int size() {
        return size;
    }

    public String dequeToString() {
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans = ans + this.get(i) + " ";
        }
        return ans;
    }

    @Override
    public void printDeque() {
        String ans = dequeToString();
        System.out.println(ans);
    }

    private void narrow() {
        XXX[] newQue = (XXX[]) new Object[len / 2];

        int index = head;
        for (int i = 0; i < size; i++) {
            newQue[i] = que[(head + i) % len];
        }
        que = newQue;
        head = 0;
        tail = size - 1;
        len /= 2;
    }

    @Override
    public XXX removeFirst() {
        if (size == 0) {
            return null;
        }
        size--;
        XXX res = que[head];
        que[head] = null;
        head = (head + 1) % len;

        if ((double) size / len < ratio && len >= 64) {
            narrow();
        }
        return res;
    }

    @Override
    public XXX removeLast() {
        if (size == 0) {
            return null;
        }
        size--;
        XXX res = que[tail];
        que[tail] = null;
        tail = (tail - 1 + len) % len;

        if ((double) size / len < ratio && len >= 64) {
            narrow();
        }
        return res;
    }

    @Override
    public XXX get(int index) {
        if (index > size) {
            throw new IllegalArgumentException("IllegalArgumentException !");
        }
        return que[(head + index) % len];
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof ArrayDeque<?>)) {
            return false;
        }

        ArrayDeque<XXX> otherobj = (ArrayDeque<XXX>) o;

        if (otherobj.size != this.size) {
            return false;
        }

        for (int i = 0; i < otherobj.size(); i++) {
            if (!this.get(i).equals(otherobj.get(i))) {
                return false;
            }
        }
        return true;
    }
}
