package com.example.skyproakgorithms;

public class IntegerListImpl implements IntegerList {
    private int[] list;
    private final int CONST_SIZE = 100_000;
    private int size = CONST_SIZE;
    private int index = 0;

    public IntegerListImpl() {
        list = new int[CONST_SIZE];
    }

    public int add(int value) {
        updateSize();

        list[index] = value;
        index++;

        return value;
    }

    public int add(int value, int i) {
        if (i >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        updateSize();

        int p_i = 0;
        int[] new_list = new int[CONST_SIZE];

        for (int str: list) {
            if (p_i == i) {
                new_list[p_i] = value;
                p_i++;
            }

            new_list[p_i] = str;
        }

        index++;
        list = new_list;

        return value;
    }

    public int set(int value, int i) {
        if (i >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        list[i] = value;

        return value;

    }

    public int removeItem(int i) {
        int[] new_list = new int[CONST_SIZE];
        int ans = 0;
        boolean found = false;

        for (int n: list) {
            if (n == i) {
                found = true;
                ans = n;
            }
        }

        if (found) {
            list = new_list;
            index--;
            return ans;
        }

        throw new StringIndexOutOfBoundsException("Index out of bounds");
    }

    public int removeByIndex(int i) {
        int[] new_list = new int[CONST_SIZE];
        int ans = 0;
        boolean found = false;
        int p_i = 0;

        for (int n: list) {
            if (p_i == i) {
                found = true;

                ans = n;
                continue;
            }

            new_list[p_i] = n;
            p_i++;
        }

        if (found) {
            list = new_list;
            index--;
            return ans;
        }

        throw new StringIndexOutOfBoundsException("Index out of bounds");
    }

    public boolean contains(int value) {
        for (int n: list) {
            if (n == value) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(int ind) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == ind) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(int ind) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == ind) {
                return i;
            }
        }

        return -1;
    }

    public int get(int i) {
        return list[i];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void clear() {
        index = 0;
        list = new int[CONST_SIZE];
    }

    private void updateSize() {
        if (index * 2 < size) {
            return;
        }
        int[] newList = new int[list.length * 2];
        size *= 2;

        System.arraycopy(list, 0, newList, 0, list.length);

        list = newList;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArray[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArray[i++];
        }
        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public int binarySearch(int item) {
        int l = 0, r = list.length - 1;

        while (r - l > 1) {
            int mid = (l + r) / 2;

            if (list[mid] == item) {
                return mid;
            }

            if (list[mid] > item) {
                r = mid;
            }
            else {
                l = mid;
            }
        }

        if (list[l] == item) {
            return l;
        }
        else {
            return -1;
        }
    }

    @Override
    public int[] toArray() {
        return new int[CONST_SIZE];
    }

    @Override
    public boolean equals(IntegerList arr) {
        if (arr == null) {
            throw new NullPointerException();
        }

        if (this.size() != arr.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if (list[i] == arr.get(i)) {
                return false;
            }
        }

        return true;
    }
}
