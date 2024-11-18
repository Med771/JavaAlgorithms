package com.example.skyproakgorithms;

public class StringListImpl implements StringList {
    private String[] list;
    private final int CONST_SIZE = 100_000;
    private int size = CONST_SIZE;
    private int index = 0;

    public StringListImpl() {
        list = new String[CONST_SIZE];
    }

    // Methods
    public String add(String s) {
        updateSize();

        list[index] = s;
        index++;

        return s;
    }

    public String add(int i, String s) {
        if (i >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        updateSize();

        int p_i = 0;
        String[] new_list = new String[CONST_SIZE];

        for (String str: list) {
            if (p_i == i) {
                new_list[p_i] = s;
                p_i++;
            }

            new_list[p_i] = str;
        }

        index++;
        list = new_list;

        return s;
    }

    public String set(int i, String s) {
        if (i >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        list[i] = s;

        return s;
    }

    public String remove(String s) {
        String[] new_list = new String[CONST_SIZE];
        String ans = "";
        boolean found = false;

        for (String str: list) {
            if (str == null) {
                break;
            }

            if (str.equals(s)) {
                found = true;
                ans = str;
            }
        }

        if (found) {
            list = new_list;
            index--;
            return ans;
        }

        throw new StringIndexOutOfBoundsException("Index out of bounds");
    }

    public String remove(int i) {
        String[] new_list = new String[CONST_SIZE];
        String ans = "";
        boolean found = false;
        int p_i = 0;

        for (String str: list) {
            if (p_i == i) {
                found = true;

                ans = str;
                continue;
            }

            new_list[p_i] = str;
            p_i++;
        }

        if (found) {
            list = new_list;
            index--;
            return ans;
        }

        throw new StringIndexOutOfBoundsException("Index out of bounds");
    }

    public boolean contains(String s) {
        for (String str: list) {
            if (str.equals(s)) {
                return true;
            }
        }

        return false;
    }

    public int indexOf(String s) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(s)) {
                return i;
            }
        }

        return -1;
    }

    public int lastIndexOf(String s) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i].equals(s)) {
                return i;
            }
        }

        return -1;
    }

    public String get(int i) {
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
        list = new String[CONST_SIZE];
    }

    // Update len method
    private void updateSize() {
        if (index * 2 < size) {
            return;
        }
        String[] newList = new String[list.length * 2];
        size *= 2;

        System.arraycopy(list, 0, newList, 0, list.length);

        list = newList;
    }

    @Override
    public String[] toArray() {
        return new String[CONST_SIZE];
    }

    @Override
    public boolean equals(StringList arr) {
        if (arr == null) {
            throw new NullPointerException();
        }

        if (this.size() != arr.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if (!arr.get(i).equals(this.list[i])) {
                return false;
            }
        }

        return true;
    }
}
