package array;

public class CustomArrayList<T> {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;

    private Object[] elements;
    private int size;

    public CustomArrayList() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
        this.size = 0;
    }

    public CustomArrayList(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("initial capacity can not be negative");
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0 ;
    }

    public void add(T element){
        if(size == elements.length){
            increaseCapacity();
        }
        elements[size++] = element;
    }

    public T get(int index){
        if(index< 0 || index>=size){
            throw new IndexOutOfBoundsException("index out of range" + index);
        }
        return (T)elements[index];
    }

    public void remove(int index){
        if(index< 0 || index>=size){
            throw new IndexOutOfBoundsException("index out of range" + index);
        }
        for(int i = index ; i< size-1; i++){
            elements[i]= elements[i+1];
        }
        elements[--size] = null;
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElement = new Object[newCapacity];
        System.arraycopy(elements, 0, newElement,0, size);
        elements = newElement;
    }

    public void print(){
        for(int i=0; i<size; i++)
        System.out.print(elements[i] + " ");
    }

}
