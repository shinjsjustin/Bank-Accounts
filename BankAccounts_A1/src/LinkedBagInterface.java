public interface LinkedBagInterface<T> {
    public boolean add(T item);
    public boolean remove();
    public boolean remove(T item);
    public int getSize();
    public int getCount(T item);
    public T[] toArray();
    public boolean contains(T item);

}
