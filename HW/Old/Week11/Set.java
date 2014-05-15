import java.lang.reflect.Array;
/**
 * A Set stores generic types that extend/implement the Comparable
 * interface. In a set, no two elements are the same, and the set
 * can be sorted using the generic type's built-in compareTo method.
 * The generic type of the Set must be a class that implements/extends
 * the Comparable interface.
 * @author Muhammad Osama Sakhi
 * @version 1.1
 */
public class Set<T extends Comparable<T>> {

    /**
     * DO NOT MODIFY
     */
    private T[] sortedArray;

    /**
     * DO NOT MODIFY
     */
    private Class<T> type;

    /**
     * DO NOT MODIFY
     */
    private static final int INITIAL_SIZE = 10;

    private int size;
    private T[] backingArray;

    /**
     * Constructor for the Set. Takes input of a class type and an initial
     * size to create the backing array. As a safety precaution, if this size
     * is input as an integer less than 1, the initial size defaults to 10.
     * @param type, the Class type
     * @param initialSize, the initial size of the backing array for the set
     */
    public Set(Class<T> type, int initialSize) {
        this.type = type;
        size = 0;
        if (initialSize <= 0) {
            initialSize = INITIAL_SIZE;
        }
        backingArray = createArray(initialSize);
    }
    /**
     * Constructor for the set. Takes in a class type as input and uses the
     * other constructor with a default INITIAL_SIZE passed as the initial
     * size of the set.
     * @param type, the Class type
     */
    public Set(Class<T> type) {
        this(type, INITIAL_SIZE);
    }

    /**
     * Add the specified entry into the backing array and return true.
     * If the entry already exists, don't add and return false.
     * throw IllegalArgumentException if input is null.
     * @param entry, an element of generic type T
     * @return true if the addition was successful (if the entry was
     * not already in the Set), or false otherwise.
     */
    public boolean add(T entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Sorry, your entry is invalid!");
        } else if (this.contains(entry)) {
            return false;
        } else if (size < backingArray.length) {
            backingArray[size++] = entry;
        } else {
            T[] temp = createArray(backingArray.length * 2);
            for (int i = 0; i < backingArray.length; i++) {
                temp[i] = backingArray[i];
            }
            temp[size++] = entry;
            backingArray = temp;
        }
        return true;
    }

    /**
     * Remove and return the specified entry from the backing array.
     * If the entry doesn't exist, return null.
     * throw IllegalArgumentException if input is null.
     * @param entry, an Object to remove from the Set
     * @return the element removed from the Set, or null if the Object
     * is not in the Set.
     */
    public T remove(Object entry) {
        if (entry == null) {
            throw new IllegalArgumentException("That object"
                + "is null. Sorry, bud!");
        } else {
            T element = null;
            boolean out = false;
            for (int i = 0; i < size; i++) {
                if (backingArray[i] != null && backingArray[i].equals(entry)) {
                    element = backingArray[i];
                    backingArray[i] = null;
                    out = true;
                    size--;
                }
                if (out && i < backingArray.length - 1) {
                    backingArray[i] = backingArray[i + 1];
                }
            }
            //System.out.println(size);
            return element;
        }
    }

    /**
     * Remove and return the entry at specified index from the backing array.
     * If the index is negative or greater than size, return null.
     * @param index, the index of the element to remove from the Set
     * @return the element removed from the Set, or null otherwise
     */
    public T remove(int index) {
        if (index < 0 || index >= backingArray.length) {
            return null;
        } else if (backingArray[index] != null) {
            T out = this.remove(backingArray[index]);
            return out;
        } else {
            return null;
        }
    }

    /**
     * Return true if backing array contains the specified entry.
     * Return false otherwise.
     * throw IllegalArgumentException if input is null.
     * @param entry, an element of type T that may be found in the Set
     * @return true if the set contains entry, false otherwise
     */
    public boolean contains(T entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null entry, try again, yo!");
        }
        boolean inside = false;
        for (T item : backingArray) {
            if (item != null && item.equals(entry)) {
                inside = true;
                return inside;
            }
        }
        return inside;
    }

    /**
     * Return a COPY of the backing array.
     * Don't return the backing array.
     * @return a copy of the backingArray, of type T[]
     */
    public T[] toArray() {
        T[] copy = createArray(backingArray.length);
        for (int i = 0; i < backingArray.length; i++) {
            copy[i] = backingArray[i];
        }
        return copy;
    }

    /**
     * Return true if the backing array is empty.
     * Return false otherwise.
     * @return true if the backing array is empty, false otherwise
     */
    public boolean isEmpty() {
        boolean allEmpty = (size == 0);
        return allEmpty;
    }

    /**
     * Reset the backing array to an empty array
     * of length INITIAL_SIZE
     */
    public void clear() {
        backingArray = createArray(INITIAL_SIZE);
        size = 0;
    }

    /**
     * Return the number of non-null objects in the backing array.
     * @return size, the number of non-null objects in backingArray
     */
    public int size() {
        return size;
    }

    /**
     * Return string representation of the backing array.
     * Please check the pdf for correct format.
     * @return String representation of the backing array
     */
    public String toString() {
        String msg = "The gradebook:\n";
        for (T elem : backingArray) {
            if (elem != null) {
                msg += elem + "\n";
            }
        }
        return msg;
    }



    // DO NOT MODIFY CODE BELOW

    /**
     * IMPORTANT!!
     * Return a generics array of input type and has length
     * equivalent to input size. Use this method to create
     * any new arrays in this class.
     * @param size
     * @return an instance of a T[] array
     */
    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[]) Array.newInstance(type, size);
    }

    /**
     * Return the sorted version of the backing array.
     * @return (T[]) the sorted array
     */
    public T[] sort() {
        if (size == 0) {
            return null;
        }
        sortedArray = createArray(size);
        for (int i = 0; i < size; i++) {
            sortedArray[i] = backingArray[i];
        }
        sort(0, size - 1);
        return sortedArray;
    }

    /**
     * An awesome sorting technique.
     * Can you guess what sort this is?
     * A picture of Aaron is the prize
     * @param start (int)
     * @param end (int)
     */
    private void sort(int start, int end) {
        int firstHalf = start;
        int lastHalf = end;
        int pivotIndex = start + (int) (Math.random() * (end - start));
        T pivot = sortedArray[pivotIndex];
        while (firstHalf <= lastHalf) {
            while (sortedArray[firstHalf].compareTo(pivot) > 0) {
                firstHalf++;
            }
            while (sortedArray[lastHalf].compareTo(pivot) < 0) {
                lastHalf--;
            }
            if (firstHalf <= lastHalf) {
                T temp = sortedArray[firstHalf];
                sortedArray[firstHalf] = sortedArray[lastHalf];
                sortedArray[lastHalf] = temp;
                firstHalf++;
                lastHalf--;
            }
        }
        if (start < lastHalf) {
            sort(start, firstHalf);
        }
        if (firstHalf < end) {
            sort(firstHalf, end);
        }
    }
}