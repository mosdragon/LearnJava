import java.lang.reflect.Array;
/**
 * @author Muhammad Osama Sakhi
 * @version 1.1
 */
public class OldSet<T extends Comparable<T>> {

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


    public OldSet(Class<T> type, int initialSize) {
        this.type = type;
        size = 0;
        backingArray = (T[]) createArray(initialSize);
    }

    public OldSet(Class<T> type) {
        this(type, INITIAL_SIZE);
    }

    /**
     * Add the specified entry into the backing array and return true.
     * If the entry already exists, don't add and return false.
     * throw IllegalArgumentException if input is null.
     * @param entry
     * @return
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
     * @param entry
     * @return
     */
    public T remove(Object entry) {
        if (entry == null) {
            throw new IllegalArgumentException("That object is null. Sorry, bud!");
        } else {
            T element = null;
            boolean out = false;
            for (int i = 0; i < backingArray.length; i++) {
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
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= backingArray.length) {
            return null;
        } else {
            T out = backingArray[index];
            size--;
            for (int i = index; i < backingArray.length - 1; i++) {
                backingArray[i] = backingArray[i + 1];
            }
            return out;
        }
    }

    /**
     * Return true if backing array contains the specified entry.
     * Return false otherwise.
     * throw IllegalArgumentException if input is null.
     * @param entry
     * @return
     */
    public boolean contains(T entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Null entry, try again, yo!");
        }
        boolean inside = false;
        for (T item : backingArray) {
            if (item != null && item.equals(entry)) {
                inside = true;
            }
        }
        return inside;
    }

    /**
     * Return a COPY of the backing array.
     * Don't return the backing array.
     * @return
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
     * @return
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
    }

    /**
     * Return the number of non-null objects in the backing array.
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Return string representation of the backing array.
     * Please check the pdf for correct format.
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
     * @return
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