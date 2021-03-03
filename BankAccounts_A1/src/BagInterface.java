public interface BagInterface <T>{
    public boolean add(T newEntry);
    public boolean remove(T anEntry);
    public boolean remove();
    public boolean contains(T anEntry);
    public int getSize();
    public T[] toArray();
}
