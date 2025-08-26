import java.util.Arrays;

/**
 * @author vladimir_shi
 * @since 26.08.2025
 *
 * Design a HashSet without using any built-in hash table libraries.
 * Implement MyHashSet class:
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet.
 * If key does not exist in the HashSet, do nothing.
 *
 */

class MyHashSet {

    int[] arraySet;
    int count;

    public MyHashSet() {
        this.arraySet = new int[10];
        Arrays.fill(arraySet, -1);
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }

        if (count == arraySet.length){
            int[] newSet = new int[arraySet.length * 2];
            Arrays.fill(newSet, -1);
            for (int i = 0; i < arraySet.length; i++) {
                newSet[i] = arraySet[i];
            }
            arraySet = newSet;
        }

        while (true) {
            int index = (int)(Math.random() * (arraySet.length));
            if (arraySet[index] == -1) {
                arraySet[index] = key;
                count++;
                return;
            }
        }
    }

    public void remove(int key) {
        for (int i = 0; i < arraySet.length; i++) {
            if (arraySet[i] == key) {
                arraySet[i] = 0;
                return;
            }
        }
    }

    public boolean contains(int key) {
        for (int i : arraySet) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "arraySet=" + Arrays.toString(arraySet) +
                '}';
    }
}