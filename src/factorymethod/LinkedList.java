package factorymethod;

public class LinkedList<T> implements List<T>{
    private int size;
    private Node<T> root;
    @Override
    public Iterator iterator() {
        return new LinkedIterator();
    }

    @Override
    public boolean add(T o) {
        if(size == 0){
            root = new Node<T>(o,null);
            size ++;
            return true;
        }else{
            Node<T> p = root;
            while(p.next != null){
                p = p.next;
            }
            p.next = new Node(o,null);
            size ++;
            return true;
        }
    }
    private static class Node<T>{
        T data;
        Node next;
        Node(T t,Node next){
            this.data = t;
            this.next = next;
        }
    }

    private class LinkedIterator implements Iterator<T>{
        private Node<T> next;
        LinkedIterator(){
            next = root;
        }
        @Override
        public boolean hasNext() {
            return (next != null);
        }

        @Override
        public T next() {
            T data = next.data;
            next = next.next;
            return data;
        }
    }
}