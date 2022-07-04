package deque;

import java.util.LinkedList;

public class LinkedListDeque<XXX> implements Deque<XXX> {

    LinkedList<XXX> que = new LinkedList<>();

    @Override
    public void addFirst(XXX item) {
        que.addFirst(item);
    }

    @Override
    public void addLast(XXX item) {
        que.addLast(item);
    }

    @Override
    public int size() {
        return que.size();
    }

    @Override
    public void printDeque() {
        for (XXX i : que) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @Override
    public XXX removeFirst() {
        if (que.size() == 0) {
            return null;
        }
        return que.removeFirst();
    }

    @Override
    public XXX removeLast() {
        if (que.size() == 0) {
            return null;
        }
        return que.removeLast();
    }

    @Override
    public XXX get(int index) {
        return que.get(index);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof LinkedListDeque<?>)) {
            return false;
        }

        LinkedListDeque<XXX> otherobj = (LinkedListDeque<XXX>) o;
        if (this.size() != otherobj.size()) {
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
