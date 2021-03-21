package com.company;

public class Pair implements Comparable<Pair> {
    private int a;
    private int b;

    public Pair() {
    }

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(a, o.a);
    }
}
