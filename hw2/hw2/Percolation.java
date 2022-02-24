package hw2;

import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private WeightedQuickUnionUF uf;
    private boolean[] openList;
    private int numPerRow;
    private int openSites;
    private int top;
    private int bottom;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        //uf = new QuickFindUF(N * N + 2);
        uf = new WeightedQuickUnionUF(N * N + 2);
        openList = new boolean[N * N];
        for (int i = 0; i < N * N; i++) {
                openList[i] = false;
        }
        numPerRow = N;
        openSites = 0;
        top = N * N;
        bottom = N * N + 1;
    }

    public void open(int row, int col) {
        if (row < 0 || row >= numPerRow || col < 0 || col > numPerRow) {
            throw new IndexOutOfBoundsException();
        }
        int idx = row * numPerRow + col;
        if (!openList[idx]) {
            openList[idx] = true;
            openSites += 1;
        }
        if (row == 0) {
            uf.union(top, idx);
        }
        if (idx - numPerRow >= 0 && openList[idx - numPerRow]) {
            uf.union(idx, idx - numPerRow);
        }
        if (idx - 1 >= 0 && openList[idx - 1]) {
            uf.union(idx, idx - 1);
        }
        if (idx + 1 < numPerRow * numPerRow && openList[idx + 1]) {
            uf.union(idx, idx + 1);
        }
        if (idx + numPerRow < numPerRow * numPerRow && openList[idx + numPerRow]) {
            uf.union(idx, idx + numPerRow);
        }
        if (row == numPerRow - 1) {
            uf.union(bottom, idx);
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 0 || row >= numPerRow || col < 0 || col > numPerRow) {
            throw new IndexOutOfBoundsException();
        }
        int idx = row * numPerRow + col;
        return openList[idx];
    }

    public boolean isFull(int row, int col) {
        if (row < 0 || row >= numPerRow || col < 0 || col > numPerRow) {
            throw new IndexOutOfBoundsException();
        }
        int idx = row * numPerRow + col;
        return uf.connected(idx, top);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return uf.connected(top, bottom);
    }

    public static void main(String[] args) {
        /**
        Percolation p = new Percolation(5);
        p.open(2, 1);
        p.open(3, 2);
        System.out.println(p.isOpen(2, 1)); // true
        System.out.println(p.isOpen(3, 3)); // false
        p.open(0, 2);
        p.open(1, 2);
        System.out.println(p.isFull(1, 2)); // true
        System.out.println(p.percolates()); // false
        p.open(3, 3);
        System.out.println(p.isFull(3, 3)); // false
        p.open(2, 2);
        System.out.println(p.isFull(3, 3)); // true
        p.open(4, 3);
        System.out.println(p.percolates()); // true
         */
    }
}
