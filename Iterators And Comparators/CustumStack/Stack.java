
import java.util.Iterator;

public class Stack implements Iterable<Integer>{
    private Node top;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node currentNode = top;
            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                int element = this.currentNode.element;

                this.currentNode = this.currentNode.prev;

                return element;
            }


        };
    }


    private class Node{
        private int element;
        private Node prev;

        Node(int element){
            this.element = element;
            this.prev = null;
        }
    }

    public Stack() {
     this.top = null;
    }

    public void push(int element){
        Node newNode = new Node(element);
        if (this.top == null){
            this.top = newNode;
        }else{
            newNode.prev = this.top;
            this.top = newNode;
        }
    }

    public int pop() throws IllegalAccessException {
        if (this.top == null){
            throw new IllegalAccessException("No elements");
        }
        int element = this.top.element;

        this.top = this.top.prev;
        return element;


    }


}
