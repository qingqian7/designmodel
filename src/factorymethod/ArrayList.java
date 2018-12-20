package factorymethod;

public class ArrayList<T> implements List<T>{
    private int size ;
    private Object[] defaultList;
    private static final int defalutSize = 10;//默认长度
    public ArrayList(){
        defaultList = new Object[defalutSize];
    }
    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public boolean add(T t) {
        if(size < defalutSize){
            defaultList[size++] = t;
            return true;
        }
        return false;
    }
    private class ArrayIterator implements Iterator<T>{
        private int next;
        @Override
        public boolean hasNext() {
            return next < size;
        }

        @Override
        public T next() {
            return (T) defaultList[next++];
        }
    }
}
