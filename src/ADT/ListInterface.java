package ADT;

public interface ListInterface<T> {

    public boolean add(T newEntry);

    public int size();
    
    public boolean add(int newPosition, T newEntry);

    public void clear();

    public boolean contains(T anEntry);

    public T getEntry(int givenPosition);

    public int containsposition(T anEntry);

    public boolean isEmpty();

    public T remove(int givenPosition);

    public boolean replace(int givenPosition, T newEntry);

    public int getNumberOfEntries();

}
