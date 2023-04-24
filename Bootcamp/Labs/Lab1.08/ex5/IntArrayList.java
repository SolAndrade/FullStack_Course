package ex5;

public class IntArrayList implements IntList {
    private int[] arr;
    private int size;

    public IntArrayList() {
        this.arr = new int[10];
        this.size = 0;
    }

    @Override
    public void add(int nbr) {
        if (size == arr.length) {
            int[] newArr = new int[arr.length + (arr.length / 2)];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[size] = nbr;
        size++;
    }

    @Override
    public int get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[idx];
    }
}
